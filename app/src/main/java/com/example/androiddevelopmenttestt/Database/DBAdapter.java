package com.example.androiddevelopmenttestt.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter
{
    private static final String DATABASE_TABLE = "Register";
    public static final String KEY_ROW_ID = "_id";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    SQLiteDatabase mDb;
    Context mCtx;
    DBHelper mDbHelper;

    public DBAdapter(Context context)
    {
        this.mCtx = context;
    }

    public DBAdapter open() throws SQLException
    {
        mDbHelper = new DBHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    public long register(String user,String email,String pw)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_USERNAME, user);
        initialValues.put(KEY_EMAIL, email);
        initialValues.put(KEY_PASSWORD, pw);

        return mDb.insert(DATABASE_TABLE, null, initialValues);
    }

    public boolean Login(String email, String password) throws SQLException
    {
        Cursor mCursor = mDb.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE email=? AND password=?", new String[]{email,password});
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }

    public String getName(String email, String password) throws SQLException
    {
        Cursor mCursor = mDb.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE email=? AND password=?", new String[]{email,password});
        mCursor.moveToFirst();
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                String userName = mCursor.getString(0);
                return userName;
            }
        }
        return "";
    }

}
