package br.com.thdev.unimep.ui.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.thdev.unimep.R;
import br.com.thdev.unimep.database.Helper.CursoHelper;
import br.com.thdev.unimep.database.Table.CursoTable;
import br.com.thdev.unimep.model.Curso;

/**
 * Display details of selected course
 *
 * @author Thiago Rocha(throcha3@gmail.com)
 */

public class DtCursoActivity extends BaseActivity {

    private TextView mTxtNome;
    private TextView mTxtQtSem;
    private TextView mTxtFacul;
    private TextView mTxtCampus;
    private TextView mTxtCurso;
    private TextView mTxtProfissao;

    private Button mBtnSaibaMais;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dt_cursos);

        setUpToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mBtnSaibaMais = (Button) findViewById(R.id.btn_dt_c_saiba);
        mBtnSaibaMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Abrir o site da unimep??");
            }
        });

        mTxtNome = (TextView) findViewById(R.id.textview_dt_c_nome);
        mTxtQtSem = (TextView) findViewById(R.id.textview_dt_c_semestre);
        mTxtFacul = (TextView) findViewById(R.id.textview_dt_c_faculdade);
        mTxtCampus = (TextView) findViewById(R.id.textview_dt_c_campus);
        mTxtCurso = (TextView) findViewById(R.id.textview_dt_c_curso);
        mTxtProfissao = (TextView) findViewById(R.id.textview_dt_c_profissao);

        String codigo = this.getIntent().getStringExtra("codigo");

        final CursoHelper crud = new CursoHelper(getBaseContext());
        final Cursor cursor = crud.getDataById(Integer.parseInt(codigo));

//        Intent it = getIntent();
//        Bundle bundle = it.getExtras();

        Curso curso = new Curso();

        //I could send data in a bundle.. could be better.
//        curso.nome = bundle.getString(CursoTable.NOME);
//        curso.qtSemestre = bundle.getInt(CursoTable.QT_SEMESTRE);
//        curso.curso = bundle.getString(CursoTable.CURSO);
//        curso.profissao = bundle.getString(CursoTable.PROFISSAO);
//        curso.campus = bundle.getInt(CursoTable.CAMPUS);
//        curso.faculdade = bundle.getString(CursoTable.FACULDADE);

        curso.nome = cursor.getString(cursor.getColumnIndexOrThrow(CursoTable.NOME));
        curso.qtSemestre = cursor.getInt(cursor.getColumnIndexOrThrow(CursoTable.QT_SEMESTRE));
        curso.curso = cursor.getString(cursor.getColumnIndexOrThrow(CursoTable.CURSO));
        //curso.profissao = cursor.getString(cursor.getColumnIndexOrThrow(CursoTable.PROFISSAO));
        curso.campus = cursor.getInt(cursor.getColumnIndexOrThrow(CursoTable.CAMPUS));
        curso.faculdade = cursor.getString(cursor.getColumnIndexOrThrow(CursoTable.FACULDADE));

        String campus = "Campus: " + String.valueOf(curso.campus);
        String sem = "Semestres: " + String.valueOf(curso.qtSemestre);

        mTxtNome.setText(curso.nome);
        mTxtFacul.setText(curso.faculdade);
        mTxtCurso.setText(curso.curso);
        //mTxtProfissao.setText(curso.profissao);
        mTxtCampus.setText(campus);
        mTxtQtSem.setText(sem);

    }
}
