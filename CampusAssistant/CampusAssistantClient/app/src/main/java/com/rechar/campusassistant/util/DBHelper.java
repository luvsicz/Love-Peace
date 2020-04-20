package com.rechar.campusassistant.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;

/**
 * create by bamboo time 2020/4/10
 */
public class DBHelper extends SQLiteOpenHelper {

  private final static int DATABASE_VERSION=1;
  private final static String DATABASE_NAME="user.db";
  private static final String TAG="DBHelper";

  public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
    super(context, name, factory, version);
    Log.e(TAG, "DBHelper: "+context+"\n"+name+"\n"+ "\n"+factory+version);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String sql = "create table[users](" + "[id] AUTOINC,"+
        "[username] VARCHAR(20) NOT NULL," + "[password] VARCHAR(20) NOT NULL,"+
        "constraint [sqlite_autoindex_t_contacts_1] primary key([id]))";
        db.execSQL(sql);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }

  //执行insert,update,delete等SQL语句
  public void execSQL(String sql,Object[] args)
  {
    Log.e(TAG, "sql: " +sql+"arg: "+args);
    SQLiteDatabase db = this.getWritableDatabase();
    db.execSQL(sql, args);

  }
  public Cursor query(String sql, String[] args){
    Log.e(TAG, "sql: " +sql+"arg: "+args);
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(sql, args);
    Log.e(TAG, "query: cursor:"+cursor.moveToFirst() );
    return cursor;
  }

  //  删除数据库
  public boolean deleteDatabase(Context context,String name) {
    return context.deleteDatabase(name);
  }

}
