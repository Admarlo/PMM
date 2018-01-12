package com.example.adrlop.bdinicial;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by adrlop on 9/01/18.
 */

public class ClientesSQLiteHelper extends SQLiteOpenHelper {

    String cadSQL="CREATE TABLE Clientes(codigo INTEGER, nombre TEXT, telefono TEXT)";

    public ClientesSQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(contexto,nombre,almacen,version);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(cadSQL);
    }

    public void onUpgrade(SQLiteDatabase db,int versionAnterior, int versionNueva){
        db.execSQL("DROP TABLE IF EXIST Clientes");
        db.execSQL(cadSQL);
    }
    
}


