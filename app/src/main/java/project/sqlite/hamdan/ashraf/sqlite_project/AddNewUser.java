package project.sqlite.hamdan.ashraf.sqlite_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import project.sqlite.hamdan.ashraf.sqlite_project.database.table.DatabaseHelper;
import project.sqlite.hamdan.ashraf.sqlite_project.database.table.User;

public class AddNewUser extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText name, password, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);
        mydb = new DatabaseHelper(this);
        name = (EditText) findViewById(R.id.ed_NewUser_name);
        password = (EditText) findViewById(R.id.ed_NewUser_password);
        age = (EditText) findViewById(R.id.ed_NewUser_age);
    }

    public void click(View v) {
        addUser();
    }

    public void addUser() {
        String _name = name.getText().toString();
        String _password = password.getText().toString();
        String _age = age.getText().toString();

       long id =  mydb.insert(User.TABLE_NAME, new String[]{User.NAME, User.PASSWORD, User.AGE},
                new String[]{_name, _password, _age});
        if(id != -1){
            Intent i = new Intent(AddNewUser.this,LoginScreen.class);
            startActivity(i);
        }else{
            Toast.makeText(getBaseContext(),"Try agin",Toast.LENGTH_LONG).show();
        }
    }
}
