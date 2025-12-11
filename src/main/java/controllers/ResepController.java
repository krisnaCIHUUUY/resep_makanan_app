/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.List;
import models.Resep;
import models.ResepDAO;

/**
 *
 * @author ACER
 */
public class ResepController {
    
    private ResepDAO resepDAO;
    public ResepController(){
        this.resepDAO = new ResepDAO();
    }
    
    public List<Resep> getAllResep(){
        System.out.println("controller:: mengambil resep");
        return resepDAO.getAllResep();
    }
    
    public boolean simpanResepBaru(Resep resep) {
        // Di sini bisa ditambahkan logika validasi data sebelum disimpan ke DAO
        if (resep.getJudul() == null || resep.getJudul().trim().isEmpty()) {
            System.err.println("Controller: Judul resep tidak boleh kosong.");
            return false;
        }

        System.out.println("Controller: Menyimpan resep baru: " + resep.getJudul());
        return resepDAO.addResep(resep);
    }
    
    // Metode untuk Update dan Delete akan ditambahkan nanti (sesuai kebutuhan View)
    
    // public Resep ambilResepById(String id) { ... }
    // public boolean updateResep(Resep resep) { ... }
    // public boolean hapusResep(String id) { ... }
}
