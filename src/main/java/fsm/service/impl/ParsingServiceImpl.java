package fsm.service.impl;

import fsm.model.domain.Floor;
import fsm.parser.LayoutFileParser;
import fsm.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ParsingServiceImpl implements ParsingService{

    @Autowired
    LayoutFileParser layoutFileParser;

    @Override
    public Floor parseLayout(File file) {
        return layoutFileParser.parse(file).getFloor();
    }
}
