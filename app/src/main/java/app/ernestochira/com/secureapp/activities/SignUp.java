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

      EditText et1,et2,et3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        et1= (EditText) findViewById(R.id.emailRegisterEditText);
        et2= (EditText) findViewById(R.id.nameRegisterEditText);
        et3= (EditText) findViewById(R.id.passwordRegisterEditText);

    }
    public void registrar(View view){

        DBHelper admin=new DBHelper(this,"secureapp",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String codigo=et1.getText().toString();
        String usuario=et2.getText().toString();
        String contraseña=et3.getText().toString();

        ContentValues values=new ContentValues();
        values.put("correo",codigo);
        values.put("usuario",usuario);
        values.put("contrasena",contraseña);

        db.insert("usuarios",null,values);
        db.close();

        Intent ven=new Intent(this,LogIn.class);
        startActivity(ven);

    }

    public void cancelar(View view){
        finish();

    }



}
