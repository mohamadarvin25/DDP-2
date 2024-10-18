package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class DetailRingkasanMahasiswaGUI {
    
    // Attributes
    private JPanel detailRingkasanMhsPanel = new JPanel();
    private JLabel labelNama;
    private JLabel labelNPM;
    private JLabel labelJurusan;
    private JLabel labelDaftarMatkul;
    private JLabel labelTotalSKS;
    private JLabel labelCekIRS;
    private JButton buttonSelesai = new JButton("Selesai");

    public DetailRingkasanMahasiswaGUI(JFrame frame, Mahasiswa mahasiswa, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Detail Ringkasan Mahasiswa");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        
        // Set alignment, warna, serta pesan dari label
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(149,149,149));
        labelNama = new JLabel(String.format("Nama: %s", mahasiswa.getNama()));  
        labelNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNama.setForeground(new Color(209,209,209));
        labelNPM = new JLabel(String.format("NPM: %d", mahasiswa.getNpm()));
        labelNPM.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNPM.setForeground(new Color(209,209,209));
        labelJurusan = new JLabel(String.format("Jurusan: %s", mahasiswa.getJurusan()));
        labelJurusan.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelJurusan.setForeground(new Color(209,209,209));
        labelDaftarMatkul = new JLabel("Daftar Mata Kuliah:");
        labelDaftarMatkul.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelDaftarMatkul.setForeground(new Color(209,209,209));
        labelTotalSKS = new JLabel(String.format("Total SKS: %d", mahasiswa.getTotalSKS()));
        labelTotalSKS.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelTotalSKS.setForeground(new Color(209,209,209));
        labelCekIRS = new JLabel("Hasil Pengecekan IRS:");
        labelCekIRS.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelCekIRS.setForeground(new Color(209,209,209));

        // Set alignment, warna, serta font dari button
        buttonSelesai.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonSelesai.setBackground(new Color(30,30,30));
        buttonSelesai.setForeground(new Color(209,209,209));
        buttonSelesai.setFont(SistemAkademikGUI.fontGeneral);
        // Set fungsi ketika button ditekan
        buttonSelesai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Buat object HomeGUI baru
                new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Set visibility dari detailRingkasanMhsPanel menjadi false
                detailRingkasanMhsPanel.setVisible(false);
            }
        });
        buttonSelesai.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                buttonSelesai.setBackground(new Color(59,80,250));
                buttonSelesai.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                buttonSelesai.setBackground(new Color(30,30,30));
                buttonSelesai.setForeground(new Color(209,209,209));
            }
        });

        // Set layout dari detailRingkasanMhsPanel
        detailRingkasanMhsPanel.setLayout(new BoxLayout(detailRingkasanMhsPanel, BoxLayout.Y_AXIS));
        // Set background color dari detailRingkasanMhsPanel
        detailRingkasanMhsPanel.setBackground(new Color(30,30,30));
        // Tambah label, button, serta space kosong diantaranya pada detailRingkasanMhsPanel
        detailRingkasanMhsPanel.add(titleLabel);
        detailRingkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailRingkasanMhsPanel.add(labelNama);
        detailRingkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailRingkasanMhsPanel.add(labelNPM);
        detailRingkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailRingkasanMhsPanel.add(labelJurusan);
        detailRingkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailRingkasanMhsPanel.add(labelDaftarMatkul);
        detailRingkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // Jika banyak matkul dari mahasiswa 0, buat label dan spacing berikut
        if (mahasiswa.getBanyakMatkul() == 0) {
            JLabel labelMatkul = new JLabel("Belum ada mata kuliah yang diambil.");
            labelMatkul.setAlignmentX(Component.CENTER_ALIGNMENT);
            labelMatkul.setForeground(new Color(59,80,250));
            detailRingkasanMhsPanel.add(labelMatkul);
            detailRingkasanMhsPanel.add(Box.createRigidArea(new Dimension(0,10)));
        }
        // Selain itu, buat label dan spacing sebanyak matkul yang dimiliki mahasiswa lalu tambahkan ke detailRingkasanMhsPanel
        else {
            for (int i = 0 ; i < mahasiswa.getBanyakMatkul() ; i++) {
                JLabel labelMatkul = new JLabel(String.format("%d. %s", i+1, mahasiswa.getMataKuliah()[i].getNama()));
                labelMatkul.setAlignmentX(Component.CENTER_ALIGNMENT);
                labelMatkul.setForeground(new Color(59,80,250));
                detailRingkasanMhsPanel.add(labelMatkul);
                detailRingkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }           
        }
        detailRingkasanMhsPanel.add(labelTotalSKS);
        detailRingkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailRingkasanMhsPanel.add(labelCekIRS);
        detailRingkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // Jika banyak masalah IRS dari mahasiswa 0, buat label dan spacing berikut
        if (mahasiswa.getBanyakMasalahIRS() == 0) {
            JLabel labelIRS = new JLabel("IRS tidak bermasalah.");
            labelIRS.setAlignmentX(Component.CENTER_ALIGNMENT);
            labelIRS.setForeground(new Color(59,80,250));
            detailRingkasanMhsPanel.add(labelIRS);
            detailRingkasanMhsPanel.add(Box.createRigidArea(new Dimension(0,10)));
        }
        // Selain itu, buat label dan spacing sebanyak masalah IRS yang dimiliki mahasiswa lalu tambahkan ke detailRingkasanMhsPanel
        else {
            for (int i = 0 ; i < mahasiswa.getBanyakMasalahIRS() ; i++) {
                JLabel labelIRS = new JLabel(String.format("%d. %s", i+1, mahasiswa.getMasalahIRS()[i]));
                labelIRS.setAlignmentX(Component.CENTER_ALIGNMENT);
                labelIRS.setForeground(new Color(59,80,250));
                detailRingkasanMhsPanel.add(labelIRS);
                detailRingkasanMhsPanel.add(Box.createRigidArea(new Dimension(0,10)));
            }           
        }
        detailRingkasanMhsPanel.add(buttonSelesai);
        detailRingkasanMhsPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Tambah detailRingkasanMhsPanel ke frame
        frame.add(detailRingkasanMhsPanel);       
    }
}
