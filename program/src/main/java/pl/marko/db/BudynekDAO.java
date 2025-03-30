package pl.marko.db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.marko.model.Budynek;
import pl.marko.util.HibernateUtil;

import java.util.List;

public class BudynekDAO {

    public void addBudynek(Budynek budynek) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(budynek);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Budynek> getAllBudynki() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Budynek", Budynek.class).list();
        }
    }
}
