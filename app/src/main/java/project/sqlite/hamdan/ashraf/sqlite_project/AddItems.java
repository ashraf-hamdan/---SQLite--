package project.sqlite.hamdan.ashraf.sqlite_project;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import project.sqlite.hamdan.ashraf.sqlite_project.database.table.DatabaseHelper;
import project.sqlite.hamdan.ashraf.sqlite_project.database.table.IncomingGoods;
import project.sqlite.hamdan.ashraf.sqlite_project.database.table.User;

public class AddItems extends AppCompatActivity {

    EditText name,price,number;
    Spinner spinnerCategory;
    String[] arrayCategory;
    DatabaseHelper mydb;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        Intent info = this.getIntent();
        userName = info.getExtras().getString("USER_NAME");

        mydb = new DatabaseHelper(this);
        name = (EditText) findViewById(R.id.ed_Item_name);
        price = (EditText) findViewById(R.id.ed_Item_price);
        number = (EditText) findViewById(R.id.ed_Item_number);
        spinnerCategory = (Spinner) findViewById(R.id.sp_Item_cat);

        setSpinnerData();

    }

    public void click(View v){

      long id =  mydb.insert(IncomingGoods.TABLE_NAME,new String[]{IncomingGoods.NAME,IncomingGoods.PRICE,
                                                          IncomingGoods.NUMBER,IncomingGoods.C_ID,IncomingGoods.U_NAME},
                                             new String[]{name.getText().toString(),
                                                         price.getText().toString(),
                                                         number.getText().toString(),
                                                         spinnerCategory.getSelectedItem().toString(),userName});

   if(id != -1){
       Toast.makeText(getBaseContext(),"S",Toast.LENGTH_LONG).show();
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
