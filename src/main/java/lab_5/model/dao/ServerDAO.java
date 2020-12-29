package lab_5.model.dao;


import lab_5.DatabaseConnector;
import lab_5.model.entity.Server;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class ServerDAO implements GeneralDAO<Server> {


    protected final SessionFactory sessionFactory = DatabaseConnector.getSessionFactory();

    @Override
    public List<Server> findAll() {
        List<Server> servers = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            servers = session.createQuery("from Server").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return servers;
    }

    @Override
    public Server findOne(Integer id) {
        Server server = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            server = session.get(Server.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return server;
    }

    @Override
    public void create(Server server) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(server);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Server server) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(server);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Server server = session.get(Server.class, id);
            if (server != null) {
                session.delete(server);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
