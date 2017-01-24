package project.sqlite.hamdan.ashraf.sqlite_project;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import project.sqlite.hamdan.ashraf.sqlite_project.database.table.DatabaseHelper;
import project.sqlite.hamdan.ashraf.sqlite_project.database.table.IncomingGoods;
import project.sqlite.hamdan.ashraf.sqlite_project.database.table.OutgoingGoods;
import project.sqlite.hamdan.ashraf.sqlite_project.entities.Adapter;
import project.sqlite.hamdan.ashraf.sqlite_project.entities.InEntity;

public class OutingGood extends AppCompatActivity {

    EditText name,price,number;
    Spinner spinnerCategory;
    String[] arrayCategory;
    DatabaseHelper mydb;
    String userName;

    ArrayList<InEntity> list = new ArrayList<InEntity>();
    InEntity entity;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outing_good);

        Intent info = this.getIntent();
        userName = info.getExtras().getString("USER_NAME");

        mydb = new DatabaseHelper(this);
        name = (EditText) findViewById(R.id.ed_Outing_name);
        price = (EditText) findViewById(R.id.ed_Outing_price);
        number = (EditText) findViewById(R.id.ed_Outing_number);
        spinnerCategory = (Spinner) findViewById(R.id.sp_Outing_category);

        setSpinnerData();

        lv = (ListView) findViewById(R.id.outing_List);
        setDataToList();

        Adapter x = new Adapter(OutingGood.this,list);
        lv.setAdapter(x);

    }

    public void setDataToList(){

        Cursor cursor = mydb.selectAll(OutgoingGoods.TABLE_NAME,OutgoingGoods.U_NAME,userName);
        while (cursor.moveToNext()){
            entity = new InEntity();
            entity.setId(cursor.getString(cursor.getColumnIndex(OutgoingGoods.ID)));
            entity.setName(cursor.getString(cursor.getColumnIndex(OutgoingGoods.NAME)));
            entity.setPrice(cursor.getString(cursor.getColumnIndex(OutgoingGoods.PRICE)));
            entity.setNumber(cursor.getString(cursor.getColumnIndex(OutgoingGoods.NUMBER)));
            entity.setCategory(cursor.getString(cursor.getColumnIndex(OutgoingGoods.C_ID)));
            list.add(entity);
        }
    }

    public void click(View v){

        long id =  mydb.insert(OutgoingGoods.TABLE_NAME,new String[]{OutgoingGoods.NAME,OutgoingGoods.PRICE,
                        OutgoingGoods.NUMBER,OutgoingGoods.C_ID,OutgoingGoods.U_NAME},
                new String[]{name.getText().toString(),
                        price.getText().toString(),
                        number.getText().toString(),
                        spinnerCategory.getSelectedItem().toString(),userName});

        if(id != -1){
            Toast.makeText(getBaseContext(),"S",Toast.LENGTH_LONG).show();
            list.clear();
            setDataToList();
            Adapter x = new Adapter(OutingGood.this,list);
            lv.setAdapter(x);

        }else{
            Toast.makeText(getBaseContext(),"F",Toast.LENGTH_LONG).show();
        }

    }

    public void setSpinnerData(){
        arrayCategory = new String[3];
        arrayCategory[0] = "Category A";
        arrayCategory[1] = "Category B";
        arrayCategory[2] = "Category C";

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,arrayCategory){
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position % 2 == 1) {
                    // Set the item background color
                    tv.setBackgroundColor(Color.parseColor("#00ff00"));
                } else {
                    // Set the alternate item background color
                    tv.setBackgroundColor(Color.parseColor("#ff0000"));
                }
                return view;
            }
        };


        spinnerCategory.setAdapter(adapter);

    }
}
