package br.com.thdev.unimep.ui.activity;

import android.os.Bundle;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.thdev.unimep.R;
import br.com.thdev.unimep.database.Helper.CursoHelper;
import br.com.thdev.unimep.model.Cursos;

public class MainActivity extends BaseActivity {
    private Cursos mCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setupNavDrawer();

        //ParseJson and get a list filled w/ json's data
        mCursos = getCursos();

        //Instance class and calls the method who insert json's data to sqlite
        CursoHelper cursoHelper = new CursoHelper(MainActivity.this);
        cursoHelper.insertFromJson(mCursos);
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
