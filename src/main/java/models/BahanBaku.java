/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 * Model class untuk merepresentasikan entitas BAHAN_BAKU.
 * Sesuai dengan struktur tabel BAHAN_BAKU di database.
 */
public class BahanBaku {
    private String idBahan;
    private String resepId; // Foreign Key ke Resep
    private String namaBahan;
    private int jumlah;
    private String satuan;

    // --- Constructor ---

    public BahanBaku() {
        // Default constructor
    }

    public BahanBaku(String idBahan, String resepId, String namaBahan, int jumlah, String satuan) {
        this.idBahan = idBahan;
        this.resepId = resepId;
        this.namaBahan = namaBahan;
        this.jumlah = jumlah;
        this.satuan = satuan;
    }

    // --- Getter dan Setter ---

    public String getIdBahan() {
        return idBahan;
    }

    public void setIdBahan(String idBahan) {
        this.idBahan = idBahan;
    }

    public String getResepId() {
        return resepId;
    }

    public void setResepId(String resepId) {
        this.resepId = resepId;
    }

    public String getNamaBahan() {
        return namaBahan;
    }

    public void setNamaBahan(String namaBahan) {
        this.namaBahan = namaBahan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    // Metode toString() untuk debugging
    @Override
    public String toString() {
        return "BahanBaku{" + "idBahan=" + idBahan + ", namaBahan=" + namaBahan + ", jumlah=" + jumlah + " " + satuan + '}';
    }
}