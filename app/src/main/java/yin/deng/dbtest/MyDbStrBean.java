package yin.deng.dbtest;

import com.shizhefei.db.annotations.Id;
import com.shizhefei.db.annotations.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "MyDbStrBean")
public class MyDbStrBean {
    @Id
    public long id;
    public String tag;
    public int age;
    public Date date;
    public boolean isVip;
    public String phoneNumber;
    public String sex;
    public List<TestInfo> testInfos=new ArrayList<>();
    public String listTestInfoStr;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getListTestInfoStr() {
        return listTestInfoStr;
    }

    public void setListTestInfoStr(String listTestInfoStr) {
        this.listTestInfoStr = listTestInfoStr;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public List<TestInfo> getTestInfos() {
        return testInfos;
    }

    public void setTestInfos(List<TestInfo> testInfos) {
        this.testInfos = testInfos;
    }

    @Override
    public String toString() {
        return "MyDbStrBean{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", isVip=" + isVip +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sex='" + sex + '\'' +
                ", testInfos=" + testInfos +
                ", listTestInfoStr='" + listTestInfoStr + '\'' +
                '}';
    }
}
