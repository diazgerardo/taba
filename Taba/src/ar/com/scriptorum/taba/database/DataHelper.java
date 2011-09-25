package ar.com.scriptorum.taba.database;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class DataHelper {

	private Context context;
	private SQLiteDatabase db;

	private SQLiteStatement insertStmt;
	private static final String INSERT = "insert into " + Constants.TABLE_NAME
			+ "(name) values (?)";

	public DataHelper(Context context) {
		this.context = context;
		OpenHelper openHelper = new OpenHelper(this.context);
		this.db = openHelper.getWritableDatabase();
		this.insertStmt = this.db.compileStatement(INSERT);
	}

	public long insert(String name) {
		this.insertStmt.bindString(1, name);
		return this.insertStmt.executeInsert();
	}

	public long update(String name, String string) {
		name = string;
		return 0;
	}

	public void deleteAll() {
		this.db.delete(Constants.TABLE_NAME, null, null);
	}

	public List<String> selectAll() {
		List<String> list = new ArrayList<String>();
		Cursor cursor = this.db.query(Constants.TABLE_NAME,
				new String[] { "name" }, null, null, null, null, "name desc");
		if (cursor.moveToFirst()) {
			do {
				list.add(cursor.getString(0));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return list;
	}

}