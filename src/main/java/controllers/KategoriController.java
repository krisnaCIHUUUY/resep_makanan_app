/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.Kategori;
import models.KategoriDAO;
import java.util.List;

/**
 * Controller untuk mengelola logika bisnis yang terkait dengan entitas Kategori.
 */
public class KategoriController {
    
    private KategoriDAO kategoriDAO;

    public KategoriController() {
        this.kategoriDAO = new KategoriDAO();
    }

    public boolean simpanKategoriBaru(Kategori kategori) {
        if (kategori.getNamaKategori() == null || kategori.getNamaKategori().trim().isEmpty()) {
            System.err.println("Controller: Nama kategori tidak boleh kosong.");
            return false;
        }
        
        System.out.println("Controller: Menyimpan kategori baru: " + kategori.getNamaKategori());
        return kategoriDAO.addKategori(kategori);
    }
    
    public List<Kategori> ambilSemuaKategori() {
        System.out.println("Controller: Meminta semua kategori dari DAO.");
        return kategoriDAO.getAllKategori();
    }
    
    public Kategori ambilKategoriById(String idKategori) {
        if (idKategori == null || idKategori.trim().isEmpty()) {
            System.err.println("Controller: ID Kategori tidak valid.");
            return null;
        }
        return kategoriDAO.getKategoriById(idKategori);
    }
    
    // Metode  Update dan Delete
}
