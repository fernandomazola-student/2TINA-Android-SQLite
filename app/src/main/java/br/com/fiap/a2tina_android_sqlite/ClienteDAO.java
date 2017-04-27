package br.com.fiap.a2tina_android_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

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
        String sql = "CREATE TABLE" + TBCLIENTE + "(\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`nome`\tTEXT,\n" +
                "\t`email`\tTEXT\n" +
                ")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(Cliente cliente){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("email", cliente.getEmail());
        db.insert(TBCLIENTE, null, values);
    }

    public List<Cliente> all(){

    }
}
