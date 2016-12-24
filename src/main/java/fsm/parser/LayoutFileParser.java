package fsm.parser;

import java.io.File;
import fsm.model.domain.Floor;

public interface LayoutFileParser {

	public Floor parseLayout(File file);

}
