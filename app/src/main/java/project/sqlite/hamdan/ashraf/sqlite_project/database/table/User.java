package project.sqlite.hamdan.ashraf.sqlite_project.database.table;

/**
 * Created by ashraf on 11/19/2016.
 */

public abstract class User {
    public final static String TABLE_NAME = "user";

    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String PASSWORD = "password";
    public final static String AGE = "age";

    public final static String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            " " + NAME + " TEXT , " + PASSWORD + " TEXT , " + AGE + " TEXT );";
}
