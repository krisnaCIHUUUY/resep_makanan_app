/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import models.LangkahMemasak;
import models.LangkahMemasakDAO;
import java.util.List;

public class LangkahMemasakController {
    
    private LangkahMemasakDAO langkahMemasakDAO;

    public LangkahMemasakController() {
        this.langkahMemasakDAO = new LangkahMemasakDAO();
    }
    
    public boolean simpanLangkahBaru(LangkahMemasak langkah) {
        if (langkah.getIntruksi()== null || langkah.getIntruksi().trim().isEmpty()) {
            System.err.println("Controller: Instruksi langkah memasak tidak boleh kosong.");
            return false;
        }
        if (langkah.getNomorUrutan() <= 0) {
             System.err.println("Controller: Nomor langkah harus lebih dari nol.");
            return false;
        }
        if (langkah.getIdResep()== null || langkah.getIdResep().trim().isEmpty()) {
             System.err.println("Controller: Langkah harus terkait dengan ID Resep.");
            return false;
        }
        
        System.out.println("Controller: Menyimpan langkah ke-" + langkah.getNomorUrutan());
        return langkahMemasakDAO.addLangkahMemasak(langkah);
    }

    public List<LangkahMemasak> ambilLangkahByResepId(String resepId) {
        if (resepId == null || resepId.trim().isEmpty()) {
            System.err.println("Controller: ID Resep tidak boleh kosong saat mengambil langkah.");
            return List.of(); // Mengembalikan List kosong
        }
        
        System.out.println("Controller: Meminta langkah memasak untuk Resep ID: " + resepId);
        return langkahMemasakDAO.getLangkahMemasakByResepId(resepId);
    }
    
    // Metode Update dan Delete
}
