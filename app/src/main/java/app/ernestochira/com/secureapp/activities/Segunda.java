package app.ernestochira.com.secureapp.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

import app.ernestochira.com.secureapp.R;

public class Segunda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Cargar();


    }

    public void Cargar() {

        BaseIncident baseIncident = new BaseIncident(this, "DEMODB", null, 1);
        SQLiteDatabase db = baseIncident.getWritableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("select * from Persona", null);
            int cantidad = c.getCount();
            int i=0;
            String[] arreglo= new String[cantidad];
            if (c.moveToFirst()){
                do{
                    String linea = c.getInt(0)+ c.getString(1) + c.getString(2) + c.getString(3)
                            + c.getString(4) + c.getString(5);
                    arreglo[i] = linea;
                    i++;

                }while (c.moveToNext());
            }

            ArrayAdapter<String>adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arreglo);
            ListView lista= (ListView) findViewById(R.id.Lista);
            lista.setAdapter(adapter);


        }
    }

}
