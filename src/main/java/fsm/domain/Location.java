package fsm.domain;

/**
 * Created by Mohit on 9/15/2016.
 */
public class Location {
    private String country;
    private String city;
    private String branch;
    private String floor;

    public Location(){}

    public Location(String country, String city, String branch, String floor){
        this.country=country;
        this.city=city;
        this.branch=branch;
        this.floor=floor;
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
