package yin.deng.dbtest;

import com.shizhefei.db.annotations.Table;

import java.util.ArrayList;
import java.util.List;

@Table(name = "TestBeanTwo")
public class TestBeanTwo {
    public String testName;
    public int scroe;
    public List<MyDbStrBean> strBeans=new ArrayList<>();

    public List<MyDbStrBean> getStrBeans() {
        return strBeans;
    }

    public void setStrBeans(List<MyDbStrBean> strBeans) {
        this.strBeans = strBeans;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getScroe() {
        return scroe;
    }

    public void setScroe(int scroe) {
        this.scroe = scroe;
    }

    @Override
    public String toString() {
        return "TestBeanTwo{" +
                "testName='" + testName + '\'' +
                ", scroe=" + scroe +
                ", strBeans=" + strBeans +
                '}';
    }
}
