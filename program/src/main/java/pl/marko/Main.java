package pl.marko;

import org.hibernate.Session;
import pl.marko.apka.Apka;
import pl.marko.util.HibernateUtil;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Apka();
            }
        });


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Połączenie OK ✅");
        } catch (Exception e) {
            System.err.println("Błąd połączenia ❌: " + e.getMessage());
        }
    }
}
