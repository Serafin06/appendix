package pl.marko.apka;

import pl.marko.db.PracaDAO;
import pl.marko.model.Budynek;
import pl.marko.model.Praca;
import javax.swing.*;
import java.util.Date;


public class PracaOkno extends JFrame{
    private JButton dalejButton;
    private JButton wsteczButton;
    private JTextArea textArea1;
    private JPanel prOk;
    private JButton zapiszButton;
    private JSpinner spinnerGodz;
    private JComboBox comboVat;
    private JComboBox comboDojazd;

    private Budynek budynek;
    private Date data;

    public PracaOkno(Budynek budynek, Date data) {
        this.budynek = budynek;
        this.data = data;

        setContentPane(prOk);
        setTitle("Dodawanie pracy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        comboVat.addItem(8);
        comboVat.addItem(23);

        comboDojazd.addItem("Tak");
        comboDojazd.addItem("Nie");

        comboVat.setSelectedItem(8);
        comboDojazd.setSelectedItem("Tak");




        zapiszButton.addActionListener(e -> {
            String opis = textArea1.getText();
            int godziny = (int) spinnerGodz.getValue();
            boolean dojazd = comboDojazd.getSelectedItem().equals("Tak");
            int vat = (int) comboVat.getSelectedItem();

            Praca praca = new Praca();
            praca.setBudynek(budynek);
            praca.setDataWykonania(data);
            praca.setPraca(opis);
            praca.setIloscGodzin(godziny);
            praca.setDojazd(dojazd);
            praca.setVat(vat);

            try {
                PracaDAO.addPraca(praca);
                JOptionPane.showMessageDialog(null, "Praca zapisana!");

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Błąd przy zapisie pracy");
            }
        });
        wsteczButton.addActionListener(e -> {
            this.dispose();
            new Apka();
        });

        dalejButton.addActionListener(e -> {


            this.dispose();

        });



        setVisible(true);
    }
}
