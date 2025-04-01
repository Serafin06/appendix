package pl.marko.apka;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Apka extends JFrame {
    private JPanel okienko;
    private JButton button1;
    private JButton button2;
    private JSpinner spinner1;
    private JTextField textField1;

    public Apka() {
        JFrame apka = new JFrame("Zalaczniki");
        apka.setContentPane(okienko);
        apka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        apka.setSize(400, 300);
        apka.setVisible(true);

        button1.addActionListener(e -> {
            String text = textField1.getText();
            int value = (int) spinner1.getValue();
            JOptionPane.showMessageDialog(okienko, "Wpisano: " + text + ", wartość: " + value);
        });
        button2.addActionListener(e -> {
            JOptionPane.showMessageDialog(okienko, "Przycisk 2 kliknięty");
        });
    }

}
