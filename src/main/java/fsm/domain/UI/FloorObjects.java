package fsm.domain.UI;

import fsm.domain.Desk;
import fsm.domain.Floor;
import fsm.domain.Location;
import fsm.domain.Table;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Mohit on 11/16/2016.
 */


public class FloorObjects {


    private  List<Desk> deskList;
    private Floor floor;

    public FloorObjects(){}

    public FloorObjects(List<Desk> deskList, Floor floor) {
        this.deskList = deskList;
        this.floor = floor;
    }

    public List<Desk> getDeskList() {
        return deskList;
    }

    public void setDeskList(List<Desk> deskList) {
        this.deskList = deskList;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public void updateFloor(Location location, String floorCode, List<Table> tableList) {
        this.floor.setFloorCode(floorCode);
        this.floor.setLocation(location);
        this.floor.setTables(new HashSet<Table>(tableList));
    }


}
