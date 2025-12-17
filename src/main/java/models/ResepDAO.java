/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import config.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResepDAO {
    public List<Resep> getAllResep() {
        List<Resep> listResep = new ArrayList<>();
        String sql = "SELECT resep.*, kategori.nama_kategori FROM resep " +
                     "JOIN kategori ON resep.kategori_id = kategori.id_kategori";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Resep resep = mapResultSetToResep(rs);
                listResep.add(resep);
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil semua resep: " + e.getMessage());
        }
        return listResep;
    }
    
    // Tambahkan method ini di dalam class ResepDAO
public List<String> getLangkahByResepId(String idResep) {
    List<String> listLangkah = new ArrayList<>();
    // Ambil instruksi saja, diurutkan berdasarkan urutan memasak
    String sql = "SELECT instruksi FROM langkah_memasak WHERE resep_id = ? ORDER BY nomor_urutan ASC";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, idResep);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                listLangkah.add(rs.getString("instruksi"));
            }
        }
    } catch (SQLException e) {
        System.err.println("Gagal mengambil langkah memasak: " + e.getMessage());
    }
    return listLangkah;
}
    
    public List<BahanBaku> getBahanByResepId(String idResep) {
        List<BahanBaku> listBahan = new ArrayList<>();
        String sql = "SELECT * FROM bahan_baku WHERE resep_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, idResep);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    BahanBaku bahan = new BahanBaku();
                    bahan.setNamaBahan(rs.getString("nama_bahan"));
                    bahan.setJumlah(rs.getInt("jumlah"));
                    bahan.setSatuan(rs.getString("satuan"));
                    listBahan.add(bahan);
                }
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil bahan baku: " + e.getMessage());
        }
        return listBahan;
    }
    
    private Resep mapResultSetToResep(ResultSet rs) throws SQLException {
        Resep resep = new Resep();
        resep.setIdResep(rs.getString("id_resep"));
        resep.setJudul(rs.getString("judul"));
        resep.setDeskripsi(rs.getString("deskripsi"));
        resep.setPorsi(rs.getInt("porsi"));
        resep.setWaktuMemasak(rs.getInt("waktu_masak"));
        resep.setTingkatKesulitan(rs.getString("tingkat_kesulitan"));
        resep.setFotoUtama(rs.getString("foto_utama_url"));
        resep.setNamaKategori(rs.getString("nama_kategori"));
        
        // Asumsi: langkah_memasak ada di kolom teks panjang di tabel resep
        // Jika tabel terpisah, Anda perlu buat method getLangkahByResepId
//        resep.setLangkahMemasak(rs.getString("langkah_memasak"));
        return resep;
    }

    public boolean addResep(Resep resep) {
        String sql = "INSERT INTO resep (id_resep, judul, deskripsi, porsi, waktu_memasak, tingkat_kesulitan, foto_utama_url, kategori_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        boolean success = false;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, resep.getIdResep());
            stmt.setString(2, resep.getJudul());
            stmt.setString(3, resep.getDeskripsi());
            stmt.setInt(4, resep.getPorsi());
            stmt.setInt(5, resep.getWaktuMemasak());
            stmt.setString(6, resep.getTingkatKesulitan());
            stmt.setString(7, resep.getKategoriId());
            stmt.setString(8, resep.getFotoUtama());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                System.out.println("Resep berhasil ditambahkan: " + resep.getJudul());
            }

        } catch (SQLException e) {
            System.err.println("Gagal menambahkan resep: " + e.getMessage());
        }
        return success;
    }


    // Metode Update dan Delete 
}