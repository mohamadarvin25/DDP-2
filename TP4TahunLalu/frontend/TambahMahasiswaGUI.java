package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class TambahMahasiswaGUI{
    
    // Attributes
    private JPanel addMahasiswaPanel = new JPanel();
    private JLabel labelNama = new JLabel("Nama:");
    private JLabel labelNPM = new JLabel("NPM:");
    private JTextField textNama = new JTextField();
    private JTextField textNPM = new JTextField();
    private JButton buttonTambah = new JButton("Tambahkan");
    private JButton buttonKembali = new JButton("Kembali");

    public TambahMahasiswaGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Tambah Mahasiswa");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        
        // Set alignment serta warna dari label 
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(149,149,149));
        labelNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNama.setForeground(new Color(209,209,209));
        labelNPM.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNPM.setForeground(new Color(209,209,209));

        // Set alignment dan size dari text field
        textNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        textNama.setMaximumSize(new Dimension(175,25));
        textNPM.setAlignmentX(Component.CENTER_ALIGNMENT);
        textNPM.setMaximumSize(new Dimension(175,25));

        // Set alignment, warna, serta font dari button
        buttonTambah.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonTambah.setBackground(new Color(30,30,30));
        buttonTambah.setForeground(new Color(209,209,209));
        buttonTambah.setFont(SistemAkademikGUI.fontGeneral);
        // Set fungsi ketika button ditekan
        buttonTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Jika ada text field yang kosong, keluarkan dialog
                if (textNama.getText().equals("") || textNPM.getText().equals("")) {
                    JOptionPane.showMessageDialog(addMahasiswaPanel, "Mohon isi seluruh Field");
                    return;
                }
                // Ambil NPM dari text field
                String NPM = textNPM.getText();
                // Konvert NPM ke bentuk long
                long NPMLong = Long.valueOf(NPM); 
                // Jika NPM yang ingin di add sudah terdaftar, keluarkan dialog
                if (getMahasiswa(NPMLong, daftarMahasiswa) != null) {
                    JOptionPane.showMessageDialog(addMahasiswaPanel, String.format("NPM %s sudah pernah ditambahkan sebelumnya", NPM));
                }
                // Selain itu, lakukan add mahasiswa
                else {
                    // Ambil nama dari text field
                    String nama = textNama.getText();
                    // Add mahasiswa
                    daftarMahasiswa.add(new Mahasiswa(nama, NPMLong));
                    // Keluarkan dialog
                    JOptionPane.showMessageDialog(addMahasiswaPanel, String.format("Mahasiswa %s-%s berhasil ditambahkan", NPM, nama));
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
                // Lakukan sorting daftarMahasiswa
                sorting(daftarMahasiswa);               
                // Buat object HomeGUI baru
                new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Set visibility dari addMahasiswaPanel menjadi false
                addMahasiswaPanel.setVisible(false);
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

        // Set layout dari addMahasiswaPanel
        addMahasiswaPanel.setLayout(new BoxLayout(addMahasiswaPanel, BoxLayout.Y_AXIS));
        // Set background color dari addMahasiswaPanel
        addMahasiswaPanel.setBackground(new Color(30,30,30));
        // Tambah label, text field, button, serta space kosong diantaranya pada addMahasiswaPanel
        addMahasiswaPanel.add(titleLabel);
        addMahasiswaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMahasiswaPanel.add(labelNama);
        addMahasiswaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMahasiswaPanel.add(textNama);
        addMahasiswaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMahasiswaPanel.add(labelNPM);
        addMahasiswaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMahasiswaPanel.add(textNPM);
        addMahasiswaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMahasiswaPanel.add(buttonTambah);
        addMahasiswaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addMahasiswaPanel.add(buttonKembali);

        // Tambah addMahasiswaPanel ke frame
        frame.add(addMahasiswaPanel);
    }

    // Method getMahasiswa
    private Mahasiswa getMahasiswa(long npm, ArrayList<Mahasiswa> daftarMahasiswa) {
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa.getNpm() == npm){
                return mahasiswa;
            }
        }
        return null;
    }

    // Method sorting
    private void sorting(ArrayList<Mahasiswa> daftarMahasiswa) {
        for (int i = 0 ; i < daftarMahasiswa.size() ; i++) {
            for (int j = 0 ;j < daftarMahasiswa.size() ; j++) {
                // Jika Npm object di indeks i lebih kecil dari Npm object di indeks j, tukar posisinya
                if (Long.valueOf(daftarMahasiswa.get(i).getNpm()).compareTo(Long.valueOf(daftarMahasiswa.get(j).getNpm())) < 0) {
                    Mahasiswa temp = daftarMahasiswa.get(i);
                    daftarMahasiswa.set(i, daftarMahasiswa.get(j));
                    daftarMahasiswa.set(j, temp);
                }
            }
        }
    }
}

