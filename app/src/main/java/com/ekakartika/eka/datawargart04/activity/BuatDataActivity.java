package com.ekakartika.eka.datawargart04.activity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.ekakartika.eka.datawargart04.database.DBHelper;
import com.ekakartika.eka.datawargart04.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BuatDataActivity extends AppCompatActivity {

    protected Cursor cursor;
    DBHelper dbHelper;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_data);

        button = (Button) findViewById(R.id.btn_simpan);
    }

    public void onClick(final View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DATE, day);


                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
                        TextView textView = (TextView) view;
                        textView.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                }, 1990, 0, 0);
        datePickerDialog.show();
    }
}
