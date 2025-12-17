/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 * 
 * * @author LENOVO
 */
public class Kategori {
    private String idKategori; 
    private String namaKategori;
    private String slug; 

    public Kategori() {
    }

    public Kategori(String idKategori, String namaKategori, String slug) {
        this.idKategori = idKategori;
        this.namaKategori = namaKategori;
        this.slug = slug;
    }

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }
    
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Kategori{" +
                "idKategori='" + idKategori + '\'' +
                ", namaKategori='" + namaKategori + '\'' +
                '}';
    }
}