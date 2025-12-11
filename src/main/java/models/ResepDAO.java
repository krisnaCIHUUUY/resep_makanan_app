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
 * Data Access Object untuk entitas Resep.
 * Bertanggung jawab untuk operasi CRUD (Create, Read, Update, Delete) di database.
 */
public class ResepDAO {
    public List<Resep> getAllResep() {
        List<Resep> listResep = new ArrayList<>();
        // Query SQL untuk mengambil semua resep
        String sql = "SELECT * FROM RESEP";

        try (
            // Mendapatkan koneksi dari kelas utilitas
            Connection conn = DBConnection.getConnection();
            // Membuat PreparedStatement untuk menjalankan query
            PreparedStatement stmt = conn.prepareStatement(sql);
            // Menjalankan query dan mendapatkan hasilnya
            ResultSet rs = stmt.executeQuery()
        ) {
            // Iterasi melalui setiap baris hasil
            while (rs.next()) {
                Resep resep = new Resep();
                // Mengisi objek Resep dari data ResultSet
                resep.setIdResep(rs.getString("id_resep"));
                resep.setJudul(rs.getString("judul"));
                resep.setDeskripsi(rs.getString("deskripsi"));
                resep.setPorsi(rs.getInt("porsi"));
                resep.setWaktuMemasak(rs.getInt("waktu_masak"));
                resep.setTingkatKesulitan(rs.getString("tingkat_kesulitan"));
                resep.setFotoUtama(rs.getString("foto_utama_url"));
                resep.setKategoriId(rs.getString("kategori_id"));

                listResep.add(resep);
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil semua resep: " + e.getMessage());
        } finally {
             // Secara teknis koneksi ditutup secara otomatis karena menggunakan try-with-resources
             // Namun, jika menggunakan getConnection(), pastikan untuk menutupnya atau mengandalkan try-with-resources.
             // Di contoh ini, DBConnection.getConnection() mengembalikan objek Connection yang akan ditutup
             // otomatis oleh try-with-resources setelah blok try selesai.
        }
        return listResep;
    }

    /**
     * Menyimpan objek Resep baru ke database. (Create)
     * @param resep Objek Resep yang akan disimpan.
     * @return true jika berhasil, false jika gagal.
     */
    public boolean addResep(Resep resep) {
        String sql = "INSERT INTO RESEP (id_resep, judul, deskripsi, porsi, waktu_memasak, tingkat_kesulitan, foto_utama_url, kategori_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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

    // Metode Update dan Delete akan ditambahkan nanti sesuai kebutuhan.
}