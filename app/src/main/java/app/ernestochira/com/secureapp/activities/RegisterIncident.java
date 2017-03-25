package app.ernestochira.com.secureapp.activities;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import app.ernestochira.com.secureapp.R;

public class RegisterIncident extends AppCompatActivity {
EditText Distritotext, Referenciatext, Fechatext, Horatext, Descripciontext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_incident);
        Distritotext=(EditText) findViewById(R.id.distritotext);
        Referenciatext=(EditText) findViewById(R.id.referenciatext);
        Fechatext=(EditText)findViewById(R.id.fechatext);
        Horatext=(EditText)findViewById(R.id.horatext);
        Descripciontext=(EditText)findViewById(R.id.descripciontext);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }
        );
    }
public void GuardarDatos(View view){

    String distrito = Distritotext.getText().toString();
    String referencia = Referenciatext.getText().toString();
    String fecha = Fechatext.getText().toString();
    String hora = Horatext.getText().toString();
    String descripcion = Descripciontext.getText().toString();

    BaseIncident baseIncident = new BaseIncident(this,"DEMODB",null,1);
    SQLiteDatabase db = baseIncident.getWritableDatabase();
    if (db!=null){
        ContentValues registronuevo = new ContentValues();
        registronuevo.put("Distrito",distrito);
        registronuevo.put("Referencia",referencia);
        registronuevo.put("Fecha",fecha);
        registronuevo.put("Hora",hora);
        registronuevo.put("Descripcion",descripcion);
        long i = db.insert("Personas",null,registronuevo);
        if (i>0){
            Toast.makeText(this,"Registro insertado", Toast.LENGTH_SHORT).show();

        }

    }



}


}
