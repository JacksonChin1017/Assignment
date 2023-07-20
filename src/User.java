import java.io.Serializable;

public class User implements Serializable {
    private String userid;
    private String password;

    public User(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public User(){
    }

    @Override
    public String toString() {
        return userid + password;
    }
}
