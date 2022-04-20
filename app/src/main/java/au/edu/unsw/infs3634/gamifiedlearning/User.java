package au.edu.unsw.infs3634.gamifiedlearning;

public class User {
    private String fName, email, password;

    public User(String fName, String email, String password) {
        this.fName = fName;
        this.email = email;
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
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
}
