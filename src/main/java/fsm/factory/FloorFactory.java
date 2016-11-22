package fsm.factory;

import fsm.domain.Floor;
import org.springframework.stereotype.Repository;

/**
 * Created by Mohit on 11/16/2016.
 */
@Repository
public class FloorFactory {
    public Floor create(int minimumX, int minimumY, int maximumX, int maximumY) {
    return new Floor(minimumX,minimumY,maximumX,maximumY);
    }
}
