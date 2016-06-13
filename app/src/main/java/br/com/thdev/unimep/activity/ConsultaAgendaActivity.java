package br.com.thdev.unimep.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import br.com.thdev.unimep.R;
import br.com.thdev.unimep.adapter.AgendaCursorAdapter;
import br.com.thdev.unimep.database.AgendaDB;

public class ConsultaAgendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_agenda);

        AgendaDB crud = new AgendaDB(getBaseContext());
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
                Intent intent = new Intent(ConsultaAgendaActivity.this, AlteraActivity.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        }); */
    }
}
