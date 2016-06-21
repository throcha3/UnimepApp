package br.com.thdev.unimep.ui.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.thdev.unimep.R;
import br.com.thdev.unimep.database.Helper.CursoHelper;
import br.com.thdev.unimep.database.Table.CursoTable;
import br.com.thdev.unimep.model.Curso;
import br.com.thdev.unimep.model.Cursos;
import br.com.thdev.unimep.ui.adapter.CursoCursorAdapter;

/**
 * Display Courses list
 *
 * @author Thiago Rocha(throcha3@gmail.com)
 */

public class ConsCursoActivity extends BaseActivity {

    private Cursos mCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_agenda);

        ListView listView = (ListView) findViewById(R.id.list_view_consulta);

        setUpToolbar();
        //setupNavDrawer();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final CursoHelper crud = new CursoHelper(getBaseContext());
        final Cursor cursor = crud.getData();

        CursoCursorAdapter cursoCursorAdapter = new CursoCursorAdapter(this, cursor);

        assert listView != null;
        listView.setAdapter(cursoCursorAdapter);
        listView.setOnItemClickListener(mOnItemClickListener);
    }

    private ListView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // TODO: Improve it!!
            CursoHelper crudS = new CursoHelper(getBaseContext());
            //Avoid 0
            Cursor cursorS = crudS.getDataById(position+1);

            //String codigo = cursorS.getString(cursorS.getColumnIndexOrThrow(CursoTable.ID));
            String codigo = String.valueOf(position+1);
            Intent intent = new Intent(ConsCursoActivity.this, DtCursoActivity.class);
            intent.putExtra("codigo", codigo);
            startActivity(intent);

        }
    };

    //Not using now
    private Bundle getBundleItem(Curso curso){
        //Create a 'package' w/ data

        Bundle result = new Bundle();
        result.putString(CursoTable.NOME,curso.nome);
        result.putInt(CursoTable.QT_SEMESTRE,curso.qtSemestre);
        result.putString(CursoTable.CURSO,curso.curso);
        result.putString(CursoTable.PROFISSAO,curso.profissao);
        result.putInt(CursoTable.CAMPUS,curso.campus);
        result.putString(CursoTable.FACULDADE,curso.faculdade);
        return result;
    }
}
