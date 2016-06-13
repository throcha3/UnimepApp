package br.com.thdev.unimep.activity;

import android.os.Bundle;

import br.com.thdev.unimep.R;

public class DetalheActivity extends BaseActivity {
    private String texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        setUpToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Intent myIntent = getIntent(); // gets the previously created intent
        //String firstKeyName = myIntent.getStringExtra("firstKeyName"); // will return "FirstKeyValue"
        //String secondKeyName= myIntent.getStringExtra("secondKeyName"); // will return "Secon
        //texto = "teste corolhooo";
        //Bundle args = getIntent().getExtras();
        //texto = args.getString("flag");
        //toast("UHU");
    }
}
