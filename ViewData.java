package View.Kredit;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewData extends JFrame {
    public JTable table;
    public JTextField tfId, tfNama, tfJaminan, tfKapasitas, tfKarakter;
    public JComboBox<String> cbTipe;
    public JButton btnAdd, btnUpdate, btnDelete, btnClear;

    public ViewData() {
        setTitle("Sistem Evaluasi Pengajuan Kredit");
        setSize(850, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 550, 350);
        add(scrollPane);

        JLabel lNama = new JLabel("Nama:");
        lNama.setBounds(600, 20, 100, 20);
        add(lNama);
        tfNama = new JTextField();
        tfNama.setBounds(600, 40, 200, 25);
        add(tfNama);

        JLabel lTipe = new JLabel("Tipe Pinjaman:");
        lTipe.setBounds(600, 70, 100, 20);
        add(lTipe);
        cbTipe = new JComboBox<>(new String[]{"Pinjaman Personal", "Pinjaman Usaha"});
        cbTipe.setBounds(600, 90, 200, 25);
        add(cbTipe);

        JLabel lJaminan = new JLabel("Nilai Jaminan:");
        lJaminan.setBounds(600, 120, 100, 20);
        add(lJaminan);
        tfJaminan = new JTextField();
        tfJaminan.setBounds(600, 140, 200, 25);
        add(tfJaminan);

        JLabel lKapasitas = new JLabel("Nilai Kapasitas:");
        lKapasitas.setBounds(600, 170, 100, 20);
        add(lKapasitas);
        tfKapasitas = new JTextField();
        tfKapasitas.setBounds(600, 190, 200, 25);
        add(tfKapasitas);

        JLabel lKarakter = new JLabel("Nilai Karakter:");
        lKarakter.setBounds(600, 220, 100, 20);
        add(lKarakter);
        tfKarakter = new JTextField();
        tfKarakter.setBounds(600, 240, 200, 25);
        add(tfKarakter);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(600, 280, 90, 25);
        add(btnAdd);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(710, 280, 90, 25);
        add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(600, 315, 90, 25);
        add(btnDelete);

        btnClear = new JButton("Clear");
        btnClear.setBounds(710, 315, 90, 25);
        add(btnClear);

        tfId = new JTextField();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                tfId.setText(table.getValueAt(row, 0).toString());
                tfNama.setText(table.getValueAt(row, 1).toString());
                cbTipe.setSelectedItem(table.getValueAt(row, 2).toString());
                tfJaminan.setText(table.getValueAt(row, 3).toString());
                tfKapasitas.setText(table.getValueAt(row, 4).toString());
                tfKarakter.setText(table.getValueAt(row, 5).toString());
            }
        });

        setVisible(true);
    }
}