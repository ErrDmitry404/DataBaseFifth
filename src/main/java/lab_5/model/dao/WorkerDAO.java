package lab_5.model.dao;


import lab_5.DatabaseConnector;
import lab_5.model.entity.Computer;
import lab_5.model.entity.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class WorkerDAO implements GeneralDAO<Worker> {


    protected final SessionFactory sessionFactory = DatabaseConnector.getSessionFactory();

    @Override
    public List<Worker> findAll() {
        List<Worker> workers = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            workers = session.createQuery("from Worker").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workers;
    }

    @Override
    public Worker findOne(Integer id) {
        Worker worker = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.beginTransaction();
            worker = session.get(Worker.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return worker;
    }

    @Override
    public void create(Worker worker) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(worker);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Worker worker) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(worker);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Computer computer = session.get(Computer.class, id);
            if (computer != null) {
                session.delete(computer);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
