package pl.marko.db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.marko.model.Praca;
import pl.marko.util.HibernateUtil;

import java.util.List;

public class PracaDAO {



    public static void addPraca(Praca praca) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(praca);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Praca> getAllPrace() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Praca", Praca.class).list();
        }
    }
}
