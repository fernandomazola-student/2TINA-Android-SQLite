package br.com.fiap.a2tina_android_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by logonrm on 27/04/2017.
 */

public class ClienteDAO extends SQLiteOpenHelper {

    public static final String DBNAME = "app";
    public static final String TBCLIENTE = "cliente";
    public static final int DBVERSION = 1;

    public ClienteDAO(Context context){
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
