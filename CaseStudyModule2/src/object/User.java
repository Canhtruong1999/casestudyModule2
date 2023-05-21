package object;

public class User {
    String fullName;
    String userName ;
    String passWord;
    int type;

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }




    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public User setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }

    public int getType() {
        return type;
    }

    public User setType(int type) {
        this.type = type;
        return this;
    }
}
