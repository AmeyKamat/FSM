package fsm.domain;

/**
 * Created by Sarthak on 15-09-2016.
 */
public class OfficeDetails {
    int officeUid;
    String country;
    String city;
    String branch;
    String floor;
    public OfficeDetails(){

    }
    public OfficeDetails(String country, String city, String branch, String floor) {
        this.country = country;
        this.city = city;
        this.branch = branch;
        this.floor = floor;
    }

    public int getOfficeUid() {
        return officeUid;
    }

    public void setOfficeUid(int officeUid) {
        this.officeUid = officeUid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
