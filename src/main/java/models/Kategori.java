/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * 
 * * @author LENOVO
 */
public class Kategori {
    private Long id;
    private String namaKategori;

    public Kategori() {
    }

    
    public Kategori(Long id, String namaKategori) {
        this.id = id;
        this.namaKategori = namaKategori;
    }

    // --- Getter dan Setter ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }
    
    
    @Override
    public String toString() {
        return "Kategori{" +
                "id=" + id +
                ", namaKategori='" + namaKategori + '\'' +
                '}';
    }
}