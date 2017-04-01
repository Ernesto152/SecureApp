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

    EditText et1,et2,et3;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1= (EditText) findViewById(R.id.nombre_text);
        et2= (EditText) findViewById(R.id.contrasena_text);
    }

    public void ingresar(View w){
        DBHelper admin=new DBHelper(this,"secureapp",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String usuario=et1.getText().toString();
        String contrasena=et2.getText().toString();
        fila=db.rawQuery("select usuario,contrasena from usuarios where usuario='"+usuario+"' and contrasena='"+contrasena+"'",null);

        if (fila.moveToFirst()){
            String usua=fila.getString(0);
            String pass=fila.getString(1);
            if (usuario.equals(usua)&&contrasena.equals(pass)){
                Intent ven=new Intent(this,IncidencesActivity.class);
                startActivity(ven);
                et1.setText("");
                et2.setText("");
            }
        }
    }
    public void registro(View v){
        Intent ven=new Intent(this,SignUp.class);
        startActivity(ven);
    }

    public void salir(View v){
   finish();
        //System.exit(0);
    }
}
