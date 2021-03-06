package com.havelans.marinete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.havelans.marinete.dominio.Marinete;

import java.util.List;

/**
 * Created by gabriel.fernandes on 04/05/2016.
 */
public class MarineteAdapter extends BaseAdapter {

    private Context context;
    private List<Marinete> marinetes;

    public MarineteAdapter(Context context, List<Marinete> marinetes) {
        this.context = context;
        this.marinetes = marinetes;
    }

    @Override
    public int getCount() {
        return marinetes.size();
    }

    @Override
    public Marinete getItem(int position) {
        return marinetes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_marinete, null);
        }

        TextView text = (TextView) convertView.findViewById(R.id.nome_marinete);
        text.setText(getItem(position).getNome());
        TextView text2 = (TextView) convertView.findViewById(R.id.idade_marinete);
        text2.setText(getItem(position).getIdade()+" anos");
        RatingBar progress = (RatingBar) convertView.findViewById(R.id.avaliacao_marinete);
        progress.setRating(getItem(position).getAvaliacao().floatValue());

        return convertView;
    }

    public void setMarinetes(List<Marinete> marinetes) {
        this.marinetes = marinetes;
    }
}
