package fsm.parser;

import java.io.File;

import fsm.model.domain.Floor;
import fsm.parser.entities.Layout;


public interface LayoutFileParser {

	public Floor parseLayout(File file);
}
