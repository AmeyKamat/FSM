package fsm.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import fsm.entity.Desk;
import fsm.entity.LayoutData;
import fsm.entity.LayoutExtremes;
import jxl.Cell;
import jxl.CellType;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Created by Sarthak on 13-09-2016.
 */
public class ExcelParser {
	private boolean isValidDesk(Cell cell) {
		if (cell.getContents().isEmpty() || cell.getType() != CellType.NUMBER) {
			return false;
		}
		return true;
	}

	public LayoutData getDesk(String path, String location) {
		int minimumX = 0, minimumY = 0, maximumX, maximumY;
		File workbook = new File(path);
		List<Desk> desks = new ArrayList<Desk>();
		HashSet<Integer> mergedCellsValues = new HashSet<Integer>();
		Workbook w = null;
		try {
			w = Workbook.getWorkbook(workbook);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		Sheet sheet = w.getSheet(0);
		Range mergedCells[] = sheet.getMergedCells();
		maximumX = sheet.getColumns() + 1;
		maximumY = sheet.getRows() + 1;
		for (Range range : mergedCells) {
			Cell topLeft = range.getTopLeft();
			Cell bottomRight = range.getBottomRight();
			if (!isValidDesk(topLeft)) {
				continue;
			}
			int deskID = Integer.parseInt(topLeft.getContents());
			int y = topLeft.getRow();
			int x = topLeft.getColumn();
			int width = 1 + bottomRight.getColumn() - topLeft.getColumn();
			int height = 1 + bottomRight.getRow() - topLeft.getRow();
			String brID = "";
			Desk desk = new Desk(deskID, x, y, width, height, brID, location);
			mergedCellsValues.add(deskID);
			desks.add(desk);

		}
		boolean foundMinimumFlag = false;
		for (int i = 0; i < sheet.getRows(); i++) {
			for (int j = 0; j < sheet.getColumns(); j++) {
				Cell cell = sheet.getCell(j, i);
				if (!foundMinimumFlag) {
					if (!cell.getContents().isEmpty()) {
						minimumX = i;
						minimumY = j;
						foundMinimumFlag = true;
					}
				}
				if (!isValidDesk(cell)) {
					continue;
				}
				int deskID = Integer.parseInt(cell.getContents());
				if (!mergedCellsValues.contains(deskID)) {
					int y = cell.getRow();
					int x = cell.getColumn();
					int width = 1;
					int height = 1;
					String brID = "";
					Desk desk = new Desk(deskID, x, y, width, height, brID, location);
					desks.add(desk);
				}
			}
		}
		LayoutExtremes layoutExtremes = new LayoutExtremes(location, minimumX, minimumY, maximumX, maximumY);
		LayoutData layoutData = new LayoutData(layoutExtremes, desks);
		return layoutData;
	}
}
