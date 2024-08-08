package com.example.login_page.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
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

    public Boolean insertdata(String username, String email, String pass) {
        try {
            String insert = "INSERT INTO user (username , email , password) VALUES ('" + username + "','" + email + "','" + pass + "')";
//            String insert = "INSERT INTO user (username , email , password) VALUES ('" + "darshan" + "','" + "darshan@gmail.com" + "','" + "darshan@123" +"')";
            getWritableDatabase().execSQL(insert);

            return true;
            // INSERT INTO table_name (column_name, , ,) VALUES (value, , , )
            // string value ''
        } catch (Exception e) {
            Log.e("---cr---", "insertdata: " + e);
            return false;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Cursor userlogin(String user, String pass) {

//        String select = "SELECT * FROM user";
//        String select = "SELECT password FROM user";
        String select = "SELECT * FROM user WHERE username = '"+user+"' AND password = '"+pass+"'";

        Cursor cr = getReadableDatabase().rawQuery(select, null);


        return cr;
    }
}
