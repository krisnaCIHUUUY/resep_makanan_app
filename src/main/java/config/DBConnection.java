/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Sesuaikan dengan konfigurasi MySQL kamu
    private static final String URL = "jdbc:mysql://localhost:3306/aplikasi_resep";
    private static final String USER = "root"; // Ganti dengan user MySQL kamu
    private static final String PASSWORD = ""; // Ganti dengan password MySQL kamu

    private static Connection connection;

    /**
     * Metode untuk mendapatkan koneksi database.
     * @return Objek Connection yang aktif.
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // 1. Memuat driver JDBC
//                 Class.forName("com.mysql.cj.jdbc.Driver"); // Biasanya tidak wajib lagi di versi Java/MySQL terbaru

                
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Koneksi Database Berhasil!");
            } catch (SQLException e) {
                System.err.println("Koneksi Database Gagal!");
                System.err.println("Error: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null; // Set kembali ke null agar bisa dibuat ulang jika dibutuhkan
                System.out.println("Koneksi Database Ditutup.");
            } catch (SQLException e) {
                System.err.println("Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
}