package pl.marko.apka;

import com.toedter.calendar.JDateChooser;
import pl.marko.db.BudynekDAO;
import pl.marko.model.Budynek;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class Apka extends JFrame {
    private JPanel okienko;
    private JButton b1Dalej;
    private JButton button2;
    private JTextField textField1;
    private JSpinner spinner1;
    private JDateChooser datePicker;  // Zamiana na JDateChooser

    public Apka() {
        setTitle("Zalaczniki");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Panel główny
        okienko = new JPanel();
        okienko.setLayout(new GridLayout(3, 2, 10, 10));

        // Pole tekstowe dla adresu
        textField1 = new JTextField(20);
        okienko.add(new JLabel("Adres budynku:"));
        okienko.add(textField1);

        // DatePicker (kalendarz)
        datePicker = new JDateChooser();
        datePicker.setDateFormatString("yyyy-MM-dd");
        datePicker.setDate(new Date()); // Domyślnie dzisiejsza data
        okienko.add(new JLabel("Data pracy:"));
        okienko.add(datePicker);


        JPanel panelPrzyciski = new JPanel();
        panelPrzyciski.add(b1Dalej);
        panelPrzyciski.add(button2);

        add(okienko, BorderLayout.CENTER);
        add(panelPrzyciski, BorderLayout.SOUTH);

        // Podpowiedzi adresów
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { suggestAdres(); }
            @Override
            public void removeUpdate(DocumentEvent e) { suggestAdres(); }
            @Override
            public void changedUpdate(DocumentEvent e) { suggestAdres(); }

            private void suggestAdres() {
                List<String> adresy = BudynekDAO.getAllAdresy();
                String wpisanyTekst = textField1.getText();
                for (String adres : adresy) {
                    if (adres.startsWith(wpisanyTekst)) {
                        textField1.setText(adres); // Można dodać listę rozwijaną
                        break;
                    }
                }
            }
        });

        // Obsługa przycisku "Dalej"
        b1Dalej.addActionListener(e -> {
            String adres = textField1.getText();
            Date data = datePicker.getDate();
            if (adres.isEmpty() || data == null) {
                JOptionPane.showMessageDialog(this, "Wpisz adres i wybierz datę!", "Błąd", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Budynek budynek = new Budynek();
            budynek.setAdres(adres);
            BudynekDAO.addBudynek(budynek);

            JOptionPane.showMessageDialog(this, "Adres zapisany!", "Sukces", JOptionPane.INFORMATION_MESSAGE);

            new PracaOkno();
            dispose();

        });

        setVisible(true);
    }


}
