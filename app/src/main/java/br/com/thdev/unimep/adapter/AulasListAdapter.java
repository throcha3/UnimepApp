package br.com.thdev.unimep.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.thdev.unimep.R;
import br.com.thdev.unimep.model.AulasModel;

/**
 * Created by thiag on 02/05/2016.
 */
public class AulasListAdapter extends BaseAdapter {

    ArrayList<AulasModel> myList = new ArrayList<AulasModel>();
    LayoutInflater inflater;
    Context context;


    public AulasListAdapter(Context context, ArrayList<AulasModel> myList) {
        this.myList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public AulasModel getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_list_aulas, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        AulasModel currentListData = getItem(position);

        mViewHolder.tvTitle.setText(currentListData.getDisciplina());
        mViewHolder.tvDesc.setText(currentListData.getProfessor());
        //mViewHolder.ivIcon.setImageResource(currentListData.get());

        return convertView;
    }

    private class MyViewHolder {
        TextView tvTitle, tvDesc;

        public MyViewHolder(View item) {
            tvTitle = (TextView) item.findViewById(R.id.textview_disciplina);
            tvDesc = (TextView) item.findViewById(R.id.textview_professor);
        }
    }
}