package yin.deng.dbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.shizhefei.db.DBExecutor;
import com.shizhefei.db.sql.Sql;
import com.shizhefei.db.sql.SqlFactory;
import com.shizhefei.db.utils.LogUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
