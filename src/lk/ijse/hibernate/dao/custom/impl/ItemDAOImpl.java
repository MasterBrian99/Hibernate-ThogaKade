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
    Session session = FactoryConfiguration.getInstance().getSession();

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
        Transaction transaction = session.beginTransaction();
      Query query = session.createQuery("from Item where id = ?1");
      query.setParameter(1,"POO1");
      Item item = (Item) query.uniqueResult();
      System.out.println(item);
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public List<Item> findAll() throws Exception {
        Query from_item_ = session.createQuery("from Item ");

        return (List<Item>) from_item_.list();
    }

    @Override
    public long getAll() throws Exception {
        Query query = session.createQuery("select count(*) from Item");

        return (Long) query.uniqueResult();


    }
}
