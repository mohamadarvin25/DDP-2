import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

public class CurrencyConvertionFrame extends JFrame{
    JLabel labelTitle, labelFrom, labelTo, labelResult;
    JTextField fieldFrom, fieldTo; //hapus
    JButton convertButton, exitButton;
    JComboBox<String> typeCurrencyFrom, typeCurrencyTo; // hapus
    JPanel panel1, panel2, panel3;
    String[] currency = {"IDR", "Euro", "US Dollar"};
    HashMap<String, Integer> kurs = new HashMap<String, Integer>();

    public CurrencyConvertionFrame(){
        kurs.put("IDR", 1);
        kurs.put("Euro", 15000);
        kurs.put("US Dollar", 14000);

        // TO DO: Menentukan layout yang ingin digunakan 
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // hapus
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setTitle("Currency Converter");

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        labelTitle = new JLabel();
        labelTitle.setText("Welcome to Currency Converter");

        // TO DO: membuat dropdown menu
        typeCurrencyFrom = new JComboBox<String>(currency);
        typeCurrencyTo = new JComboBox<String>(currency);
        typeCurrencyTo.setSelectedItem(currency[1]);

        labelFrom = new JLabel("From");
        labelTo = new JLabel("To");
        labelResult = new JLabel("Result:");
        
        // hapus
        fieldFrom = new JTextField(20);
        fieldTo = new JTextField(20);
        fieldTo.setEditable(false);

        convertButton = new JButton("Convert");
        exitButton = new JButton("Exit");
        
        setVisible(true);

        // TO DO: masukkan widget ke panel yang tepat
        panel1.add(labelFrom);
        panel1.add(typeCurrencyFrom);
        panel1.add(fieldFrom);

        panel2.add(labelTo);
        panel2.add(typeCurrencyTo);
        panel2.add(fieldTo);

        panel3.add(convertButton);
        panel3.add(exitButton);

        add(labelTitle);
        add(panel1);
        add(panel2);
        add(panel3);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // TO DO
                fieldTo.setText(convertCurrency(fieldFrom.getText(), (String) typeCurrencyFrom.getSelectedItem(), (String) typeCurrencyTo.getSelectedItem()));
            }
        });

        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // TO DO
                System.exit(0);             
            }
        });
    }

    public String convertCurrency(String originalValue, String tipeCurrencyFrom, String tipeCurrencyTo){
        double value = Double.valueOf(originalValue);
        double fromValue = value * kurs.get(tipeCurrencyFrom);
        double convertedValue = fromValue / kurs.get(tipeCurrencyTo);
        return String.format("%.2f", convertedValue);
    }
    
}
