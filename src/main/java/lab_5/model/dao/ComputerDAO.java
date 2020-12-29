package lab_5.model.dao;


import lab_5.DatabaseConnector;
import lab_5.model.entity.Computer;
import lab_5.model.entity.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class ComputerDAO implements GeneralDAO<Computer> {

    protected final SessionFactory sessionFactory = DatabaseConnector.getSessionFactory();

    @Override
    public List<Computer> findAll() {
        List<Computer> computers = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            computers = session.createQuery("from Computer").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return computers;
    }


    @Override
    public Computer findOne(Integer id) {
        Computer computer = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            computer = session.get(Computer.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return computer;
    }

    @Override
    public void create(Computer computer) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(computer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Computer computer) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(computer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Worker worker = session.get(Worker.class, id);
            if (worker != null) {
                session.delete(worker);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




