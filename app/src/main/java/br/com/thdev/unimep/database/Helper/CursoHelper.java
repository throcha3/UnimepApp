package br.com.thdev.unimep.database.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.thdev.unimep.database.DatabaseHelper;
import br.com.thdev.unimep.database.Table.CursoTable;
import br.com.thdev.unimep.model.Curso;
import br.com.thdev.unimep.model.Cursos;

/**
 * Created by thiag on 16/06/2016.
 */
public class CursoHelper {
    private DatabaseHelper mDatabaseHelper;
    private Context mContext;

    public CursoHelper(Context context){
        mContext = context;
        mDatabaseHelper = new DatabaseHelper(mContext);
    }

    //This method insert json's data to local sqlite database
    public void insertFromJson(Cursos cursos){
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();

        //Inserting data in sqlite..
        for(Curso curso : cursos.cursos){
            ContentValues values = new ContentValues();


            values.put(CursoTable.NOME, curso.nome);
            values.put(CursoTable.QT_SEMESTRE, curso.qtSemestre);
            values.put(CursoTable.CURSO, curso.curso);
            values.put(CursoTable.PROFISSAO, curso.profissao);
            values.put(CursoTable.CAMPUS, curso.campus);
            values.put(CursoTable.FACULDADE, curso.faculdade);
            db.insert(CursoTable.TABELA, null, values);

        }
    }

    public Cursor getData(){
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        // Query for items from the database and get a cursor back
        Cursor cursor = db.rawQuery("SELECT  * FROM "+CursoTable.TABELA, null);

        return cursor;
    }

    public long save(Curso curso){
        long id = curso._id;
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(CursoTable.NOME, curso.nome);
            values.put(CursoTable.QT_SEMESTRE, curso.qtSemestre);
            values.put(CursoTable.CURSO, String.valueOf(curso.curso));
            values.put(CursoTable.PROFISSAO, curso.profissao);
            values.put(CursoTable.CAMPUS, curso.campus);
            values.put(CursoTable.FACULDADE, curso.faculdade);

            // Pode-se colocar uma validação aqui pra update ou insert, nesse caso apenas insert.
            id = db.insert(CursoTable.TABELA, "", values);
            return id;
        }finally {
            db.close();
        }
    }

    public int getCount(){
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        // Query for items from the database and get a cursor back
        Cursor cursor = db.rawQuery("SELECT * FROM "+CursoTable.TABELA, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public Cursor getDataById(long id){
        Cursor cursor;
        String[] campos ={CursoTable.ID,
                CursoTable.QT_SEMESTRE,
                CursoTable.NOME,
                CursoTable.FACULDADE,
                CursoTable.CAMPUS,
                CursoTable.CURSO};

        String where = CursoTable.ID + "=" + id;
        SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
        cursor = db.query(CursoTable.TABELA,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
