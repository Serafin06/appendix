package pl.marko.db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.marko.model.PracaMaterial;
import pl.marko.util.HibernateUtil;

import java.util.List;

public class PracaMaterialDAO {

    public void addPracaMaterial(PracaMaterial pracaMaterial) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(pracaMaterial);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<PracaMaterial> getAllPracaMaterialy() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from PracaMaterial", PracaMaterial.class).list();
        }
    }

    // Inne metody CRUD
}