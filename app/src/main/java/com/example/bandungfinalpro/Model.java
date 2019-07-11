package com.example.bandungfinalpro;

public class Model {
    String nama, keterangan, gambar, alamat, waktuoperasi, call,map ;
    Integer latitude, longitude;

    //construtor
    public Model  (){}

    //getter and setter


    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getWaktuoperasi() {
        return waktuoperasi;
    }

    public void setWaktuoperasi(String waktuoperasi) {
        this.waktuoperasi = waktuoperasi;
    }

    public String getAlamat() {
        return alamat;
    }



    public String getNama() {
        return nama;
    }

    public void setNama(String title) {
        this.nama = title;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

}
