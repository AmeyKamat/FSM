package fsm.parser;

import fsm.model.domain.Floor;

import java.io.File;

public interface LayoutFileParser {

	public Floor parseLayout(File file);

}
