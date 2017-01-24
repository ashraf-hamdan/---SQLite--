package project.sqlite.hamdan.ashraf.sqlite_project;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import project.sqlite.hamdan.ashraf.sqlite_project.database.table.DatabaseHelper;
import project.sqlite.hamdan.ashraf.sqlite_project.database.table.IncomingGoods;
import project.sqlite.hamdan.ashraf.sqlite_project.entities.Adapter;
import project.sqlite.hamdan.ashraf.sqlite_project.entities.InEntity;

public class InList extends AppCompatActivity {

    DatabaseHelper mydb;
    ArrayList<InEntity> list = new ArrayList<InEntity>();
    InEntity entity;
    ListView lv;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_list);

        Intent info = this.getIntent();
        userName = info.getExtras().getString("USER_NAME");

        mydb = new DatabaseHelper(this);
        lv = (ListView) findViewById(R.id.lv_IN_list);

        setDataToList();


        Adapter x = new Adapter(InList.this,list);

        lv.setAdapter(x);
    }

    public void setDataToList(){

        Cursor cursor = mydb.selectAll(IncomingGoods.TABLE_NAME,IncomingGoods.U_NAME,userName);
        while (cursor.moveToNext()){
            entity = new InEntity();
            entity.setId(cursor.getString(cursor.getColumnIndex(IncomingGoods.ID)));
            entity.setName(cursor.getString(cursor.getColumnIndex(IncomingGoods.NAME)));
            entity.setPrice(cursor.getString(cursor.getColumnIndex(IncomingGoods.PRICE)));
            entity.setNumber(cursor.getString(cursor.getColumnIndex(IncomingGoods.NUMBER)));
            entity.setCategory(cursor.getString(cursor.getColumnIndex(IncomingGoods.C_ID)));
            list.add(entity);
        }
    }

}
