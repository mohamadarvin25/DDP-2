package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class TambahMataKuliahGUI{
    
    // Attributes
    private JPanel addMatkulPanel = new JPanel();
    private JLabel labelKode = new JLabel("Kode Mata Kuliah:");
    private JLabel labelNama = new JLabel("Nama Mata Kuliah:");
    private JLabel labelSKS = new JLabel("SKS:");
    private JLabel labelKapasitas = new JLabel("Kapasitas");
    private JTextField textKode = new JTextField();
    private JTextField textNama = new JTextField();
    private JTextField textSKS = new JTextField();
    private JTextField textKapasitas = new JTextField();
    private JButton buttonTambah = new JButton("Tambahkan");
    private JButton buttonKembali = new JButton("Kembali");

    public TambahMataKuliahGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Tambah Mata Kuliah");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        
        // Set alignment serta warna dari label 
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(149,149,149));
        labelKode.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelKode.setForeground(new Color(209,209,209));
        labelNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNama.setForeground(new Color(209,209,209));
        labelSKS.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelSKS.setForeground(new Color(209,209,209));
        labelKapasitas.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelKapasitas.setForeground(new Color(209,209,209));

        // Set alignment dan size dari text field
        textKode.setAlignmentX(Component.CENTER_ALIGNMENT);
        textKode.setMaximumSize(new Dimension(175,25));
        textNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        textNama.setMaximumSize(new Dimension(175,25));
        textSKS.setAlignmentX(Component.CENTER_ALIGNMENT);
        textSKS.setMaximumSize(new Dimension(175,25));
        textKapasitas.setAlignmentX(Component.CENTER_ALIGNMENT);
        textKapasitas.setMaximumSize(new Dimension(175,25));

        // Set alignment, warna, serta font dari button
        buttonTambah.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonTambah.setBackground(new Color(30,30,30));
        buttonTambah.setForeground(new Color(209,209,209));
        buttonTambah.setFont(SistemAkademikGUI.fontGeneral);
        // Set fungsi ketika button ditekan
        buttonTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Jika ada text field yang kosong, keluarkan dialog
                if (textKode.getText().equals("") || textNama.getText().equals("") || textSKS.getText().equals("") || textKapasitas.getText().equals("")) {
                    JOptionPane.showMessageDialog(addMatkulPanel, "Mohon isi seluruh Field");
                    return;
                }
                // Ambil nama dari text field
                String nama = textNama.getText();
                // Jika nama yang ingin di add sudah terdaftar, keluarkan dialog
                if (getMataKuliah(nama, daftarMataKuliah) != null) {
                    JOptionPane.showMessageDialog(addMatkulPanel, String.format("Mata Kuliah %s sudah pernah ditambahkan sebelumnya", nama));
                }
                // Selain itu, lakukan add matkul
                else {
                    // Ambil kode, sks, dan kapasitas dari text field
                    String kode = textKode.getText();
                    String sks = textSKS.getText();
                    // Konvert sks ke bentuk integer
                    int sksInt = Integer.valueOf(sks);
                    String kapasitas = textKapasitas.getText();
                    // Konvert kapasitas ke bentuk integer
                    int kapasitasInt = Integer.valueOf(kapasitas);
                    // Add matkul
                    daftarMataKuliah.add(new MataKuliah(kode, nama, sksInt, kapasitasInt));
                    // Keluarkan dialog
                    JOptionPane.showMessageDialog(addMatkulPanel, String.format("Mata Kuliah %s berhasil ditambahkan", nama));
                }
            }
        });
        buttonTambah.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                buttonTambah.setBackground(new Color(59,80,250));
                buttonTambah.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                buttonTambah.setBackground(new Color(30,30,30));
                buttonTambah.setForeground(new Color(209,209,209));
            }
        });

        // Set alignment, warna, serta font dari button
        buttonKembali.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonKembali.setBackground(new Color(30,30,30));
        buttonKembali.setForeground(new Color(209,209,209));
        buttonKembali.setFont(SistemAkademikGUI.fontGeneral);
        // Set fungsi ketika button ditekan
        buttonKembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lakukan sorting daftarMataKuliah
                sorting(daftarMataKuliah);
                // Buat object HomeGUI baru
                new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Set visibility dari addMatkulPanel menjadi false
                addMatkulPanel.setVisible(false);
            }
        });
        buttonKembali.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                buttonKembali.setBackground(new Color(59,80,250));
                buttonKembali.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                buttonKembali.setBackground(new Color(30,30,30));
                buttonKembali.setForeground(new Color(209,209,209));
            }
        });

        // Set layout dari addMatkulPanel
        addMatkulPanel.setLayout(new BoxLayout(addMatkulPanel, BoxLayout.Y_AXIS));
        // Set background color dari addMatkulPanel
        addMatkulPanel.setBackground(new Color(30,30,30));
        // Tambah label, text field, button, serta space kosong diantaranya pada addMatkulPanel
        addMatkulPanel.add(titleLabel);
        addMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMatkulPanel.add(labelKode);
        addMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMatkulPanel.add(textKode);
        addMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMatkulPanel.add(labelNama);
        addMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMatkulPanel.add(textNama);
        addMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMatkulPanel.add(labelSKS);
        addMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMatkulPanel.add(textSKS);
        addMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMatkulPanel.add(labelKapasitas);
        addMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMatkulPanel.add(textKapasitas);
        addMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMatkulPanel.add(buttonTambah);
        addMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMatkulPanel.add(buttonKembali);

        // Tambah addMatkulPanel ke frame
        frame.add(addMatkulPanel);
    }

    // Method getMataKuliah
    private MataKuliah getMataKuliah(String nama, ArrayList<MataKuliah> daftarMataKuliah) {
        for (MataKuliah mataKuliah : daftarMataKuliah) {
            if (mataKuliah.getNama().equals(nama)){
                return mataKuliah;
            }
        }
        return null;
    }

    // Method sorting
    private void sorting(ArrayList<MataKuliah> daftarMataKuliah) {
        for (int i = 0 ; i < daftarMataKuliah.size() ; i++) {
            for (int j = 0 ; j < daftarMataKuliah.size() ; j++) {
                // Jika nama object di indeks i lebih kecil dari nama object di indeks j, tukar posisinya
                if (daftarMataKuliah.get(i).getNama().toLowerCase().compareTo(daftarMataKuliah.get(j).getNama().toLowerCase()) < 0) {
                    MataKuliah temp = daftarMataKuliah.get(i);
                    daftarMataKuliah.set(i, daftarMataKuliah.get(j));
                    daftarMataKuliah.set(j, temp);
                }
            }
        }
    }
}
    
