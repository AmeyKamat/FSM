package fsm.parser;

import java.io.File;
import fsm.parser.entities.ParsedFloor;


public interface LayoutFileParser {

	public ParsedFloor parseLayout(File file);

}
