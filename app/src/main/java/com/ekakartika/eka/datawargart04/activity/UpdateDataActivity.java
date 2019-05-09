package com.ekakartika.eka.datawargart04.activity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.ekakartika.eka.datawargart04.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UpdateDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
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
