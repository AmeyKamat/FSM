package fsm.service;

import fsm.model.domain.Floor;

import java.io.File;

public interface ParsingService {
    public Floor parseLayout(File file);
}
