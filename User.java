package ATMDemo;

public class User {
    static String idcard = "123456";
    static String password = "123456";

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        User.idcard = idcard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        User.password = password;
    }
}
