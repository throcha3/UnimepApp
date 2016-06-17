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
        return LayoutInflater.from(context).inflate(R.layout.custom_list_agenda, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtId = (TextView) view.findViewById(R.id.txt_id);
        TextView txtDescricao = (TextView) view.findViewById(R.id.txt_desc);
        TextView txtTipo = (TextView) view.findViewById(R.id.txt_tipo);

        int id = cursor.getInt(cursor.getColumnIndexOrThrow(CursoTable.ID));
        String descricao = cursor.getString(cursor.getColumnIndexOrThrow(CursoTable.NOME));
        String tipo = cursor.getString(cursor.getColumnIndexOrThrow(CursoTable.QT_SEMESTRE));


        txtId.setText(String.valueOf(id));
        txtDescricao.setText(descricao);
        txtTipo.setText(tipo);

    }
}
