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
        
        return resep;
    }

    public boolean simpanResepLengkap(Resep resep) {
    Connection conn = null;
    try {
        conn = DBConnection.getConnection();
        conn.setAutoCommit(false); 

        // 1. Simpan ke tabel 'resep'
        String sqlResep = "INSERT INTO resep (id_resep , judul, deskripsi, porsi, waktu_masak, tingkat_kesulitan, foto_utama_url, kategori_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmtResep = conn.prepareStatement(sqlResep)) {
            stmtResep.setString(1, resep.getIdResep());
            stmtResep.setString(2, resep.getJudul());
            stmtResep.setString(3, resep.getDeskripsi());
            stmtResep.setInt(4, resep.getPorsi());
            stmtResep.setInt(5, resep.getWaktuMemasak());
            stmtResep.setString(6, resep.getTingkatKesulitan());
            stmtResep.setString(7, resep.getFotoUtama());
            stmtResep.setString(8, resep.getKategoriId());
            stmtResep.executeUpdate();
        }

        // 2. Simpan ke tabel 'bahan_baku'
        String sqlBahan = "INSERT INTO bahan_baku (resep_id, nama_bahan, jumlah, satuan) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmtBahan = conn.prepareStatement(sqlBahan)) {
            for (BahanBaku bahan : resep.getDaftarBahan()) {
                stmtBahan.setString(1, resep.getIdResep());
                stmtBahan.setString(2, bahan.getNamaBahan());
                stmtBahan.setDouble(3, bahan.getJumlah());
                stmtBahan.setString(4, bahan.getSatuan());
                stmtBahan.addBatch(); 
            }
            stmtBahan.executeBatch();
        }

        // 3. Simpan ke tabel 'langkah_memasak'
        String sqlLangkah = "INSERT INTO langkah_memasak (resep_id, nomor_urutan, instruksi) VALUES (?, ?, ?)";
        try (PreparedStatement stmtLangkah = conn.prepareStatement(sqlLangkah)) {
            // Kita asumsikan langkah dipisah per baris di JTextArea
            String[] steps = resep.getLangkahMemasak().split("\n");
            for (int i = 0; i < steps.length; i++) {
                if (!steps[i].trim().isEmpty()) {
                    stmtLangkah.setString(1, resep.getIdResep());
                    stmtLangkah.setInt(2, i + 1);
                    stmtLangkah.setString(3, steps[i].trim());
                    stmtLangkah.addBatch();
                }
            }
            stmtLangkah.executeBatch();
        }

        conn.commit(); // Jika semua sukses, simpan permanen
        return true;

    } catch (SQLException e) {
        if (conn != null) {
            try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        }
        System.err.println("Gagal simpan resep lengkap: " + e.getMessage());
        return false;
    }
}


    // Metode Update dan Delete 
}