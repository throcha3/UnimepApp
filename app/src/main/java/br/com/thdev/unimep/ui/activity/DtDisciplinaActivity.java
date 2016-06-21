package br.com.thdev.unimep.ui.activity;

import android.os.Bundle;

import br.com.thdev.unimep.R;

public class DtDisciplinaActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dt_disciplina);
        setUpToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
