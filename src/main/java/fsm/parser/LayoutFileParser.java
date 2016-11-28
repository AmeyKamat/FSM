package fsm.parser;

import java.io.File;

import fsm.parser.entities.Layout;


public interface LayoutFileParser {

	public Layout parse(File file);
}
