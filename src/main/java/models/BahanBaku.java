package models;

/**
 * @author Saiful
 */
public class BahanBaku {
    private String idBahan;
    private String resepId; 
    private String namaBahan;
    private double jumlah; // Menggunakan double agar mendukung angka seperti 0.5 atau 1.5
    private String satuan;

    public BahanBaku() {
    }

    public BahanBaku(String idBahan, String resepId, String namaBahan, double jumlah, String satuan) {
        this.idBahan = idBahan;
        this.resepId = resepId;
        this.namaBahan = namaBahan;
        this.jumlah = jumlah;
        this.satuan = satuan;
    }

    // --- Getter dan Setter ---

    public String getIdBahan() { return idBahan; }
    public void setIdBahan(String idBahan) { this.idBahan = idBahan; }

    public String getResepId() { return resepId; }
    public void setResepId(String resepId) { this.resepId = resepId; }

    public String getNamaBahan() { return namaBahan; }
    public void setNamaBahan(String namaBahan) { this.namaBahan = namaBahan; }

    public double getJumlah() { return jumlah; }
    public void setJumlah(double jumlah) { this.jumlah = jumlah; }

    public String getSatuan() { return satuan; }
    public void setSatuan(String satuan) { this.satuan = satuan; }

    @Override
    public String toString() {
        return namaBahan + " (" + jumlah + " " + satuan + ")";
    }
}