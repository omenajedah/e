package com.ekakartika.eka.datawargart04.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.ekakartika.eka.datawargart04.R;
import com.ekakartika.eka.datawargart04.Utils;
import com.ekakartika.eka.datawargart04.database.DataSource;
import com.ekakartika.eka.datawargart04.model.DataWarga;

import static com.ekakartika.eka.datawargart04.activity.MainActivity.KEY_NOMORKTP;

public class LihatDataActivity extends AppCompatActivity {

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

    private DataSource dataSource;
    private DataWarga dataWarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);
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
}
