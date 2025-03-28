package pl.marko;

import org.hibernate.Session;
import pl.marko.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Połączenie OK ✅");
        } catch (Exception e) {
            System.err.println("Błąd połączenia ❌: " + e.getMessage());
        }
    }
}
