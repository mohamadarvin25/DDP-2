package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class RingkasanMahasiswaGUI {
    
    // Attributes
    private JPanel ringkasanMhsPanel = new JPanel();
    private JLabel labelNPM = new JLabel("Pilih NPM");
    private JComboBox<String> boxNPM = new JComboBox<String>();
    private JButton buttonLihat = new JButton("Lihat");
    private JButton buttonKembali = new JButton("Kembali");

    public RingkasanMahasiswaGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Ringkasan Mahasiswa");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        
        // Set alignment serta warna dari label 
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(149,149,149));  
        labelNPM.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNPM.setForeground(new Color(209,209,209));
        
        // Jika daftarMahasiswa tidak kosong, buat array yang berisi npm mahasiswa
        if (daftarMahasiswa.size() > 0) {
            String[] npmMahasiswa = new String[daftarMahasiswa.size()];
            for (int i = 0 ; i < daftarMahasiswa.size() ; i++) {
                npmMahasiswa[i] = String.valueOf(daftarMahasiswa.get(i).getNpm());
            }
            boxNPM = new JComboBox<String>(npmMahasiswa);  
            boxNPM.setSelectedIndex(0);          
        }
        // Set alignment dan size dari combo box
        boxNPM.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxNPM.setMaximumSize(new Dimension(150,20));
        
        // Set alignment, warna, serta font dari button
        buttonLihat.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonLihat.setBackground(new Color(30,30,30));
        buttonLihat.setForeground(new Color(209,209,209));
        buttonLihat.setFont(SistemAkademikGUI.fontGeneral);
        // Set fungsi ketika button ditekan
        buttonLihat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Jika field kosong, buat dialog dan keluar dari method
                if (boxNPM.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(ringkasanMhsPanel, "Mohon isi seluruh field");
                    return;
                }
                // Selain itu, buat objek DetailRingkasanMahasiswaGUI
                String npm = String.valueOf(boxNPM.getSelectedItem());
                long NPMLong = Long.valueOf(npm);
                Mahasiswa mahasiswa = getMahasiswa(NPMLong, daftarMahasiswa);
                mahasiswa.cekIRS();
                new DetailRingkasanMahasiswaGUI(frame, mahasiswa, daftarMahasiswa, daftarMataKuliah);
                ringkasanMhsPanel.setVisible(false);
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
                // Set visibility dari ringkasanMhsPanel menjadi false
                ringkasanMhsPanel.setVisible(false);
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

        // Set layout dari ringkasanMhsPanel
        ringkasanMhsPanel.setLayout(new BoxLayout(ringkasanMhsPanel, BoxLayout.Y_AXIS));
        // Set background color dari ringkasanMhsPanel
        ringkasanMhsPanel.setBackground(new Color(30,30,30));
        // Tambah label, combo box, button, serta space kosong diantaranya pada ringkasanMhsPanel
        ringkasanMhsPanel.add(titleLabel);
        ringkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        ringkasanMhsPanel.add(labelNPM);
        ringkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        ringkasanMhsPanel.add(boxNPM);
        ringkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        ringkasanMhsPanel.add(buttonLihat);
        ringkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        ringkasanMhsPanel.add(buttonKembali);

        // Tambah ringkasanMhsPanel ke frame
        frame.add(ringkasanMhsPanel);
    }


    private Mahasiswa getMahasiswa(long npm, ArrayList<Mahasiswa> daftarMahasiswa) {

        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa.getNpm() == npm){
                return mahasiswa;
            }
        }
        return null;
    }
}
