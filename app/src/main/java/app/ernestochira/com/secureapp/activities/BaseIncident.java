package app.ernestochira.com.secureapp.activities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Enrique on 25/03/2017.
 */

public class BaseIncident extends SQLiteOpenHelper {
    String tabla= "CREATE TABLE Personas(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Distrito Text,Referencia Text, Fecha Text, Hora Text, Descripcion Text)";
    public BaseIncident(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
