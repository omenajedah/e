package com.ekakartika.eka.datawargart04.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ekakartika.eka.datawargart04.DataWargaAdapter;
import com.ekakartika.eka.datawargart04.R;
import com.ekakartika.eka.datawargart04.database.DataSource;
import com.ekakartika.eka.datawargart04.model.DataWarga;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_NOMORKTP = "KEY_NOMORKTP";

    private ListView listView;
    private DataWargaAdapter dataWargaAdapter;
    private DataSource dataSource;

    private List<DataWarga> dataWargaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.listview);

        dataWargaAdapter = new DataWargaAdapter(this, dataWargaList);
        listView.setAdapter(dataWargaAdapter);
        listView.setSelected(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BuatDataActivity.class);
                startActivity(intent);
            }
        });
        dataSource = DataSource.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshList();
    }

    private void refreshList() {
        dataWargaList.clear();
        dataWargaList.addAll(dataSource.select());
        dataWargaAdapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final DataWarga selection = dataWargaList.get(position); //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Lihat Data Warga", "Update Data Warga", "Hapus Data Warga"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getApplicationContext(), LihatDataActivity.class);
                                i.putExtra(KEY_NOMORKTP, selection.getNomorKTP());
                                startActivity(i);
                                break;
                            case 1:
                                Intent in = new Intent(getApplicationContext(), UpdateDataActivity.class);
                                in.putExtra(KEY_NOMORKTP, selection.getNomorKTP());
                                startActivity(in);
                                break;
                            case 2:
                                dataSource.delete(selection);
                                refreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
    }
}
