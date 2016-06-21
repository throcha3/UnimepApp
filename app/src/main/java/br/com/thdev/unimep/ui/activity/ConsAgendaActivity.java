package br.com.thdev.unimep.ui.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import br.com.thdev.unimep.R;
import br.com.thdev.unimep.ui.adapter.AgendaCursorAdapter;
import br.com.thdev.unimep.database.Helper.AgendaHelper;

public class ConsAgendaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_agenda);

        setUpToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AgendaHelper crud = new AgendaHelper(getBaseContext());
        final Cursor cursor = crud.getData();

        ListView listView = (ListView) findViewById(R.id.list_view_consulta);
        AgendaCursorAdapter agendaCursorAdapter = new AgendaCursorAdapter(this, cursor);

        assert listView != null;
        listView.setAdapter(agendaCursorAdapter);

        /* lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(LivrosHelper.ID));
                Intent intent = new Intent(ConsAgendaActivity.this, AlteraActivity.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        }); */
    }
}
