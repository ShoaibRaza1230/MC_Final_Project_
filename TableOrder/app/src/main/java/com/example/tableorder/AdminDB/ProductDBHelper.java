package com.example.tableorder.AdminDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tableorder.Products;
import com.example.tableorder.Tables;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class ProductDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "prodcutDB";
    private static final String TABLE_NAME="product";

    private static final String PRODUCT_ID = "ID";
    private static final String PRODUCT_NAME = "Name";
    private static final String PRODUCT_PRICE = "Price";

    private static final String PRODUCT_ACTUAL_PRICE="ActualPrice";
    private static final String PRODUCT_DISCOUNT = "Discount";
    private static final String PRODUCT_TYPE = "Type";
    private static final String PRODUCT_SIZE = "Size";
    private static final String PRODUCT_STATUS = "Status";

    public ProductDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createProductTable= "CREATE TABLE " + TABLE_NAME+ "("+ PRODUCT_ID + " Integer PRIMARY KEY AUTOINCREMENT, "+
                PRODUCT_NAME + " Text, "+ PRODUCT_PRICE + " Interger, "+ PRODUCT_ACTUAL_PRICE + " Interger, "+ PRODUCT_DISCOUNT + " Integer, "+ PRODUCT_TYPE +" Text, "
                + PRODUCT_STATUS +" BOOL, "+ PRODUCT_SIZE +" Text)";
        db.execSQL(createProductTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean addProduct(Products products){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PRODUCT_NAME, products.getName());
        cv.put(PRODUCT_PRICE, products.getPrice());
        cv.put(PRODUCT_ACTUAL_PRICE, products.getActualPrice());
        cv.put(PRODUCT_DISCOUNT, products.getDiscount());
        cv.put(PRODUCT_TYPE, products.getType());
        cv.put(PRODUCT_STATUS, products.isStatus());
        cv.put(PRODUCT_SIZE, products.getSize());
        long insert = db.insert(TABLE_NAME, null, cv);
        if (insert == -1) { return false; }
        else{return true;}
    }

    public boolean deleteProduct(Products products){
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "Name=? and Type=?";
        String whereArgs[] = {products.getName(), products.getType()};
        long delete =db.delete(TABLE_NAME, whereClause, whereArgs);
        if (delete <= 0) { return false; }
        else{return true;}
    }
    public List<Products> getAllProduct(String ty)
    {
        String types=ty;
        List<Products> myList=new ArrayList<>();
        SQLiteDatabase DB= this.getReadableDatabase();
        Cursor cursor= DB.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + PRODUCT_TYPE + "=?",
                new String[] { (types) });
        if(cursor.moveToFirst())
        {
            do {
                String name=cursor.getString(1);
                int price=cursor.getInt(2);
                int aprice=cursor.getInt(3);
                int discount=cursor.getInt(4);
                String typ=cursor.getString(5);
                String siz=cursor.getString(7);
                Products newProduct=new Products(name,price,aprice,typ,discount,false,siz);
                myList.add(newProduct);
            }while (cursor.moveToNext());
        }
        cursor.close();
        DB.close();
        return myList;
    }
}
