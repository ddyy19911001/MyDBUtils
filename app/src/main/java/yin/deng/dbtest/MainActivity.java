package yin.deng.dbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shizhefei.db.DBExecutor;
import com.shizhefei.db.sql.Sql;
import com.shizhefei.db.sql.SqlFactory;
import com.shizhefei.db.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayout bts;
    private Button btAdd;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFindView();
    }

    public void oldDbVoid(){
        TestInfo testInfo=new TestInfo();
        testInfo.setAge(22);
        testInfo.setUserName("变化的数据");
        testInfo.setUserPwd("456123");
        DBExecutor executor=DBExecutor.getInstance(this);
        boolean isSaveOk=executor.insert(testInfo);
        if(isSaveOk){
            Sql sql=SqlFactory.find(TestInfo.class).where("userName","=","变化的数据");
            List<Object> testInfo1 = executor.executeQuery(sql);
            LogUtils.w("总共有："+testInfo1.size()+"条数据");
            if(testInfo1!=null&&testInfo1.size()>0){
                Toast.makeText(this,"找到了这个名字为"+((TestInfo)(testInfo1.get(0))).getUserName()+"的对象",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"没有找到对象",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"保存失败了",Toast.LENGTH_LONG).show();
        }
    }

    private void initFindView() {
        bts = (LinearLayout) findViewById(R.id.bts);
        btAdd = (Button) findViewById(R.id.bt_add);
        tvContent = (TextView) findViewById(R.id.tv_content);

    }

    public void add(View view) {
        DBExecutor executor=DBExecutor.getInstance(this);
        MyDbStrBean myDbStrBean=new MyDbStrBean();
        myDbStrBean.setSex("男");
        TestInfo testInfo=new TestInfo();
        testInfo.setAge(52);
        testInfo.setUserName("测试数据");
        myDbStrBean.getTestInfos().add(testInfo);
        myDbStrBean.setListTestInfoStr(executor.listToString(myDbStrBean.getTestInfos()));
        boolean isSaveOk=executor.insert(myDbStrBean);
        tvContent.setText(isSaveOk?"保存成功":"保存失败");
    }

    public void delete(View view) {
        DBExecutor executor=DBExecutor.getInstance(this);
        boolean isDeleteOk=executor.deleteAll(MyDbStrBean.class);
        tvContent.setText(isDeleteOk?"数据全部删除成功":"删除失败");
    }

    public void update(View view) {
        DBExecutor executor=DBExecutor.getInstance(this);
        List<MyDbStrBean> dbStrBeans=executor.findAll(MyDbStrBean.class);
        if(dbStrBeans==null||dbStrBeans.size()==0){
            tvContent.setText("没有任何数据");
        }else{
            tvContent.setText("");
            for(int i=0;i<dbStrBeans.size();i++) {
                String str = dbStrBeans.get(i).getListTestInfoStr();
                List<TestInfo> testInfos=executor.stringToListObj(str,TestInfo.class);
                dbStrBeans.get(i).setTestInfos(testInfos);
            }
            dbStrBeans.get(dbStrBeans.size()-1).setTag("我是更新后的数据");
            boolean isUpdated=executor.updateById(dbStrBeans.get(dbStrBeans.size()-1));
            tvContent.setText(isUpdated?"更新成功":"更新失败");
            if(isUpdated) {
                tvContent.append("\n");
                tvContent.append(dbStrBeans.get(dbStrBeans.size() - 1).toString());
            }
        }
    }

    public void findAll(View view) {
        DBExecutor executor=DBExecutor.getInstance(this);
        List<MyDbStrBean> dbStrBeans=executor.findAll(MyDbStrBean.class);
        if(dbStrBeans==null||dbStrBeans.size()==0){
            tvContent.setText("没有任何数据");
        }else{
            tvContent.setText("");
            for(int i=0;i<dbStrBeans.size();i++) {
                String str = dbStrBeans.get(i).getListTestInfoStr();
                List<TestInfo> testInfos=executor.stringToListObj(str,TestInfo.class);
                dbStrBeans.get(i).setTestInfos(testInfos);
                tvContent.append(dbStrBeans.get(i).toString());
                tvContent.append("\n");
            }
        }
    }
}
