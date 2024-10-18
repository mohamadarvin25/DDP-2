
import java.util.HashMap;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class CurrencyConversionFrame extends JFrame {
    JLabel labelTitle, labelFrom, labelTo;
    JButton convertButton, exitButton;
    String[] currency = { "Rupiah", "Euro", "US Dollar" };
    HashMap<String, Integer> kurs = new HashMap<String, Integer>();
    private JTextField TextField1;
    private JTextField TextField2;
    private JComboBox<String> combo1;
    private JComboBox<String> combo2;

    public CurrencyConversionFrame() {
        kurs.put("Rupiah", 1);
        kurs.put("Euro", 15000);
        kurs.put("US Dollar", 14000);

        // TO DO: Menentukan layout dan size yang ingin digunakan
        this.setResizable(true); // makes the frame resizeable
        this.setSize(500, 500); // sets the x-dimension and y-dimension of frame
        this.setLayout(new BorderLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Currency Converter");

        labelTitle = new JLabel();
        labelTitle.setText("Welcome to Currency Converter");
        labelTitle.setHorizontalAlignment(JLabel.CENTER);

        // dropdown menu

        labelFrom = new JLabel("From");
        labelTo = new JLabel("To");
        combo1 = new JComboBox<String>(currency);
        TextField1 = new JTextField(16);
        combo2 = new JComboBox<String>(currency);
        TextField2 = new JTextField(16);
        TextField2.setEditable(false);

        // TO DO: Membuat textfield

        convertButton = new JButton("Convert");
        exitButton = new JButton("Exit");

        // TO DO: Masukkan widget ke panel yang tepat
        JPanel subpanel1 = new JPanel();
        JPanel subpanel2 = new JPanel();

        // Masukkan panel ke dalam frame
        subpanel1.add(labelTitle);
        subpanel2.add(labelFrom);
        subpanel2.add(combo1);
        subpanel2.add(TextField1);
        subpanel2.add(labelTo);
        subpanel2.add(combo2);
        subpanel2.add(TextField2);

        // add(convertButton)
        subpanel2.add(convertButton);

        // add(exitButton);
        subpanel2.add(exitButton);

        add(subpanel1, BorderLayout.NORTH);
        add(subpanel2, BorderLayout.CENTER);

        setVisible(true);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // implementasikan pemanggilan method ConvertCurrency
                TextField2.setText(ConvertCurrency(TextField1.getText(), combo1.getSelectedItem().toString(),
                        combo2.getSelectedItem().toString()));

            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // menghentikan eksekusi program
                dispose();
            }
        });
    }

    // Method converter
    public String ConvertCurrency(String originalValue, String tipeCurrencyFrom, String tipeCurrencyTo) {
        double value = Double.valueOf(originalValue);
        double fromValue = value * kurs.get(tipeCurrencyFrom);
        double convertedValue = fromValue / kurs.get(tipeCurrencyTo);
        return String.format("%.2f", convertedValue);
    }

}
