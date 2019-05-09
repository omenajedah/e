package com.ekakartika.eka.datawargart04.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ekakartika.eka.datawargart04.Utils;
import com.ekakartika.eka.datawargart04.model.DataWarga;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static DataSource instance;
    private final DBHelper dbHelper;
    private SQLiteDatabase db;
    private volatile int openedDbCount = 0;

    private DataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public static DataSource getInstance(Context context) {
        synchronized (DataSource.class) {
            if (instance == null)
                instance = new DataSource(context);
        }
        return instance;
    }

    private synchronized void open() {
        openedDbCount++;
        if (openedDbCount == 1) {
            db = dbHelper.getWritableDatabase();
        }
    }

    private synchronized void close() {
        openedDbCount--;
        if (openedDbCount == 0) {
            db.close();
        }
    }

    public void insert(DataWarga dataWarga) {
        ContentValues contentValues = new ContentValues();
        open();
        contentValues.put(TableDataWarga.COLUMN_NOMORKTP, dataWarga.getNomorKTP());
        contentValues.put(TableDataWarga.COLUMN_NAMALENGKAP, dataWarga.getNamaLengkap());
        contentValues.put(TableDataWarga.COLUMN_ALAMATLENGKAP, dataWarga.getAlamatLengkap());
        contentValues.put(TableDataWarga.COLUMN_TEMPATLAHIR, dataWarga.getTempatLahir());
        contentValues.put(TableDataWarga.COLUMN_TANGGALLAHIR,
                Utils.formatDate(dataWarga.getTanggalLahir(), "yyyy-MM-dd"));
        contentValues.put(TableDataWarga.COLUMN_JENISKELAMIN, dataWarga.getJenisKelamin());
        contentValues.put(TableDataWarga.COLUMN_PENDIDIKAN, dataWarga.getPendidikan());
        contentValues.put(TableDataWarga.COLUMN_PEKERJAAN, dataWarga.getPekerjaan());
        contentValues.put(TableDataWarga.COLUMN_AGAMA, dataWarga.getAgama());
        contentValues.put(TableDataWarga.COLUMN_STATUSPERKAWINAN, dataWarga.getStatusPerkawinan());
        db.insert(TableDataWarga.NAME, null, contentValues);
        close();
    }

    public void update(DataWarga dataWarga) {
        ContentValues contentValues = new ContentValues();
        open();
        contentValues.put(TableDataWarga.COLUMN_NAMALENGKAP, dataWarga.getNamaLengkap());
        contentValues.put(TableDataWarga.COLUMN_ALAMATLENGKAP, dataWarga.getAlamatLengkap());
        contentValues.put(TableDataWarga.COLUMN_TEMPATLAHIR, dataWarga.getTempatLahir());
        contentValues.put(TableDataWarga.COLUMN_TANGGALLAHIR,
                Utils.formatDate(dataWarga.getTanggalLahir(), "yyyy-MM-dd"));
        contentValues.put(TableDataWarga.COLUMN_JENISKELAMIN, dataWarga.getJenisKelamin());
        contentValues.put(TableDataWarga.COLUMN_PENDIDIKAN, dataWarga.getPendidikan());
        contentValues.put(TableDataWarga.COLUMN_PEKERJAAN, dataWarga.getPekerjaan());
        contentValues.put(TableDataWarga.COLUMN_AGAMA, dataWarga.getAgama());
        contentValues.put(TableDataWarga.COLUMN_STATUSPERKAWINAN, dataWarga.getStatusPerkawinan());
        db.update(TableDataWarga.NAME, contentValues, "nomorKTP = ?", new String[]{dataWarga.getNomorKTP()});
        close();
    }

    public void delete(DataWarga dataWarga) {
        open();
        db.delete(TableDataWarga.NAME, "nomorKTP = ?", new String[]{dataWarga.getNomorKTP()});
        close();
    }

    public List<DataWarga> select() {
        open();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TableDataWarga.NAME, null);
        List<DataWarga> items = new ArrayList<>();

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                DataWarga dataWarga = new DataWarga();
                dataWarga.setNomorKTP(cursor.getString(
                        cursor.getColumnIndex(TableDataWarga.COLUMN_NOMORKTP)
                ));
                dataWarga.setNamaLengkap(cursor.getString(
                        cursor.getColumnIndex(TableDataWarga.COLUMN_NAMALENGKAP)
                ));
                dataWarga.setAlamatLengkap(cursor.getString(
                        cursor.getColumnIndex(TableDataWarga.COLUMN_ALAMATLENGKAP)
                ));
                dataWarga.setTempatLahir(cursor.getString(
                        cursor.getColumnIndex(TableDataWarga.COLUMN_TEMPATLAHIR)
                ));
                try {
                    dataWarga.setTanggalLahir(
                            Utils.parceDate(cursor.getString(
                                    cursor.getColumnIndex(TableDataWarga.COLUMN_TANGGALLAHIR)
                                    ), "yyyy-MM-dd")
                    );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dataWarga.setJenisKelamin(cursor.getInt(
                        cursor.getColumnIndex(TableDataWarga.COLUMN_JENISKELAMIN)
                ));
                dataWarga.setPendidikan(cursor.getInt(
                        cursor.getColumnIndex(TableDataWarga.COLUMN_PENDIDIKAN)
                ));
                dataWarga.setPekerjaan(cursor.getString(
                        cursor.getColumnIndex(TableDataWarga.COLUMN_PEKERJAAN)
                ));
                dataWarga.setAgama(cursor.getInt(
                        cursor.getColumnIndex(TableDataWarga.COLUMN_AGAMA)
                ));
                dataWarga.setStatusPerkawinan(cursor.getInt(
                        cursor.getColumnIndex(TableDataWarga.COLUMN_STATUSPERKAWINAN)
                ));
                items.add(dataWarga);
            } while (cursor.moveToNext());
        }


        cursor.close();
        return items;
    }


}
