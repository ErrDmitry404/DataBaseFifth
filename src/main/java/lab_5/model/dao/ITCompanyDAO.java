package lab_5.model.dao;

import lab_5.DatabaseConnector;
import lab_5.model.entity.ITCompany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class ITCompanyDAO implements GeneralDAO<ITCompany> {


    protected final SessionFactory sessionFactory = DatabaseConnector.getSessionFactory();

    @Override
    public List<ITCompany> findAll() {
        List<ITCompany> companies = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            companies = session.createQuery("from ITCompany").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public ITCompany findOne(Integer id) {
        ITCompany company = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            company = session.get(ITCompany.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(ITCompany company) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(company);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, ITCompany company) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(company);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            ITCompany company = session.get(ITCompany.class, id);
            if (company!= null) {
                session.delete(company);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
