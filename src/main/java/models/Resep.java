/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ACER
 */
public class Resep {
    private  String idResep;
    private  String judul;
    private  String deskripsi;
    private  int porsi; // int
    private  int waktuMemasak;   // int
    private  String tingkatKesulitan;
    private  String kategoriId; // Foreign Key ke tabel KATEGORI
    private  String fotoUtama;
    
    public Resep(){
    
    }
    
    public Resep(String idResep, String judul, String deskripsi, int porsi, int waktuMemasak, String tingkatKesulitan, String kategoriId, String fotoUtama) {
        this.idResep = idResep;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.porsi = porsi;
        this.waktuMemasak = waktuMemasak;
        this.tingkatKesulitan = tingkatKesulitan;
        this.kategoriId = kategoriId;
        this.fotoUtama = fotoUtama;
    }
    
    public String getIdResep() {
        return idResep;
    }

    public void setIdResep(String idResep) {
        this.idResep = idResep;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getPorsi() {
        return porsi;
    }

    public void setPorsi(int porsi) {
        this.porsi = porsi;
    }

    public int getWaktuMemasak() {
        return waktuMemasak;
    }

    public void setWaktuMemasak(int waktuMemasak) {
        this.waktuMemasak = waktuMemasak;
    }

    public String getTingkatKesulitan() {
        return tingkatKesulitan;
    }

    public void setTingkatKesulitan(String tingkatKesulitan) {
        this.tingkatKesulitan = tingkatKesulitan;
    }

    public String getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(String kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getFotoUtama() {
        return fotoUtama;
    }

    public void setFotoUtama(String fotoUtama) {
        this.fotoUtama = fotoUtama;
    }
    
    
    
    
}
