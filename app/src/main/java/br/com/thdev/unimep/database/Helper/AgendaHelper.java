package br.com.thdev.unimep.database.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.thdev.unimep.database.DatabaseHelper;
import br.com.thdev.unimep.database.Table.AgendaTable;
import br.com.thdev.unimep.model.Agenda;
import br.com.thdev.unimep.model.Agendas;

/**
 * Created by thiag on 13/06/2016.
 */
public class AgendaHelper {
    private DatabaseHelper mDatabaseHelper;
    private Context mContext;

    public AgendaHelper(Context context){
        mContext = context;
        mDatabaseHelper = new DatabaseHelper(mContext);
    }

    //Metodo para inserir os dados no sqlite da lista criada com o json
    public void insertFromSeries(Agendas agendas){
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();

        //Repeticao para inserir os dados da lista no sqlite
        for(Agenda agenda : agendas.agendas){
            ContentValues values = new ContentValues();


            values.put(AgendaTable.DISCIPLINA, agenda.disciplina);
            values.put(AgendaTable.TIPO, agenda.tipo);
            values.put(AgendaTable.DEADLINE, agenda.deadline);
            values.put(AgendaTable.DESCRICAO, agenda.descricao);
            db.insert(AgendaTable.TABELA, null, values);

        }
    }

    public Cursor getData(){
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        // Query for items from the database and get a cursor back
        //String qry = "SELECT * FROM " + SerieTable.TABLE_NAME;
        Cursor cursor = db.rawQuery("SELECT  * FROM "+AgendaTable.TABELA, null);

        return cursor;
    }

    public long save(Agenda agenda){
        long id = agenda._id;
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(AgendaTable.DISCIPLINA, agenda.disciplina);
            values.put(AgendaTable.TIPO, agenda.tipo);
            values.put(AgendaTable.DEADLINE, String.valueOf(agenda.deadline));
            values.put(AgendaTable.DESCRICAO, agenda.descricao);

            // Pode-se colocar uma validação aqui pra update ou insert, nesse caso apenas insert.
            id = db.insert(AgendaTable.TABELA, "", values);
            return id;
        }finally {
            db.close();
        }
    }
}
