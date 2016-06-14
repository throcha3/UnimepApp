package br.com.thdev.unimep.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.thdev.unimep.R;
import br.com.thdev.unimep.adapter.AulasListAdapter;
import br.com.thdev.unimep.model.AulasModel;

public class ListaActivity extends BaseActivity {
    ListView lvDetail;
    Context context = ListaActivity.this;
    ArrayList myList = new ArrayList();

    String[] title = new String[]{
            "Desenvolvimento de Sistemas II", "Programação de Dispositivos Móveis", "Serviços para Redes de computadores ",
            "Formação Complementar I", "Desenvolvimento de Sistemas Web II", "Engenharia de Software"
    };
    String[] desc = new String[]{
            "Seg - Luis Claudiano", "Ter - Monan", "Qua - José Carlos Libardi", "Qui - Monan",
            "Sex - Luis Claudiano", "Sab - Rafael"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        setUpToolbar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvDetail = (ListView) findViewById(R.id.aulas_list);
        // insert data into the list before setting the adapter
        // otherwise it will generate NullPointerException  - Obviously
        getDataInList();
        lvDetail.setAdapter(new AulasListAdapter(context, myList));
        lvDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //The position where the list item is clicked is obtained from the
                //the parameter position of the android listview
                //int itemPosition = position;

                //Get the String value of the item where the user clicked
                //String itemValue = (String) lvDetail.getItemAtPosition(position);

                //In order to start displaying new activity we need an intent
                Intent intent = new Intent(getApplicationContext(), DetalheActivity.class);

                //Putting the Id of image as an extra in intent
                //intent.putExtra("flag", title[position]);

                //Here we will pass the previously created intent as parameter
                startActivity(intent);

            }
        });

    }

    private void getDataInList() {
        for (int i = 0; i < title.length; i++) {
            // Create a new object for each list item
            AulasModel ld = new AulasModel();
            ld.setDisciplina(title[i]);
            ld.setProfessor(desc[i]);
            //ld.setImgResId(img[i]);
            // Add this object into the ArrayList myList
            myList.add(ld);
        }
    }
}
