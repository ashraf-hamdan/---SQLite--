package project.sqlite.hamdan.ashraf.sqlite_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import project.sqlite.hamdan.ashraf.sqlite_project.database.table.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent info = this.getIntent();
        userName = info.getExtras().getString("USER_NAME");

    }

    public void click(View v) {
        if (v.getId() == R.id.btn_Main_add) {
            Intent i = new Intent(MainActivity.this, AddItems.class);
            i.putExtra("USER_NAME",userName);
            startActivity(i);

        } else if (v.getId() == R.id.btn_Main_In) {
            Intent i = new Intent(MainActivity.this, InList.class);
            i.putExtra("USER_NAME",userName);
            startActivity(i);

        } else if (v.getId() == R.id.btn_Main_Out) {
            Intent i = new Intent(MainActivity.this, OutingGood.class);
            i.putExtra("USER_NAME",userName);
            startActivity(i);
        }
    }

}
