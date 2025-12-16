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

/**
 *
 * @author ACER
 */
public class LangkahMemasakDAO {
    

    public boolean addLangkahMemasak(LangkahMemasak langkah) {
        String sql = "INSERT INTO langkah_memasak (id_langkah, resep_id, nomor_urutan, instruksi, foto_langkah_url) VALUES (?, ?, ?, ?, ?)";
        boolean success = false;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, langkah.getIdLangkah());
            stmt.setString(2, langkah.getIdResep());
            stmt.setInt(3, langkah.getNomorUrutan());
            stmt.setString(4, langkah.getIntruksi());
            stmt.setString(5, langkah.getFotoLangkahUrl());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }

        } catch (SQLException e) {
            System.err.println("Gagal menambahkan langkah memasak: " + e.getMessage());
        }
        return success;
    }

    public List<LangkahMemasak> getLangkahMemasakByResepId(String resepId) {
        List<LangkahMemasak> listLangkah = new ArrayList<>();
        String sql = "SELECT * FROM langkah_memasak WHERE resep_id = ? ORDER BY nomor_urutan ASC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, resepId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    LangkahMemasak langkah = new LangkahMemasak();
                    
                    langkah.setIdLangkah(rs.getString("id_langkah"));
                    langkah.setIdResep(rs.getString("resep_id"));
                    langkah.setNomorUrutan(rs.getInt("nomor_langkah"));
                    langkah.setIntruksi(rs.getString("instruksi"));
                    langkah.setFotoLangkahUrl(rs.getString("foto_langkah"));

                    listLangkah.add(langkah);
                }
            }

        } catch (SQLException e) {
            System.err.println("Gagal mengambil langkah memasak untuk Resep ID " + resepId + ": " + e.getMessage());
        }
        return listLangkah;
    }
    
    // Metode untuk Update dan Delete 
}
