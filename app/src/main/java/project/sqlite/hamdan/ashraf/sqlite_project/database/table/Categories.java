package project.sqlite.hamdan.ashraf.sqlite_project.database.table;

/**
 * Created by ashraf on 11/29/2016.
 */

public abstract class Categories {

    public final static String TABLE_NAME = "categories";

    public final static String ID = "id";
    public final static String NAME = "name";


    public final static String CREATE_CATEGORIES_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            " " + NAME + " TEXT );";
}
