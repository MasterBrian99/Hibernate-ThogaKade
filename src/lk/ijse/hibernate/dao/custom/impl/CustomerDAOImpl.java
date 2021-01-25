package lk.ijse.hibernate.dao.custom.impl;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lk.ijse.hibernate.dao.custom.CustomerDAO;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    Session session = FactoryConfiguration.getInstance().getSession();

    @Override
    public boolean add(Customer entity) throws Exception {
        Transaction transaction = session.beginTransaction();
        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        return false;
    }

    @Override
    public Customer find(String s) throws Exception {
        Session se = FactoryConfiguration.getInstance().getSession();

        Query query = se.createQuery("from Customer where id = ?1");
        query.setParameter(1, s);
        Customer customer = (Customer) query.uniqueResult();
        se.close();
        return customer;
    }

    @Override
    public List<Customer> findAll() throws Exception {

        Query from_customer = session.createQuery("from Customer ");

        return (List<Customer>) from_customer.list();
    }

    @Override
    public long getCount() throws Exception {
        Query query = session.createQuery("select count(*) from Customer");

        return (Long) query.uniqueResult();
    }

    @Override
    public String getID() throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        NativeQuery sqlQuery = session.createSQLQuery("SELECT id from Customer order by id desc limit 1");
//        String id = (String) sqlQuery.uniqueResult();
//        transaction.commit();
//
//        session.close();

        return null;
    }

}
