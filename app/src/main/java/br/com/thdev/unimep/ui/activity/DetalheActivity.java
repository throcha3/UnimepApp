package br.com.thdev.unimep.ui.activity;

import android.os.Bundle;

import br.com.thdev.unimep.R;

public class DetalheActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        setUpToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Here I have to get the intent extra to show info
    }
}
