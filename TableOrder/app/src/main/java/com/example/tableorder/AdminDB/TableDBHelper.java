package com.example.tableorder.AdminDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tableorder.Tables;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class TableDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tableDB";
    private static final String TABLE_NAME="tables";

    private static final String TABLE_ID = "ID";
    private static final String FLOOR_NO= "floorNo";
    private static final String TABLE_NO = "tableNo";
    private static final String TABLE_CAPACITY="tableCapacity";
    private static final String TABLE_CODE="tableCode";
    private static final String TABLE_STATUS = "tableStatus";

    public TableDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable= "CREATE TABLE " + TABLE_NAME+ "("+ FLOOR_NO + " Interger, "+ TABLE_NO + " Interger, "+ TABLE_CAPACITY + " Integer, "+ TABLE_STATUS +" Integer, "+TABLE_CODE +" Text, "+" PRIMARY KEY(" + FLOOR_NO + ", " + TABLE_NO +"," + TABLE_CODE +"))";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addTable(Tables tables){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        try {
            cv.put(FLOOR_NO, tables.getFloorNo());
            cv.put(TABLE_NO, tables.getTableNo());
            cv.put(TABLE_CAPACITY, tables.getCapacity());
            cv.put(TABLE_STATUS, tables.isStatus());
            cv.put(TABLE_CODE,tables.getTableCode());
            long insert = db.insert(TABLE_NAME, null, cv);
            if (insert <=0) { return false; }
            else{return true;}
        }catch (Exception ex)
        {
            return false;
        }

    }

    public boolean deleteTable(Tables tables){
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "floorNo=? and tableNo=?";
        String whereArgs[] = {String.valueOf(tables.getFloorNo()), String.valueOf(tables.getTableNo())};
        long delete =db.delete(TABLE_NAME, whereClause, whereArgs);
        if (delete <= 0) { return false; }
        else{return true;}
    }
    public boolean updateTable(Tables tables){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(FLOOR_NO, tables.getFloorNo());
        cv.put(TABLE_NO, tables.getTableNo());
        cv.put(TABLE_CAPACITY, tables.getCapacity());
        long insert = db.insert(TABLE_NAME, null, cv);
        if (insert == -1) { return false; }
        else{return true;}
    }
    public List<Tables> getAllTable()
    {
        List<Tables> myList=new ArrayList<>();
        String query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ TABLE_STATUS +" == 0";
        SQLiteDatabase DB= this.getReadableDatabase();
        Cursor cursor=DB.rawQuery(query, null);
        if(cursor.moveToFirst())
        {
            do {
                int flor=cursor.getInt(0);
                int tableN=cursor.getInt(1);
                int cap=cursor.getInt(2);
                String cod=cursor.getString(4);
                Tables newTables=new Tables(flor,tableN,cap,cod);
                myList.add(newTables);
            }while (cursor.moveToNext());
        }
        cursor.close();
        DB.close();
        return myList;
    }
}
