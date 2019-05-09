package com.ekakartika.eka.datawargart04.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ekakartika.eka.datawargart04.R;
import com.ekakartika.eka.datawargart04.Utils;
import com.ekakartika.eka.datawargart04.database.DataSource;
import com.ekakartika.eka.datawargart04.model.DataWarga;

import java.util.Calendar;

import static com.ekakartika.eka.datawargart04.activity.MainActivity.KEY_NOMORKTP;

public class UpdateDataActivity extends AppCompatActivity {

    private EditText nikET;
    private EditText namaLengkapET;
    private EditText alamatLengkapET;
    private EditText tempatLahirET;
    private EditText pekerjaanET;
    private Spinner jenisKelaminSP;
    private Spinner pendidikanSP;
    private Spinner agamaSP;
    private Spinner statusKawinSP;
    private TextView tanggalLahirTV;

    private Calendar calendar;
    private DataSource dataSource;
    private DataWarga dataWarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        nikET = findViewById(R.id.et_nomor_nik);
        namaLengkapET = findViewById(R.id.et_nama_lengkap);
        alamatLengkapET = findViewById(R.id.et_alamat_lengkap);
        tempatLahirET = findViewById(R.id.et_tempat_lahir);
        pekerjaanET = findViewById(R.id.et_pekerjaan);

        jenisKelaminSP = findViewById(R.id.spinner_jeniskelamin);
        pendidikanSP = findViewById(R.id.spinner_pendidikan);
        agamaSP = findViewById(R.id.spinner_agama);
        statusKawinSP = findViewById(R.id.spinner_status);
        tanggalLahirTV = findViewById(R.id.tv_tanggallahir2);

        dataSource = DataSource.getInstance(this);
        dataWarga = dataSource.select(getIntent().getStringExtra(KEY_NOMORKTP));
        tampilkanData();
    }

    private void tampilkanData() {

        nikET.setText(dataWarga.getNomorKTP());
        namaLengkapET.setText(dataWarga.getNamaLengkap());
        alamatLengkapET.setText(dataWarga.getAlamatLengkap());
        tempatLahirET.setText(dataWarga.getTempatLahir());
        pekerjaanET.setText(dataWarga.getPekerjaan());
        jenisKelaminSP.setSelection(dataWarga.getJenisKelamin());
        pendidikanSP.setSelection(dataWarga.getPendidikan());
        agamaSP.setSelection(dataWarga.getAgama());
        statusKawinSP.setSelection(dataWarga.getStatusPerkawinan());
        tanggalLahirTV.setText(Utils.formatDate(dataWarga.getTanggalLahir(), "dd MMM yyyy"));
    }

    public void onDateClick(final View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        if (calendar == null)
                            calendar = Calendar.getInstance();

                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DATE, day);


                        TextView textView = (TextView) view;
                        textView.setText(Utils.formatDate(calendar.getTime(), "dd MMM yyyy"));
                        dataWarga.setTanggalLahir(calendar.getTime());
                    }
                }, 1990, 0, 0);
        datePickerDialog.show();
    }

    public void onSimpanClick(View view) {
        dataWarga.setNomorKTP(nikET.getText().toString());
        dataWarga.setNamaLengkap(namaLengkapET.getText().toString());
        dataWarga.setAlamatLengkap(alamatLengkapET.getText().toString());
        dataWarga.setTempatLahir(tempatLahirET.getText().toString());
        dataWarga.setPekerjaan(pekerjaanET.getText().toString());
        dataWarga.setJenisKelamin(jenisKelaminSP.getSelectedItemPosition());
        dataWarga.setPendidikan(pendidikanSP.getSelectedItemPosition());
        dataWarga.setAgama(agamaSP.getSelectedItemPosition());
        dataWarga.setStatusPerkawinan(statusKawinSP.getSelectedItemPosition());
        dataWarga.setTanggalLahir(dataWarga.getTanggalLahir());

        dataSource.update(dataWarga);
        finish();
        Toast.makeText(this, "Data Warga Berhasil Diubah!", Toast.LENGTH_SHORT).show();
    }

    public void onBatalClick(View view) {
        finish();
    }
}
