package com.ekakartika.eka.datawargart04.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class DataWarga {
    private String nomorKTP;
    private String namaLengkap;
    private String alamatLengkap;
    private String tempatLahir;
    private Date tanggalLahir;
    private int jenisKelamin;
    private int pendidikan;
    private String pekerjaan;
    private int agama;
    private int statusPerkawinan;

    public DataWarga() {
    }

    public String getNomorKTP() {
        return nomorKTP;
    }

    public void setNomorKTP(String nomorKTP) {
        this.nomorKTP = nomorKTP;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getAlamatLengkap() {
        return alamatLengkap;
    }

    public void setAlamatLengkap(String alamatLengkap) {
        this.alamatLengkap = alamatLengkap;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public int getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(int jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public int getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(int pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public int getAgama() {
        return agama;
    }

    public void setAgama(int agama) {
        this.agama = agama;
    }

    public int getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(int statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

    @Override
    public String toString() {
        return "DataWarga{" +
                "nomorKTP='" + nomorKTP + '\'' +
                ", namaLengkap='" + namaLengkap + '\'' +
                ", alamatLengkap='" + alamatLengkap + '\'' +
                ", tempatLahir='" + tempatLahir + '\'' +
                ", tanggalLahir=" + tanggalLahir +
                ", jenisKelamin=" + jenisKelamin +
                ", pendidikan=" + pendidikan +
                ", pekerjaan='" + pekerjaan + '\'' +
                ", agama=" + agama +
                ", statusPerkawinan=" + statusPerkawinan +
                '}';
    }
}
