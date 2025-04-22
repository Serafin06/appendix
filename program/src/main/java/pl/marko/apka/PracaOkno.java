package pl.marko.apka;

import javax.swing.*;
import java.awt.*;

public class PracaOkno extends JFrame{
    private JButton dalejButton;
    private JButton wsteczButton;
    private JTextArea textArea1;
    private JPanel prOk;

    public PracaOkno() {
        setTitle("Dodawanie pracy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setLayout(new BorderLayout());

        prOk = new JPanel();
        prOk.setLayout(new BorderLayout());

        // Pole do wpisania wykonanej pracy
        textArea1 = new JTextArea(5, 30);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea1);

        prOk.add(new JLabel("Wpisz wykonaną pracę:"), BorderLayout.NORTH);
        prOk.add(scrollPane, BorderLayout.CENTER);

        prOk.add(wsteczButton);
        prOk.add(dalejButton);


        wsteczButton.addActionListener(e -> {
            new Apka();  // Powrót do pierwszego okna
            dispose();   // Zamykamy obecne okno
        });

        dalejButton.addActionListener(e -> {
            // Możesz dodać logikę przejścia do kolejnego okna
            JOptionPane.showMessageDialog(this, "Następne okno w przygotowaniu!");
        });


        setVisible(true);
    }
}
