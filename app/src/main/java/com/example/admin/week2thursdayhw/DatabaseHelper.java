package com.example.admin.week2thursdayhw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 9/7/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    ArrayList<KiwiObject> kiwiArray=new ArrayList<>();
    List<KiwiObject> kiwiList = new ArrayList<KiwiObject>();
    private static final String DATABASE_NAME="myDatabase";
    private static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="contacts";

    public static final String KIWI_ID ="ID";
    public static final String KIWI_FIRSTNAME ="FirstName";
    public static final String KIWI_LASTNAME ="LastName";
    public static final String KIWI_CELL ="Cell";
    public static final String KIWI_NOTE ="Note";
    public static final String KIWI_TIMESTAMP ="TimeStamp";

    private static final String TAG = "DatabaseTAG";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("+
                KIWI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KIWI_FIRSTNAME + " CHAR(50) NOT NULL," +
                KIWI_LASTNAME + " CHAR(50)," +
                KIWI_CELL + " INT," +
                KIWI_NOTE + " CHAR(50)," +
                KIWI_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"+
                ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //CREATE
    public void saveKiwi(String firstName, String lastName, int cell, String note){
        Log.d(TAG, "saveKiwi: "+"Start");
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(KIWI_FIRSTNAME, firstName);
            contentValues.put(KIWI_LASTNAME, lastName);
            contentValues.put(KIWI_CELL, cell);
            contentValues.put(KIWI_NOTE, note);

            long rowNumber = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
            Log.d(TAG, "saveNewContact: " + rowNumber);
        }
        catch(Exception e){
            Log.d(TAG, "saveKiwi ex: "+e);
        }
    }

    //READ
    public List<KiwiObject> getAllInformation(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT "+
                KIWI_ID + ", "+
                KIWI_FIRSTNAME+", " +
                KIWI_LASTNAME+", " +
                KIWI_CELL+", " +
                KIWI_NOTE+", " +
                KIWI_TIMESTAMP +" FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        kiwiList.clear();

        KiwiObject kiwiObject;
        if (cursor.moveToFirst()) {
            do {

                kiwiObject = new KiwiObject();
                kiwiObject.setKIWI_ID(cursor.getInt(0));
                kiwiObject.setKIWI_FIRSTNAME(cursor.getString(1));
                kiwiObject.setKIWI_LASTNAME(cursor.getString(2));
                kiwiObject.setKIWI_CELL(cursor.getInt(3));
                kiwiObject.setKIWI_NOTE(cursor.getString(4));
                kiwiObject.setKIWI_TIMESTAMP(cursor.getString(5));
                kiwiList.add(kiwiObject);

                Log.d(TAG, "getContacts: " +
                        "ID: " + cursor.getString(0) +
                        " First: " + cursor.getString(1) +
                        " Last: " + cursor.getString(2) +
                        " Cell: " + cursor.getString(3) +
                        " Note: " + cursor.getString(4) +
                        " TimeStamp: " + cursor.getString(5));

            } while (cursor.moveToNext());
        }
        for (int i = 0; i < kiwiList.size() ; i++) {
            Log.d(TAG, "getForSpinner:  ID:"+ kiwiList.get(i).getKIWI_ID()+
            " NAME: " + kiwiList.get(i).getKIWI_FIRSTNAME());
        }
        return kiwiList;
    }


    //UPDATE
    public void updateKiwi(int id, String firstName, String lastName, int cell, String note){

        Log.d(TAG, "updateKiwi id: " + id);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "UPDATE "+ TABLE_NAME+ " SET " +
                KIWI_FIRSTNAME+ " = '"+ firstName +"', "+
                KIWI_LASTNAME+ " = '"+ lastName +"', "+
                KIWI_CELL+ " = '"+ cell +"', "+
                KIWI_NOTE+ " = '"+ note +"' "+
                "WHERE " + KIWI_ID + " = " + id;
        try {
            sqLiteDatabase.execSQL(query);
            Log.d(TAG, "updateKiwi work");
        }
        catch (Exception e){
            Log.d(TAG, "updateKiwi err: " + e.toString());
        }
    }

    //DELETE
   public void delete(int id)
   {
       SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
       String query = "DELETE FROM "+ TABLE_NAME+ " WHERE " + KIWI_ID + " = " + id;

       try {
           sqLiteDatabase.execSQL(query);
           Log.d(TAG, "DeleteKiwi work");
       }
       catch (Exception e){
           Log.d(TAG, "DeleteKiwi err: " + e.toString());
       }

   }
}
