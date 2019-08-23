package com.shizhefei.db.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.shizhefei.db.table.Table;
import com.shizhefei.db.table.TableFactory;
import com.shizhefei.db.utils.LogUtils;

import java.util.Iterator;
import java.util.Map;

/**
 * 实现DBHelper 继承SQLiteOpenHelper<br/>
 * 子类可以通过继承该类进行监听数据库版本的变化，和数据库创建,用法参照(
 * {@link SQLiteOpenHelper})
 * 
 * @author Administrator
 * 
 */
public class NameDBHelper extends SQLiteOpenHelper implements DBHelper {
	private String path;

	public NameDBHelper(Context context, String name, int version) {
		super(context, name, null, version);
		path = context.getDatabasePath(name).getPath();
	}

	@Override
	public SQLiteDatabase getDatabase() {
		SQLiteDatabase database = null;
		try {
			database = getWritableDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return database;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		LogUtils.w("数据库开始更新了：老版本为："+oldVersion+"\t新版本为："+newVersion);
		Iterator it = TableFactory.getTables().entrySet().iterator();
		int i=0;
		while (it.hasNext()) {
			try {
				Map.Entry entry = (Map.Entry) it.next();
				Table table = (Table) entry.getValue();
				db.execSQL("DROP TABLE IF EXISTS "+table.getTableName());
				i++;
				LogUtils.i("删除第"+i+"个表，表名为："+table.getTableName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			this.onCreate(db);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public String getDatabasePath() {
		return path;
	}
}
