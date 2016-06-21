package br.com.thdev.unimep.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.thdev.unimep.R;
import br.com.thdev.unimep.database.Table.CursoTable;

/**
 * Created by thiag on 16/06/2016.
 */
public class CursoCursorAdapter extends CursorAdapter {
    public CursoCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.custom_list_cursos, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtNomeCurso = (TextView) view.findViewById(R.id.txt_nome_curso);
        TextView txtFaculdade = (TextView) view.findViewById(R.id.txt_facul);
        TextView txtSemestres = (TextView) view.findViewById(R.id.txt_semestres);


        String nomeCurso = cursor.getString(cursor.getColumnIndexOrThrow(CursoTable.NOME));
        String faculdade = cursor.getString(cursor.getColumnIndexOrThrow(CursoTable.FACULDADE));
        int semestres = cursor.getInt(cursor.getColumnIndexOrThrow(CursoTable.QT_SEMESTRE));

        String aux = "Semestres: " + String.valueOf(semestres);

        txtSemestres.setText(aux);
        txtNomeCurso.setText(nomeCurso);
        txtFaculdade.setText(faculdade);

    }
}
