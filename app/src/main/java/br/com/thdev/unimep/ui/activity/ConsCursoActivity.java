package br.com.thdev.unimep.ui.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import br.com.thdev.unimep.R;
import br.com.thdev.unimep.database.Helper.CursoHelper;
import br.com.thdev.unimep.ui.adapter.CursoCursorAdapter;

public class ConsCursoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_agenda);

        setUpToolbar();

        CursoHelper crud = new CursoHelper(getBaseContext());
        final Cursor cursor = crud.getData();

        ListView listView = (ListView) findViewById(R.id.list_view_consulta);
        CursoCursorAdapter cursoCursorAdapter = new CursoCursorAdapter(this, cursor);

        assert listView != null;
        listView.setAdapter(cursoCursorAdapter);
    }
}
