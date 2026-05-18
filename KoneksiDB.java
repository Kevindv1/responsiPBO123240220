/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql;
import javax.swing.JOptionPane;

/**
 *
 * @author Lab Informatika
 */
public class KoneksiDB {
    static final String DB_URL = "jdbc:mysql://KoneksiDB";
    static final String USER = "root";
    static final String PASS = ""
    
    Connection conn;
    Statement stat;
    public koneksiDB() {
    
        
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn DriverManager.getConnection(DB_URL, USER, PASS);
        stat = conn.createStatement();
    }catch (Exception e) {
     JOptionPane.showMessageDialog(null, "Koneksi GAGAl:" + e.getMessage());
    }    
    
    
    }
    public Connection getConnection() {return conn; }
}
