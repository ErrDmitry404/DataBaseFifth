package lab_5.model.dao;


import lab_5.DatabaseConnector;
import lab_5.model.entity.Monitor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class MonitorDAO implements GeneralDAO<Monitor> {


    protected final SessionFactory sessionFactory = DatabaseConnector.getSessionFactory();

    @Override
    public List<Monitor> findAll() {
        List<Monitor> monitors = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            monitors = session.createQuery("from Monitor").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monitors;
    }

    @Override
    public Monitor findOne(Integer id) {
        Monitor monitor = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            monitor = session.get(Monitor.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monitor;
    }

    @Override
    public void create(Monitor monitor) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(monitor);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Monitor monitor) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(monitor);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Monitor monitor = session.get(Monitor.class, id);
            if (monitor != null) {
                session.delete(monitor);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
