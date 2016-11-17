package fsm.domain.UI;

import java.util.List;

/**
 * Created by Mohit on 11/16/2016.
 */
public class UploadInfo {
    List fileItems;
    String fileName;
    int locationId;
    String floorCode;

    public UploadInfo(){}

    public UploadInfo(List fileItems, String fileName, int locationId, String floorCode) {
        this.fileItems = fileItems;
        this.fileName = fileName;
        this.locationId = locationId;
        this.floorCode = floorCode;
    }

    public List getFileItems() {
        return fileItems;
    }

    public void setFileItems(List fileItems) {
        this.fileItems = fileItems;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(String floorCode) {
        this.floorCode = floorCode;
    }


}
