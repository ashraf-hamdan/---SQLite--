package project.sqlite.hamdan.ashraf.sqlite_project.database.table;

/**
 * Created by ashraf on 11/29/2016.
 */

public abstract class IncomingGoods {

    public final static String TABLE_NAME = "incoming_goods";

    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String PRICE = "price";
    public final static String NUMBER = "number";
    public final static String C_ID = "c_id";
    public final static String U_NAME = "u_name";

    public final static String CREATE_INCOMING_GOODS_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            " " + NAME + " TEXT , " + PRICE + " TEXT , " + NUMBER + " TEXT, " + C_ID + " TEXT , " + U_NAME + " TEXT );";
}
