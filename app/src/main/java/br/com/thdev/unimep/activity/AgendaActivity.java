package br.com.thdev.unimep.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.thdev.unimep.R;
import br.com.thdev.unimep.database.AgendaDB;
import br.com.thdev.unimep.model.AgendaModel;

public class AgendaActivity extends BaseActivity {

    private EditText mEdtTipo;
    private EditText mEdtIDDisciplina;
    private EditText mEdtDeadLine;
    private EditText mEdtDescricao;
    private Button mBtnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        Log.d("BROCOLIS", "CRIANDO ACTAGENDA");
        setUpToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mEdtTipo = (EditText) findViewById(R.id.edt_tipo);
        mEdtIDDisciplina = (EditText) findViewById(R.id.edt_id_disciplina);
        mEdtDeadLine = (EditText) findViewById(R.id.edt_deadline);
        mEdtDescricao = (EditText) findViewById(R.id.edt_descricao);


        mBtnSalvar = (Button) findViewById(R.id.btn_salvar);
        mBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BROCOLIS", "dentro do onclick..");
                AgendaDB banco = new AgendaDB(getBaseContext());
                AgendaModel agenda = new AgendaModel();
                //agenda.setId_disciplina(mEdtIDDisciplina.getText());
                agenda.setDescricao(String.valueOf(mEdtDescricao.getText()));
                agenda.setTipo(String.valueOf(mEdtTipo.getText()));

                banco.save(agenda);
                toast("salvou");
            }
        });
    }
}
