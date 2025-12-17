/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/aplikasi_resep";
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 

    private static Connection connection;

    public static Connection getConnection() {
        try {
            // PERBAIKAN: Cek apakah koneksi null ATAU sudah tertutup
            if (connection == null || connection.isClosed()) {
                // Memastikan driver dimuat (opsional untuk JDBC modern, tapi aman untuk dilakukan)
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Koneksi Database Berhasil!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Koneksi Database Gagal!");
            System.err.println("Error: " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null; 
                System.out.println("Koneksi Database Ditutup.");
            } catch (SQLException e) {
                System.err.println("Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
}