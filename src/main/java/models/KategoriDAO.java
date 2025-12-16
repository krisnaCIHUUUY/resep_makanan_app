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

public class KategoriDAO {
    
    public boolean addKategori(Kategori kategori) {
        String sql = "INSERT INTO kategori (id_kategori, nama_kategori, slug) VALUES (?, ?, ?)";
        boolean success = false;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, kategori.getIdKategori());
            stmt.setString(2, kategori.getNamaKategori());
            stmt.setString(3, kategori.getSlug());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                System.out.println("Kategori berhasil ditambahkan: " + kategori.getNamaKategori());
            }

        } catch (SQLException e) {
            System.err.println("Gagal menambahkan kategori: " + e.getMessage());
        }
        return success;
    }
    
    public List<Kategori> getAllKategori() {
        List<Kategori> listKategori = new ArrayList<>();
        String sql = "SELECT * FROM kategori ORDER BY nama_kategori ASC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Kategori kategori = new Kategori();
                kategori.setIdKategori(rs.getString("id_kategori"));
                kategori.setNamaKategori(rs.getString("nama_kategori"));
                kategori.setSlug(rs.getString("slug"));
                
                listKategori.add(kategori);
            }

        } catch (SQLException e) {
            System.err.println("Gagal mengambil semua kategori: " + e.getMessage());
        }
        return listKategori;
    }
    
    public Kategori getKategoriById(String idKategori) {
        String sql = "SELECT * FROM kategori WHERE id_kategori = ?";
        Kategori kategori = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idKategori);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    kategori = new Kategori();
                    kategori.setIdKategori(rs.getString("id_kategori"));
                    kategori.setNamaKategori(rs.getString("nama_kategori"));
                    kategori.setSlug(rs.getString("slug"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil kategori berdasarkan ID: " + e.getMessage());
        }
        return kategori;
    }
}