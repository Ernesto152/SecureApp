package app.ernestochira.com.secureapp.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import app.ernestochira.com.secureapp.R;
import app.ernestochira.com.secureapp.database.DBHelper;

public class LogIn extends AppCompatActivity {

    EditText userEditText;
    EditText passwordEditText;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEditText = (EditText) findViewById(R.id.userEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
    }

    public void signIn(View w){
        DBHelper dbHelper=new DBHelper(this,"secureapp",null,1);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String user= userEditText.getText().toString();
        String password= passwordEditText.getText().toString();
        cursor =db.rawQuery("select usuario,contrasena from usuarios where usuario='"+user+"' and contrasena='"+password+"'",null);

        if (cursor.moveToFirst()){
            String usua= cursor.getString(0);
            String pass= cursor.getString(1);
            if (user.equals(usua)&&password.equals(pass)){
                Intent ven=new Intent(this,IncidencesActivity.class);
                startActivity(ven);
                userEditText.setText("");
                passwordEditText.setText("");
            }
        }
    }
    public void signUp(View v){
        Intent ven=new Intent(this,SignUp.class);
        startActivity(ven);
    }

    public void getOut(View v){
        finish();
    }
}
