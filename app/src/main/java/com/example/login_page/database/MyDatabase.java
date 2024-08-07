package com.example.login_page.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabase extends SQLiteOpenHelper {

    public MyDatabase(Context context) {
        super(context, "mydata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String table = "CREATE TABLE user (username text unique, email text, password text)";
//        String table = "CREATE TABLE user (username text , email text, password text)";
//                        CREATE TABLE table_name (column_name datatype constraints , , ,)
        db.execSQL(table);


    }

    public void insertdata(String username, String email , String pass)
    {
        try {
            String insert = "INSERT INTO user (username , email , password) VALUES ('" + username + "','" + email + "','" + pass + "')";
//            String insert = "INSERT INTO user (username , email , password) VALUES ('" + "darshan" + "','" + "darshan@gmail.com" + "','" + "darshan@123" +"')";
            getWritableDatabase().execSQL(insert);

            // INSERT INTO table_name (column_name, , ,) VALUES (value, , , )
            // string value ''
        }
        catch (Exception e)
        {
            Log.e("---cr---", "insertdata: "+e );
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
