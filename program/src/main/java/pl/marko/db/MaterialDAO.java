package pl.marko.db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.marko.model.Material;
import pl.marko.util.HibernateUtil;

import java.util.List;

public class MaterialDAO {

    public void addMaterial(Material material) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(material);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Material> getAllMaterialy() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Material", Material.class).list();
        }
    }
}
