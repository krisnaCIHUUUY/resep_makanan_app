/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.List;
import models.BahanBaku;
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
    
    public List<Resep> getAllResep() {
        return resepDAO.getAllResep();
    }

    // Method krusial untuk melengkapi data resep sebelum ditampilkan di Detail
    public Resep getDetailResep(Resep resep) {
    if (resep != null) {
        // 1. Ambil Bahan Baku
        List<BahanBaku> bahan = resepDAO.getBahanByResepId(resep.getIdResep());
        resep.setDaftarBahan(bahan);
        
        // 2. Ambil Langkah Memasak (Sekarang dalam bentuk List)
        List<String> langkah = resepDAO.getLangkahByResepId(resep.getIdResep());
        
        // Kita gabungkan List langkah menjadi satu String dengan baris baru (\n) 
        // agar sesuai dengan property String langkahMemasak di class Resep
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < langkah.size(); i++) {
            sb.append((i + 1) + ". " + langkah.get(i) + "\n");
        }
        resep.setLangkahMemasak(sb.toString());
    }
    return resep;
}
    
    public boolean tambahResepBaru(Resep resep) {
    // Validasi Dasar
    if (resep.getJudul().isEmpty() || resep.getDaftarBahan().isEmpty()) {
        System.err.println("Controller: Judul dan Bahan tidak boleh kosong!");
        return false;
    }
    
    // Generate ID unik jika belum ada (Bisa pakai UUID atau Timestamp)
    if (resep.getIdResep() == null || resep.getIdResep().isEmpty()) {
        String uniqueID = String.valueOf(System.currentTimeMillis() / 1000);
        resep.setIdResep(uniqueID);
    }

    return resepDAO.simpanResepLengkap(resep);
}
    
    // Metode Update dan Delete
    
    // public Resep ambilResepById(String id) { ... }
    // public boolean updateResep(Resep resep) { ... }
    // public boolean hapusResep(String id) { ... }
}
