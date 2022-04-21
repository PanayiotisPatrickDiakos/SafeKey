package au.edu.unsw.infs3634.gamifiedlearning;

import android.net.Uri;

public class User {
    private String fName, lName, xp, email, password;
    private int badge;
    private String subscribe;

    public User(String fName, String lName, String xp, String email, String password, int badge, String subscribe) {
        this.fName = fName;
        this.lName = lName;
        this.xp = xp;
        this.email = email;
        this.password = password;
        this.badge = badge;
        this.subscribe =subscribe;
    }
    //getters and setters for user profiles

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getXp() {
        return xp;
    }

    public void setXp(String xp) {
        this.xp = xp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }
}
