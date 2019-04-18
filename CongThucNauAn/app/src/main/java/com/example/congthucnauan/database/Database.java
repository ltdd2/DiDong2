package com.example.congthucnauan.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.congthucnauan.BuildConfig;
import com.example.congthucnauan.models.MonAn;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public static final String DBNAME = "dulieu.sqlite";
    String DB_PATH = "";
    private static final int DATABASE_VERSION = 1;
    Context context;
    SQLiteDatabase sqLiteDatabase;
    public Database( Context context) {
        super(context, DBNAME, null, DATABASE_VERSION);
        this.context = context;
        DB_PATH = context.getFilesDir().getParent()+ "/databases/" + DBNAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //Truy vấn không trả kq: CREATE, INSERT,UPDATE,DELETE
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    //Truy vấn trả kết quả: SELECT
    public Cursor GetData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        return database.rawQuery(sql,null);
    }
    public SQLiteDatabase openDatabase(){
        return SQLiteDatabase.openDatabase(DB_PATH,null,SQLiteDatabase.OPEN_READWRITE);
    }

    public void createDatabase(){
        if(KiemTraDatabase()){
            Log.d("Ket Noi","Da co database");
        }else {
            Log.d("Ket Noi","Chua co database");
            this.getWritableDatabase();
            copyDatabase();
        }
    }

    private boolean KiemTraDatabase() {
        SQLiteDatabase kt = null;
        try {
            kt = SQLiteDatabase.openDatabase(DB_PATH,null,SQLiteDatabase.OPEN_READONLY);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(kt != null){
            kt.close();
        }
        return kt != null ? true :  false;
    }
    //Copy database
    private void copyDatabase() {
        try {
            InputStream inputStream = context.getAssets().open(DBNAME);
            OutputStream outputStream = new FileOutputStream(DB_PATH);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<MonAn> getMonAn() {
        MonAn monAn = null;
        List<MonAn> monAns = new ArrayList<>();
        openDatabase();
       Cursor cursor = sqLiteDatabase.rawQuery("select * from MonAn", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            monAn = new MonAn(cursor.getString(10),cursor.getString(1),cursor.getString(2));
            monAns.add(monAn);
            cursor.moveToNext();
        }
        cursor.close();
        return monAns;
    }

}
