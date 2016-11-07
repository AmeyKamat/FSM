package fsm.domain;

/**
 * Created by Sarthak on 13-09-2016.
 */
public class Desk {
    private int uId;
    private int deskId;
    private int x,y;
    private int width,height;
    private String brid;
    private String locationId;
    private String hash;
    @Override
    public int hashCode(){
        String hash=x+"|"+y;
        int hashcode=0;
        hashcode+=hash.hashCode();
        return hashcode;
    }
    @Override
    public boolean equals(Object object){
        Desk toCompare=(Desk)object;
        if(object instanceof Desk) {
            if (toCompare.x == this.x && toCompare.y == this.y) {
                return true;
            }
            return false;
        }
        return false;
    }
    public Desk(int deskId, int x, int y, int width, int height, String brid,String locationId) {
        this.deskId = deskId;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.brid = brid;
        this.locationId = locationId;
    }
    public Desk(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Desk() {
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getBrid() {
        return brid;
    }

    public void setBrid(String brid) {
        this.brid = brid;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getDeskId() {
        return deskId;
    }

    public void setDeskId(int deskId) {
        this.deskId = deskId;
    }
}
