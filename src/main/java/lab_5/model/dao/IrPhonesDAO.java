package lab_5.model.dao;


import lab_5.DatabaseConnector;
import lab_5.model.entity.IrPhones;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class IrPhonesDAO implements GeneralDAO<IrPhones> {


    protected final SessionFactory sessionFactory = DatabaseConnector.getSessionFactory();

    @Override
    public List<IrPhones> findAll() {
        List<IrPhones> phones = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            phones = session.createQuery("from IrPhones").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phones;
    }

    @Override
    public IrPhones findOne(Integer id) {
        IrPhones phones = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            phones = session.get(IrPhones.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phones;
    }

    @Override
    public void create(IrPhones phones) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(phones);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, IrPhones phones) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(phones);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            IrPhones phones = session.get(IrPhones.class, id);
            if (phones != null) {
                session.delete(phones);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
