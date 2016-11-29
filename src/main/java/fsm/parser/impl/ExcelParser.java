package fsm.parser.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import fsm.parser.LayoutFileParser;
import fsm.parser.entities.Layout;
import fsm.parser.entities.ParsedDesk;
import fsm.parser.entities.ParsedFloor;
import fsm.parser.entities.ParsedTable;
import fsm.parser.exception.ParserException;
import fsm.parser.util.TableGenerator;
import jxl.Cell;
import jxl.CellType;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Component
public class ExcelParser implements LayoutFileParser{

	@Override
	public Layout parse(File file) {
		
		Workbook workbook = this.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		
		ParsedFloor parsedFloor = this.getParsedFloor(sheet);
		List<ParsedDesk> parsedDesks = this.getParsedDesks(sheet);
		List<ParsedTable> parsedTables = new TableGenerator().getParsedTables(parsedFloor, parsedDesks); 
		
		return new Layout(parsedFloor, parsedTables, parsedDesks);
	}

    /* TODO: Needs Restructuring */
	private List<ParsedDesk> getParsedDesks(Sheet sheet) {
		List<ParsedDesk> parsedDesks = new LinkedList<ParsedDesk>();
		Set<String> deskCodesOfMergedCells = new HashSet<String>();
		
		for (Range cell : sheet.getMergedCells()) {
            Cell topLeftCell = cell.getTopLeft();
            Cell bottomRightCell = cell.getBottomRight();
            
            if (isCellAValidDesk(topLeftCell)) {
	            
	            deskCodesOfMergedCells.add(topLeftCell.getContents());
	            parsedDesks.add(
	            		new ParsedDesk(
	            				topLeftCell.getContents(),
	            				topLeftCell.getColumn(),
	            				topLeftCell.getRow(),
	            				bottomRightCell.getColumn() - topLeftCell.getColumn() + 1,
	            				bottomRightCell.getRow() - topLeftCell.getRow() + 1
	            		)
	            );
            }
        }
		
		for (int row = 0; row < sheet.getRows(); row++) {
            for (int column = 0; column < sheet.getColumns(); column++) {
                Cell cell = sheet.getCell(column, row);
                
                if (isCellAValidDesk(cell) && !deskCodesOfMergedCells.contains(cell.getContents())) {
                    parsedDesks.add(
                    		new ParsedDesk(
                    				cell.getContents(), 
                    				cell.getColumn(),
                    				cell.getRow(),
                    				1, 
                    				1
                    		)
                    );
                }
            }
        }
		return parsedDesks;
	}
	
	private ParsedFloor getParsedFloor(Sheet sheet) {
		int maximumX = sheet.getColumns() + 1;
        int maximumY = sheet.getRows() + 1;
        
        int minimumX = 0;
        int minimumY = 0;
        
        for (int row = 0; row < sheet.getRows(); row++) {
            for (int column = 0; column < sheet.getColumns(); column++) {
                Cell cell = sheet.getCell(column, row);
                if (isCellAValidDesk(cell)) {
                    minimumX = row;
                    minimumY = column;
                    break;
                }
            }
        }
        
        return new ParsedFloor(minimumX, minimumY, maximumX, maximumY);
	}


	private Workbook getWorkbook(File file) {
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
		} catch (BiffException be) {
			throw new ParserException(be);
		}
		catch (IOException ioe) {
			throw new ParserException(ioe);
		}
		return workbook;
	}


	private boolean isCellAValidDesk(Cell cell) {
		boolean validDesk = true;
        if (cell.getContents().isEmpty() || cell.getType() != CellType.NUMBER) {
            validDesk = false;
        }
        return validDesk;
    }
	
}
