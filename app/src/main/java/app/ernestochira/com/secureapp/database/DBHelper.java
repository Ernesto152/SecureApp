package app.ernestochira.com.secureapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by usuario on 31/03/2017.
 */

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create tabla users(email text primary key, user text, password text)");
        //db.execSQL("insert into users values('admin','admin',admin')");
        db.execSQL("create table usuarios(correo text primary key,usuario text,contrasena text)");
        db.execSQL("create table incidences(user text primary key,type_incidence text," +
                "description text,date text,hour text,evidence text)");
        db.execSQL("insert into usuarios values('admin','admin','admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("create tabla users(email text primary key, user text, password text)");
        //db.execSQL("insert into users values('admin','admin',admin')");
        db.execSQL("create table usuarios(correo text primary key,usuario text,contrasena text)");
        db.execSQL("create table incidences(user text primary key,type_incidence text," +
                "description text,date text,hour text,evidence text)");
        db.execSQL("insert into usuarios values('admin','admin','admin')");
    }
}
