package project.sqlite.hamdan.ashraf.sqlite_project.database.table;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ashraf on 11/19/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(User.CREATE_USER_TABLE);
        db.execSQL(IncomingGoods.CREATE_INCOMING_GOODS_TABLE);
        db.execSQL(OutgoingGoods.CREATE_OUTING_GOODS_TABLE);
        db.execSQL(Categories.CREATE_CATEGORIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + IncomingGoods.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + OutgoingGoods.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Categories.TABLE_NAME);
        onCreate(db);
    }

    public DatabaseHelper(Context context) {
        super(context, "MyProject_1.db", null, 8);
    }

    public long insert(String tableName, String[] cName, String[] cValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        for (int i = 0; i < cName.length; i++) {
            c.put(cName[i], cValue[i]);
        }
        long id = db.insert(tableName, null, c);
        return id;
    }

    public long update(String tableName, String[] cName, String[] cValue, String colNameToUpdate,
                       String colValueToUpdate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        for (int i = 0; i < cName.length; i++) {
            c.put(cName[i], cValue[i]);
        }
        long number = db.update(tableName, c, colNameToUpdate + " = ?", new String[]{colValueToUpdate});
        return number;
    }

    public Cursor selectAll(String tableName,String colName,String colValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + tableName +" where "+colName+" =?" , new String[]{colValue});
        return c;
    }

    public long delete(String tableName, String cloName, String colValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tableName, cloName + " = ?", new String[]{colValue});

    }

    public Cursor getUser(String name, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + User.TABLE_NAME + " where " +
                User.NAME + " = ? AND " + User.PASSWORD + " = ? ", new String[]{name, password});
        return c;
    }


}
