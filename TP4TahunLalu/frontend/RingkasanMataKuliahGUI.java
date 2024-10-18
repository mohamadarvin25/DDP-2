package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class RingkasanMataKuliahGUI {

    // Attributes
    private JPanel ringkasanMatkulPanel = new JPanel();
    private JLabel labelNama = new JLabel("Pilih Nama Matkul");
    private JComboBox<String> boxNama = new JComboBox<String>();
    private JButton buttonLihat = new JButton("Lihat");
    private JButton buttonKembali = new JButton("Kembali");

    public RingkasanMataKuliahGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Ringkasan Mata Kuliah");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        
        // Set alignment serta warna dari label 
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(149,149,149));  
        labelNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNama.setForeground(new Color(209,209,209));
        
        // Jika daftarMataKuliah tidak kosong, buat array yang berisi nama matkul
        if (daftarMataKuliah.size() > 0) {
            String[] namaMatkul = new String[daftarMataKuliah.size()];
            for (int i = 0 ; i < daftarMataKuliah.size() ; i++) {
                namaMatkul[i] = String.valueOf(daftarMataKuliah.get(i).getNama());
            }
            boxNama = new JComboBox<String>(namaMatkul);  
            boxNama.setSelectedIndex(0);          
        }
        // Set alignment dan size dari combo box
        boxNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxNama.setMaximumSize(new Dimension(150,20));
        
        // Set alignment, warna, serta font dari button
        buttonLihat.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonLihat.setBackground(new Color(30,30,30));
        buttonLihat.setForeground(new Color(209,209,209));
        buttonLihat.setFont(SistemAkademikGUI.fontGeneral);
        // Set fungsi ketika button ditekan
        buttonLihat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Jika field kosong, buat dialog dan keluar dari method
                if (boxNama.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(ringkasanMatkulPanel, "Mohon isi seluruh field");
                    return;
                }
                // Selain itu, buat objek DetailRingkasanMataKuliahGUI
                String nama = String.valueOf(boxNama.getSelectedItem());
                MataKuliah matkul = getMataKuliah(nama, daftarMataKuliah);
                new DetailRingkasanMataKuliahGUI(frame, matkul, daftarMahasiswa, daftarMataKuliah);
                ringkasanMatkulPanel.setVisible(false);
            }
        });
        buttonLihat.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                buttonLihat.setBackground(new Color(59,80,250));
                buttonLihat.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                buttonLihat.setBackground(new Color(30,30,30));
                buttonLihat.setForeground(new Color(209,209,209));
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
                // Buat object HomeGUI baru
                new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Set visibility dari ringkasanMatkulPanel menjadi false
                ringkasanMatkulPanel.setVisible(false);
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

        // Set layout dari ringkasanMatkulPanel
        ringkasanMatkulPanel.setLayout(new BoxLayout(ringkasanMatkulPanel, BoxLayout.Y_AXIS));
        // Set background color dari ringkasanMatkulPanel
        ringkasanMatkulPanel.setBackground(new Color(30,30,30));
        // Tambah label, combo box, button, serta space kosong diantaranya pada ringkasanMatkulPanel
        ringkasanMatkulPanel.add(titleLabel);
        ringkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        ringkasanMatkulPanel.add(labelNama);
        ringkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        ringkasanMatkulPanel.add(boxNama);
        ringkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        ringkasanMatkulPanel.add(buttonLihat);
        ringkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        ringkasanMatkulPanel.add(buttonKembali);

        // Tambah ringkasanMatkulPanel ke frame
        frame.add(ringkasanMatkulPanel);
    }

    private MataKuliah getMataKuliah(String nama, ArrayList<MataKuliah> daftarMataKuliah) {

        for (MataKuliah mataKuliah : daftarMataKuliah) {
            if (mataKuliah.getNama().equals(nama)){
                return mataKuliah;
            }
        }
        return null;
    }
}
