package br.com.thdev.unimep.ui.activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.thdev.unimep.R;
import br.com.thdev.unimep.database.DatabaseHelper;
import br.com.thdev.unimep.database.Helper.CursoHelper;
import br.com.thdev.unimep.database.Table.CursoTable;
import br.com.thdev.unimep.model.Cursos;

public class MainActivity extends BaseActivity {
    private Cursos mCursos;
    private DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setupNavDrawer();

        //ParseJson and get a list filled w/ json's data
        mCursos = getCursos();
        CursoHelper cursoHelper = new CursoHelper(MainActivity.this);

        if (mCursos.count != cursoHelper.getCount()) {
            mDatabaseHelper = new DatabaseHelper(MainActivity.this);
            SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
            db.execSQL(CursoTable.SQL_DELETE_DATA);
            //Instance class and calls the method who insert json's data to sqlite
            cursoHelper.insertFromJson(mCursos);
            toast("Registros inseridos com sucesso!!!");
        } else {toast("Nao precisou inserir.");}

    }
    private Cursos getCursos(){
        //Get the reference for the Json file
        InputStream inputStream = getResources().openRawResource(R.raw.cursos);
        //This object is required for the Gson to read the json file
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        Gson gson = new Gson();
        //Instance object Cursos and realize Parse
        Cursos cursos = gson.fromJson(inputStreamReader, Cursos.class);

        return cursos;
    }
}
