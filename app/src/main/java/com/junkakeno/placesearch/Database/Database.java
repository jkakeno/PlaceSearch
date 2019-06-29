package com.junkakeno.placesearch.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.junkakeno.placesearch.Model.List.VenuesItem;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static final String TAG = Database.class.getSimpleName();
    private static final String DB_NAME = "PlacesDB";
    private static final int DB_VER = 1;
    public static final String FAVORITE_TABLE = "FavoriteTable";
    public static final String COL_VENUE_ID = "venueId";


    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");
        String createTable = "CREATE TABLE " + FAVORITE_TABLE + "( " + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_VENUE_ID + " TEXT )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade");
        String deleteTable = "DROP TABLE IF EXISTS " + FAVORITE_TABLE;
        db.execSQL(deleteTable);
        onCreate(db);
    }

    /*Helper Methods.*/
    public void saveFavorite(String venueId) {

        /*Insert the info into the database.*/
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(COL_VENUE_ID, venueId);
        db.insert(FAVORITE_TABLE, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public void deleteFavorite(String venueId) {

        /*Insert the info into the database.*/
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.delete(FAVORITE_TABLE, COL_VENUE_ID + "=?", new String[]{venueId});
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public void clearTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + FAVORITE_TABLE);
        db.close();
    }

    public ArrayList<String> getFavorites() {

        ArrayList<String> favoriteList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(FAVORITE_TABLE, new String[]{COL_VENUE_ID}, null, null, null, null, BaseColumns._ID + " ASC");

        if (cursor.moveToFirst()) {
            do {
                String venueId = cursor.getString(cursor.getColumnIndex(COL_VENUE_ID));
                favoriteList.add(venueId);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return favoriteList;
    }

}
