package fsm.parser;

import fsm.model.domain.Floor;

import java.io.File;

/**
 * Created by Rohit Singh on 19-12-2016.
 */
public interface EmployeeLocationFileParser {

    public void parseEmployeeLocation(File file, Floor floor);

}
