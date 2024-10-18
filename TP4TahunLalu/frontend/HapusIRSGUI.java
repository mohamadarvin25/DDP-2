package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class HapusIRSGUI {

    // Attributes
    private JPanel removeIRSPanel = new JPanel();
    private JLabel labelNPM = new JLabel("Pilih NPM");
    private JLabel labelNama = new JLabel("Pilih Nama Matkul");
    private JComboBox<String> boxNPM = new JComboBox<String>();
    private JComboBox<String> boxNama = new JComboBox<String>();
    private JButton buttonHapus = new JButton("Hapus");
    private JButton buttonKembali = new JButton("Kembali");
    
    public HapusIRSGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Hapus IRS");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        
        // Set alignment serta warna dari label 
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(149,149,149));
        labelNPM.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNPM.setForeground(new Color(209,209,209));
        labelNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNama.setForeground(new Color(209,209,209));

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
        
        // Jika daftarMataKuliah tidak kosong, buat array yang berisi nama mahasiswa
        if  (daftarMataKuliah.size() > 0) {
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
        buttonHapus.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonHapus.setBackground(new Color(30,30,30));
        buttonHapus.setForeground(new Color(209,209,209));
        buttonHapus.setFont(SistemAkademikGUI.fontGeneral);
        // Set fungsi ketika button ditekan
        buttonHapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Jika ada text field yang kosong, keluarkan dialog
                if (boxNama.getSelectedItem() == null || boxNPM.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(removeIRSPanel, "Mohon isi seluruh Field");
                    return;
                }
                // Ambil npm dari combo box, ubah kebentuk long
                String npm = String.valueOf(boxNPM.getSelectedItem());
                long NPMLong = Long.valueOf(npm);
                // Ambil nama matkul dari combo box
                String nama = String.valueOf(boxNama.getSelectedItem());
                // Ambil object Mahasiswa menggunakan method getMahasiswa
                Mahasiswa mahasiswa = getMahasiswa(NPMLong, daftarMahasiswa);
                // Ambil object MataKuliah menggunakan method getMataKuliah
                MataKuliah mataKuliah = getMataKuliah(nama, daftarMataKuliah);
                // Lakukan dropMatkul pada mahasiswa dan keluarkan dialog sesuai return value method dropMatkul
                JOptionPane.showMessageDialog(removeIRSPanel, mahasiswa.dropMatkul(mataKuliah));
            }
        });
        buttonHapus.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                buttonHapus.setBackground(new Color(59,80,250));
                buttonHapus.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                buttonHapus.setBackground(new Color(30,30,30));
                buttonHapus.setForeground(new Color(209,209,209));
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
                // Set visibility dari removeIRSPanel menjadi false
                removeIRSPanel.setVisible(false);
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
        
        // Set layout dari removeIRSPanel
        removeIRSPanel.setLayout(new BoxLayout(removeIRSPanel, BoxLayout.Y_AXIS));
        // Set background color dari removeIRSPanel
        removeIRSPanel.setBackground(new Color(30,30,30));
        // Tambah label, combo box, button, serta space kosong diantaranya pada removeIRSPanel
        removeIRSPanel.add(titleLabel);
        removeIRSPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        removeIRSPanel.add(labelNPM);
        removeIRSPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        removeIRSPanel.add(boxNPM);
        removeIRSPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        removeIRSPanel.add(labelNama);
        removeIRSPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        removeIRSPanel.add(boxNama);
        removeIRSPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        removeIRSPanel.add(buttonHapus);
        removeIRSPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        removeIRSPanel.add(buttonKembali);

        // Tambah removeIRSPanel ke frame
        frame.add(removeIRSPanel);
    }

    private MataKuliah getMataKuliah(String nama, ArrayList<MataKuliah> daftarMataKuliah) {

        for (MataKuliah mataKuliah : daftarMataKuliah) {
            if (mataKuliah.getNama().equals(nama)){
                return mataKuliah;
            }
        }
        return null;
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
