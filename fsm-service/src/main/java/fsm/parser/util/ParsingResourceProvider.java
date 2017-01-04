package fsm.parser.util;

import fsm.parser.exception.ParserException;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class ParsingResourceProvider {

    public static Workbook getWorkbook(File file) {
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

}
