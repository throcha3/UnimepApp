package br.com.thdev.unimep.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.thdev.unimep.database.Table.AgendaTable;
import br.com.thdev.unimep.database.Table.CursoTable;

/**
 * Created by thiag on 13/06/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "unimepappdb";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AgendaTable.SQL_CREATE);
        db.execSQL(CursoTable.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(AgendaTable.SQL_DROP_TABLE);
        db.execSQL(CursoTable.SQL_DROP_TABLE);
        onCreate(db);
    }
}