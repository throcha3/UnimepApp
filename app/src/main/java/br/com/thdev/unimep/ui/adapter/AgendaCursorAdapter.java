package br.com.thdev.unimep.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.thdev.unimep.R;
import br.com.thdev.unimep.database.Table.AgendaTable;

/**
 * Created by thiag on 12/06/2016.
 */
public class AgendaCursorAdapter extends CursorAdapter {
    public AgendaCursorAdapter(Context context, Cursor cursor) {
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

        int id = cursor.getInt(cursor.getColumnIndexOrThrow(AgendaTable.ID));
        String descricao = cursor.getString(cursor.getColumnIndexOrThrow(AgendaTable.DESCRICAO));
        String tipo = cursor.getString(cursor.getColumnIndexOrThrow(AgendaTable.TIPO));


        txtId.setText(String.valueOf(id));
        txtDescricao.setText(descricao);
        txtTipo.setText(tipo);

    }
}
