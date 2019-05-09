package com.ekakartika.eka.datawargart04;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ekakartika.eka.datawargart04.model.DataWarga;

import java.util.List;

public class DataWargaAdapter extends ArrayAdapter<DataWarga> {

    private List<DataWarga> dataWargaList;
    public DataWargaAdapter(@NonNull Context context, List<DataWarga> dataWargaList) {
        super(context, android.R.layout.simple_list_item_1, dataWargaList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(getItem(position).getNamaLengkap());
        return convertView;
    }
}
