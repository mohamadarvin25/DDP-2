package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class HomeGUI {
    
    // Attributes
    private JPanel homePanel = new JPanel();
    private JButton a = new JButton("Tambah Mahasiswa");
    private JButton b = new JButton("Tambah Mata Kuliah");
    private JButton c = new JButton("Tambah IRS");
    private JButton d = new JButton("Hapus IRS");
    private JButton e = new JButton("Lihat Ringkasan Mahasiswa");
    private JButton f = new JButton("Lihat Ringkasan Mata Kuliah");

    public HomeGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Selamat datang di Sistem Akademik");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        
        // Set alignment serta warna dari label dan button
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(149,149,149));

        // Set alignment, warna, serta font dari tiap button serta handle perubahan menu ketika button diclick
        a.setAlignmentX(Component.CENTER_ALIGNMENT);
        a.setBackground(new Color(30,30,30));
        a.setForeground(new Color(209,209,209));
        a.setFont(SistemAkademikGUI.fontGeneral);
        a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Ketika tombol diclick akan membuat object TambahMahasiswaGUI
                new TambahMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Set visibility dari homePanel menjadi false
                homePanel.setVisible(false);
            }
        });
        a.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                a.setBackground(new Color(59,80,250));
                a.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                a.setBackground(new Color(30,30,30));
                a.setForeground(new Color(209,209,209));
            }
        });

        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setBackground(new Color(30,30,30));
        b.setForeground(new Color(209,209,209));
        b.setFont(SistemAkademikGUI.fontGeneral);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Ketika tombol diclick akan membuat object TambahMataKuliahGUI
                new TambahMataKuliahGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Set visibility dari homePanel menjadi false
                homePanel.setVisible(false);
            }
        });
        b.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                b.setBackground(new Color(59,80,250));
                b.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                b.setBackground(new Color(30,30,30));
                b.setForeground(new Color(209,209,209));
            }
        });

        c.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.setBackground(new Color(30,30,30));
        c.setForeground(new Color(209,209,209));
        c.setFont(SistemAkademikGUI.fontGeneral);
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Ketika tombol diclick akan membuat object TambahIRSGUI
                new TambahIRSGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Set visibility dari homePanel menjadi false
                homePanel.setVisible(false);
            }
        });
        c.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                c.setBackground(new Color(59,80,250));
                c.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                c.setBackground(new Color(30,30,30));
                c.setForeground(new Color(209,209,209));
            }
        });

        d.setAlignmentX(Component.CENTER_ALIGNMENT);
        d.setBackground(new Color(30,30,30));
        d.setForeground(new Color(209,209,209));
        d.setFont(SistemAkademikGUI.fontGeneral);
        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Ketika tombol diclick akan membuat object HapusIRSGUI
                new HapusIRSGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Set visibility dari homePanel menjadi false
                homePanel.setVisible(false);
            }
        });
        d.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                d.setBackground(new Color(59,80,250));
                d.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                d.setBackground(new Color(30,30,30));
                d.setForeground(new Color(209,209,209));
            }
        });

        e.setAlignmentX(Component.CENTER_ALIGNMENT);
        e.setBackground(new Color(30,30,30));
        e.setForeground(new Color(209,209,209));
        e.setFont(SistemAkademikGUI.fontGeneral);
        e.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Ketika tombol diclick akan membuat object RingkasanMahasiswaGUI
                new RingkasanMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Set visibility dari homePanel menjadi false
                homePanel.setVisible(false);
            }
        });
        e.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                e.setBackground(new Color(59,80,250));
                e.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                e.setBackground(new Color(30,30,30));
                e.setForeground(new Color(209,209,209));
            }
        });

        f.setAlignmentX(Component.CENTER_ALIGNMENT);
        f.setBackground(new Color(30,30,30));
        f.setForeground(new Color(209,209,209));
        f.setFont(SistemAkademikGUI.fontGeneral);
        f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Ketika tombol diclick akan membuat object RingkasanMataKuliahGUI
                new RingkasanMataKuliahGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Set visibility dari homePanel menjadi false
                homePanel.setVisible(false);
            }
        });
        f.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                f.setBackground(new Color(59,80,250));
                f.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                f.setBackground(new Color(30,30,30));
                f.setForeground(new Color(209,209,209));
            }
        });

        // Set layout dari homePanel menjadi BoxLayout
        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
        // Set background color dari homePanel
        homePanel.setBackground(new Color(30,30,30));
        // Add label dan button beserta jarak diantaranya ke homePanel
        homePanel.add(titleLabel);
        homePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        homePanel.add(a);
        homePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        homePanel.add(b);
        homePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        homePanel.add(c);
        homePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        homePanel.add(d);
        homePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        homePanel.add(e);
        homePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        homePanel.add(f);
        homePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // Tambah homePanel ke frame
        frame.add(homePanel);
    }
}
