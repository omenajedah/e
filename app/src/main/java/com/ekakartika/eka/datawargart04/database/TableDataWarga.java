package com.ekakartika.eka.datawargart04.database;

/**
 * Created by Firman on 5/8/2019.
 */
public interface TableDataWarga {
    String NAME = "tbl_datawarga";

    String COLUMN_NOMORKTP = "nomorKTP";
    String COLUMN_NAMALENGKAP = "namaLengkap";
    String COLUMN_ALAMATLENGKAP = "alamatLengkap";
    String COLUMN_TEMPATLAHIR = "tempatLahir";
    String COLUMN_TANGGALLAHIR = "tanggalLahir";
    String COLUMN_JENISKELAMIN = "jenisKelamin";
    String COLUMN_PENDIDIKAN = "pendidikan";
    String COLUMN_PEKERJAAN = "pekerjaan";
    String COLUMN_AGAMA = "agama";
    String COLUMN_STATUSPERKAWINAN = "statusPerkawinan";

    String SQL_CREATE = "CREATE TABLE " + NAME + " (" +
            COLUMN_NOMORKTP + " CHAR(20) NOT NULL PRIMARY KEY," +
            COLUMN_NAMALENGKAP + " VARCHAR(100)," +
            COLUMN_ALAMATLENGKAP + " VARCHAR(255)," +
            COLUMN_TEMPATLAHIR + " VARCHAR(100)," +
            COLUMN_TANGGALLAHIR + " DATE," +
            COLUMN_JENISKELAMIN + " TINYINT(1)," +
            COLUMN_PENDIDIKAN + " TINYINT(1)," +
            COLUMN_PEKERJAAN + " VARCHAR(100)," +
            COLUMN_AGAMA + " TINYINT(1)," +
            COLUMN_STATUSPERKAWINAN + " TINYINT(1));";
}
