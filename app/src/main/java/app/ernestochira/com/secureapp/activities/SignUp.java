package app.ernestochira.com.secureapp.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import app.ernestochira.com.secureapp.R;
import app.ernestochira.com.secureapp.database.DBHelper;

public class SignUp extends AppCompatActivity {

    EditText emailEditText;
    EditText userEditText;
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        emailEditText = (EditText) findViewById(R.id.emailRegisterEditText);
        userEditText = (EditText) findViewById(R.id.nameRegisterEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordRegisterEditText);

    }
    public void signUp(View view){

        DBHelper dbHelper=new DBHelper(this,"secureapp",null,1);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String email= emailEditText.getText().toString();
        String user= userEditText.getText().toString();
        String password= passwordEditText.getText().toString();

        ContentValues values=new ContentValues();
        values.put("correo",email);
        values.put("usuario",user);
        values.put("contrasena",password);

        db.insert("usuarios",null,values);
        db.close();

        Intent ven=new Intent(this,LogIn.class);
        startActivity(ven);
    }

    public void cancel(View view){
        finish();
    }
}
