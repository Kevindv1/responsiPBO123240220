/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.;
import view.MainView;
import java.awt.event.;
import java.awt.sql.;
import javax.awt.event.;

public class MainController {
    MainView view;
    KoneksiDB db;
    public MainController (MainView view, KoneksiDB db) {
    
   this.view = view;
   this.db = db;
   loadData();
   
   view.btnAdd.addActionListener (new AcctionListener () {
   @override 
   public void actionPerformed (new ActionEvent e) {
   
       try {
       
           String nama = view.tfnama.getText();
           String tipe = view.cbTipe.getSelecteditem().toString();
           
           int jaminan = Integer.parseInt(view.tfWriting.getText());
           int kapasitas = Integer.parseInt(view.tfKapasitas.getText());
           int karakter = Integer.parseInt(view.tfKarakter.getText());
           
           Developer dev = new Developer(nama, tipe, writing, coding, interview);
           
           double score = dev.hitungNilaiAkhir();
           String status = dev.tentukanStatus(score);
           
           String query = "INSERT INTO recruit (nama, tipe, jaminan, kapasitas, karakter, score, status)" +
                   "VALUES ('"+nama+"'), ('"+tipe+"'), ('"+jaminan+"'), ('"+kapasitas+"'), ('"+karakter+"'), ('"+score+"'), ('"+status+"')";
           
           db.getConnection().createStatement().executeUpdate(query);
           JOptionPane.showMessageDialog(null, "Data berhasl ditambahkan");
           
           loadData();
       
       } catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(null, "Input harus berupa angka bulat");
       } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, "Error DB: "+ ex.getMesaage());
       }
   
   }
   
   });
           
    
    }
    
} private void loadData() {
view.tableModel.setRowCount(0);
try {
ResultSet rs = db.getConnection().createStatement().executeQuery("SELECT * FROM recruit");
} while (rs.next()) {
  view.tableModel.addRow(new Object[]) {
  rs.getString("nama"),
rs.getString("tipe"),
rs.getString("jaminan"),
rs.getString("kapasitas"),
rs.getString("karakter"),
rs.getString("score"),
rs.getString("status")
}  
}

}

