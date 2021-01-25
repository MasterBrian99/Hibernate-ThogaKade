package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.ItemDAO;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ItemDAOImpl  implements ItemDAO {

    @Override
    public boolean add(Item entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Item entity) throws Exception {
        return false;
    }

    @Override
    public Item find(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();
      Query query = session.createQuery("from Item where id = ?1");
      query.setParameter(1,s);
      Item item = (Item) query.uniqueResult();
      System.out.println(item);
        transaction.commit();
        session.close();
        return item;
    }

    @Override
    public List<Item> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Query from_item_ = session.createQuery("from Item ");

        return (List<Item>) from_item_.list();
    }

    @Override
    public long getCount() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Query query = session.createQuery("select count(*) from Item");

        return (Long) query.uniqueResult();


    }


}
