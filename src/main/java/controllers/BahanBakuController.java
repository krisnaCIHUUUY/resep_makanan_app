/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.List;
import models.BahanBaku;
import models.BahanBakuDAO;

/**
 *
 * @author ACER
 */
public class BahanBakuController {
    private BahanBakuDAO bahanBakuDAO;
    
    public BahanBakuController(){
        this.bahanBakuDAO = new BahanBakuDAO();
    }
    
    public boolean simpanBahanBakuBaru(BahanBaku bahan) {
        // Contoh validasi dasar
        if (bahan.getNamaBahan() == null || bahan.getNamaBahan().trim().isEmpty()) {
            System.err.println("Controller: Nama bahan tidak boleh kosong.");
            return false;
        }
        
        System.out.println("Controller: Menyimpan bahan baku: " + bahan.getNamaBahan());
        return bahanBakuDAO.addBahanBaku(bahan);
    }
    
    public List<BahanBaku> ambilBahanBakuByResepId(String resepId) {
        System.out.println("Controller: Meminta bahan baku untuk Resep ID: " + resepId);
        return bahanBakuDAO.getBahanBakuByResepId(resepId);
    }
}
