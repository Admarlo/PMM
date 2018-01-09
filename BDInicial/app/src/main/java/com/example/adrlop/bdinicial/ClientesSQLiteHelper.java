package com.example.adrlop.bdinicial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adrlop on 9/01/18.
 */

public class ClientesSQLiteHelper extends SQLiteOpenHelper {

    Sring cadSQL = "CREATE TABLE Clientes (codigo INTEGER, nombre TEXT, telefono TEXT)";

    public ClientesSQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(cadSQL);
    }
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {
        bd.execSQL("DROP TABLE IF EXISTS Clientes");
        bd.execSQL(cadSQL);
    }
}
