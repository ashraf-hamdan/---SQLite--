package project.sqlite.hamdan.ashraf.sqlite_project;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import project.sqlite.hamdan.ashraf.sqlite_project.database.table.DatabaseHelper;

public class LoginScreen extends AppCompatActivity {

    EditText name, password;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        mydb = new DatabaseHelper(this);
        name = (EditText) findViewById(R.id.ed_Login_name);
        password = (EditText) findViewById(R.id.ed_Login_password);

    }

    public void click(View v) {
        if (v.getId() == R.id.btn_Login_singin) {
            login();
        } else if (v.getId() == R.id.btn_Login_reg) {
            Intent i = new Intent(LoginScreen.this, AddNewUser.class);
            startActivity(i);
        }
    }

    public void login() {
        String _name = name.getText().toString();
        String _password = password.getText().toString();

        Cursor c = mydb.getUser(_name, _password);
        if (c.getCount() != 0) {
            Intent i = new Intent(LoginScreen.this, MainActivity.class);
            i.putExtra("USER_NAME",_name);
            startActivity(i);
        } else {
            Toast.makeText(getBaseContext(), "F", Toast.LENGTH_LONG).show();
        }
    }

}
