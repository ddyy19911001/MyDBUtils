package yin.deng.dbtest;

import com.shizhefei.db.annotations.Id;
import com.shizhefei.db.annotations.Table;

@Table(name = "TestInfo")
public class TestInfo {
    @Id(autoIncrement = true)
    private String _id;

    private String userName;

    private String userPwd;

    private int age;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
