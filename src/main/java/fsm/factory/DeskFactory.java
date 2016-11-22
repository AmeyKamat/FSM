package fsm.factory;

import fsm.domain.Desk;
import org.springframework.stereotype.Repository;

/**
 * Created by Mohit on 11/16/2016.
 */
@Repository
public class DeskFactory {

public Desk createDesk(String deskID, int x, int  y, int width, int height){
    return new Desk(deskID,x,y,width,height);
}

}
