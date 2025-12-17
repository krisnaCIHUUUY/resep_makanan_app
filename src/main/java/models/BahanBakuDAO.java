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

public class BahanBakuDAO {
    public boolean addBahanBaku(BahanBaku bahan) {
        String sql = "INSERT INTO Bahan_baku (id_bahan, resep_id, nama_bahan, jumlah, satuan) VALUES (?, ?, ?, ?, ?)";
        boolean success = false;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bahan.getIdBahan());
            stmt.setString(2, bahan.getResepId());
            stmt.setString(3, bahan.getNamaBahan());
            stmt.setInt(4, (int) bahan.getJumlah());
            stmt.setString(5, bahan.getSatuan());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }

        } catch (SQLException e) {
            System.err.println("Gagal menambahkan bahan baku: " + e.getMessage());
        }
        return success;
    }
    
    public List<BahanBaku> getBahanBakuByResepId(String resepId) {
        List<BahanBaku> listBahan = new ArrayList<>();
        String sql = "SELECT * FROM bahan_baku WHERE resep_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, resepId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    BahanBaku bahan = new BahanBaku();
                    bahan.setIdBahan(rs.getString("id_bahan"));
                    bahan.setResepId(rs.getString("resep_id"));
                    bahan.setNamaBahan(rs.getString("nama_bahan"));
                    bahan.setJumlah(rs.getDouble("jumlah"));
                    bahan.setSatuan(rs.getString("satuan"));

                    listBahan.add(bahan);
                }
            }

        } catch (SQLException e) {
            System.err.println("Gagal mengambil bahan baku untuk Resep ID " + resepId + ": " + e.getMessage());
        }
        return listBahan;
    }
}
