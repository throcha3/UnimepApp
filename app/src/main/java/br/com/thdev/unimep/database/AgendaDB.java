package br.com.thdev.unimep.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.thdev.unimep.model.AgendaModel;

/**
 * Created by thiag on 16/05/2016.
 */
public class AgendaDB extends SQLiteOpenHelper {

    private static final String TAG = "sql";
    // Nome do banco
    public static final String NOME_BANCO = "unimep_android.sqlite";
    private static final int VERSAO_BANCO = 1;
    public static final String TABELA = "Agenda";
    public static final String ID = "_id";
    public static final String ID_DISCIPLINA = "id_disciplina";
    public static final String TIPO = "tipo";
    public static final String DEADLINE = "deadline";
    public static final String DESCRICAO = "descricao";

    public AgendaDB(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Criando a tabela Agenda...");
        db.execSQL("create table if not exists agenda (" +
                ID +" integer primary key, " +
                ID_DISCIPLINA +" int, " +
                TIPO +" text, " +
                DEADLINE +" text, " +
                DESCRICAO+" text);");
        Log.d(TAG, "Tabela Agenda criada com sucesso!!! Aeeeeeeee :D");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Mudança de versão do BD...
    }

    public long save(AgendaModel agenda){
        long id = agenda.get_id();
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(ID_DISCIPLINA, agenda.getId_disciplina());
            values.put(TIPO, agenda.getTipo());
            values.put(DEADLINE, String.valueOf(agenda.getDeadline()));
            values.put(DESCRICAO, agenda.getDescricao());

            // Pode-se colocar uma validação aqui pra update ou insert, nesse caso apenas insert.
            id = db.insert(TABELA, "", values);
            return id;
        }finally {
            db.close();
        }
    }

    public List<AgendaModel> findAll(){
        SQLiteDatabase db = getWritableDatabase();
        try {
            Cursor c = db.query(TABELA, null, null, null, null, null, null, null);
            return toList(c);
        }finally {
            db.close();
        }
    }

    private List<AgendaModel> toList(Cursor c) {
        List<AgendaModel> agendamentos = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                AgendaModel agenda = new AgendaModel();
                agendamentos.add(agenda);
                // Recupera os atributos de agenda
                agenda.set_id(c.getLong(c.getColumnIndex("_id")));
                agenda.setId_disciplina(c.getLong(c.getColumnIndex("id_disciplina")));
                agenda.setTipo(c.getString(c.getColumnIndex("tipo")));
                agenda.setDescricao(c.getString(c.getColumnIndex("descricao")));
                agenda.setDeadline(c.getString(c.getColumnIndex("deadline")));
            } while (c.moveToNext());
        }
        return agendamentos;
    }

    public Cursor getData(){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT  * FROM "+TABELA, null);
        return cursor;
    }
}
