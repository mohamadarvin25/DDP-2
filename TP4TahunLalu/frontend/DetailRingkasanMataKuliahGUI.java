package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class DetailRingkasanMataKuliahGUI {

    // Attributes
    private JPanel detailRingkasanMatkulPanel = new JPanel();
    private JLabel labelNama;
    private JLabel labelKode;
    private JLabel labelSKS;
    private JLabel labelJmlMhs;
    private JLabel labelKapasitas;
    private JLabel labelDaftarMhs;
    private JButton buttonSelesai = new JButton("Selesai");

    public DetailRingkasanMataKuliahGUI(JFrame frame, MataKuliah mataKuliah, ArrayList<Mahasiswa> daftarMahasiswa,
            ArrayList<MataKuliah> daftarMataKuliah) {

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Detail Ringkasan Mata Kuliah");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);

        // Set alignment, warna, serta pesan dari label
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(149, 149, 149));
        labelNama = new JLabel(String.format("Nama mata kuliah: %s", mataKuliah.getNama()));
        labelNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNama.setForeground(new Color(209, 209, 209));
        labelKode = new JLabel(String.format("Kode: %s", mataKuliah.getKode()));
        labelKode.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelKode.setForeground(new Color(209, 209, 209));
        labelSKS = new JLabel(String.format("SKS: %d", mataKuliah.getSKS()));
        labelSKS.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelSKS.setForeground(new Color(209, 209, 209));
        labelJmlMhs = new JLabel(String.format("Jumlah mahasiswa: %d", mataKuliah.getJumlahMahasiswa()));
        labelJmlMhs.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelJmlMhs.setForeground(new Color(209, 209, 209));
        labelKapasitas = new JLabel(String.format("Kapasitas: %d", mataKuliah.getKapasitas()));
        labelKapasitas.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelKapasitas.setForeground(new Color(209, 209, 209));
        labelDaftarMhs = new JLabel("Daftar Mahasiswa:");
        labelDaftarMhs.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelDaftarMhs.setForeground(new Color(209, 209, 209));

        // Set alignment, warna, serta font dari button
        buttonSelesai.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonSelesai.setBackground(new Color(30, 30, 30));
        buttonSelesai.setForeground(new Color(209, 209, 209));
        buttonSelesai.setFont(SistemAkademikGUI.fontGeneral);
        // Set fungsi ketika button ditekan
        buttonSelesai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Buat object HomeGUI baru
                new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Set visibility dari detailRingkasanMatkulPanel menjadi false
                detailRingkasanMatkulPanel.setVisible(false);
            }
        });

        // Set layout dari detailRingkasanMatkulPanel
        detailRingkasanMatkulPanel.setLayout(new BoxLayout(detailRingkasanMatkulPanel, BoxLayout.Y_AXIS));
        // Set background color dari detailRingkasanMatkulPanel
        detailRingkasanMatkulPanel.setBackground(new Color(30, 30, 30));
        // Tambah label, button, serta space kosong diantaranya pada
        // detailRingkasanMatkulPanel
        detailRingkasanMatkulPanel.add(titleLabel);
        detailRingkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailRingkasanMatkulPanel.add(labelNama);
        detailRingkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailRingkasanMatkulPanel.add(labelKode);
        detailRingkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailRingkasanMatkulPanel.add(labelSKS);
        detailRingkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailRingkasanMatkulPanel.add(labelJmlMhs);
        detailRingkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailRingkasanMatkulPanel.add(labelKapasitas);
        detailRingkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        detailRingkasanMatkulPanel.add(labelDaftarMhs);
        detailRingkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // Jika jumlah mahasiswa dari matkul 0, buat label dan spacing berikut
        if (mataKuliah.getJumlahMahasiswa() == 0) {
            JLabel labelMhs = new JLabel("Belum ada mahasiswa yang mengambil mata kuliah ini.");
            labelMhs.setAlignmentX(Component.CENTER_ALIGNMENT);
            labelMhs.setForeground(new Color(59, 80, 250));
            detailRingkasanMatkulPanel.add(labelMhs);
            detailRingkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        // Selain itu, buat label dan spacing sebanyak masalah IRS yang dimiliki
        // mahasiswa lalu tambahkan ke detailRingkasanMatkulPanel
        else {
            for (int i = 0; i < mataKuliah.getJumlahMahasiswa(); i++) {
                JLabel labelMhs = new JLabel(
                        String.format("%d. %s", i + 1, mataKuliah.getDaftarMahasiswa()[i].getNama()));
                labelMhs.setAlignmentX(Component.CENTER_ALIGNMENT);
                labelMhs.setForeground(new Color(59, 80, 250));
                detailRingkasanMatkulPanel.add(labelMhs);
                detailRingkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }
        detailRingkasanMatkulPanel.add(buttonSelesai);
        detailRingkasanMatkulPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Tambah detailRingkasanMatkulPanel ke frame
        frame.add(detailRingkasanMatkulPanel);

    }
}
