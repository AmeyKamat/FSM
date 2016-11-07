package fsm.domain;

/**
 * Created by Sarthak on 15-09-2016.
 */
public class Users {
    int userUid;
    String id;
    String password;

    public Users(String id, String password) {
        this.id = id;
        this.password = password;
    }
    public Users(){

    }

    public int getUserUid() {
        return userUid;
    }

    public void setUserUid(int userUid) {
        this.userUid = userUid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
