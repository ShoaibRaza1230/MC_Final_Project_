package com.example.tableorder.AdminDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tableorder.Orders;
import com.example.tableorder.Tables;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class OrderDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "adminDB";

    private static final String TABLE_NAME="OrderTable";
    private static final String FLOOR_NO= "floorNo";
    private static final String TABLE_NO = "tableNo";
    private static final String ORDER_ID = "ID";
    private static final String ODER_NAME = "Name";
    private static final String ORDER_PRICE = "Price";
    private static final String PRODUCT_TYPE = "Type";
    private static final String PRODUCT_SIZE = "Size";
    private static final String ORDER_STATUS = "Status";

    public OrderDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createOrderTable= "CREATE TABLE " + TABLE_NAME+ "("+ ORDER_ID + " Integer PRIMARY KEY AUTOINCREMENT, "+
                ODER_NAME + " Text, "+ ORDER_PRICE + " Interger, "+ TABLE_NO + " Interger, "+ FLOOR_NO + " Integer, "+
                PRODUCT_TYPE +" Text, "+ PRODUCT_SIZE +" Text, "+ ORDER_STATUS +" int)";
        db.execSQL(createOrderTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public List<Orders> getAllOrder()
    {
        List<Orders> myList=new ArrayList<>();
        String query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ ORDER_STATUS +" == 0";
        SQLiteDatabase DB= this.getReadableDatabase();
        Cursor cursor=DB.rawQuery(query, null);
        if(cursor.moveToFirst())
        {
            do {
                int id=cursor.getInt(0);
                String orderName=cursor.getString(1);
                int pric=cursor.getInt(2);
                int tble=cursor.getInt(3);
                int flor=cursor.getInt(4);
                String ProdType=cursor.getString(5);
                String ProdSize=cursor.getString(6);
                int stats=cursor.getInt(7);
                boolean bool = true;
               // (String name, int price, String type, int table, int floor, boolean status,String size)
                Orders newOrder=new Orders(orderName,pric,ProdType,tble,flor,stats,ProdSize);
                myList.add(newOrder);
            }while (cursor.moveToNext());
        }
        cursor.close();
        DB.close();
        return myList;
    }
    public List<Orders> getAllCompletedOrder()
    {
        List<Orders> myList=new ArrayList<>();
        String query = "SELECT * FROM "+ TABLE_NAME +" WHERE "+ ORDER_STATUS +" == 1";
        SQLiteDatabase DB= this.getReadableDatabase();
        Cursor cursor=DB.rawQuery(query, null);
        if(cursor.moveToFirst())
        {
            do {
                int id=cursor.getInt(0);
                String orderName=cursor.getString(1);
                int pric=cursor.getInt(2);
                int tble=cursor.getInt(3);
                int flor=cursor.getInt(4);
                String ProdType=cursor.getString(5);
                String ProdSize=cursor.getString(6);
                int stats=cursor.getInt(7);
                boolean bool = true;
                // (String name, int price, String type, int table, int floor, boolean status,String size)
                Orders newOrder=new Orders(orderName,pric,ProdType,tble,flor,stats,ProdSize);
                myList.add(newOrder);
            }while (cursor.moveToNext());
        }
        cursor.close();
        DB.close();
        return myList;
    }

    public boolean oderCompleted(String name,int table,int floor)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        try {
            cv.put(ORDER_STATUS, 1);
            String whereClause = "floorNo=? and tableNo=? and Name=?";
            String whereArgs[] = {String.valueOf(floor), String.valueOf(table),name};
            long insert = db.update(TABLE_NAME, cv, whereClause,whereArgs);
            if (insert <=0) { return false; }
            else{return true;}
        }catch (Exception ex)
        {
            return false;
        }

    }
}
