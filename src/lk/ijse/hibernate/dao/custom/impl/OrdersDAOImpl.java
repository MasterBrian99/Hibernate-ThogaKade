package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.OrdersDAO;
import lk.ijse.hibernate.entity.Orders;

import java.util.List;

public class OrdersDAOImpl implements OrdersDAO {
    @Override
    public boolean add(Orders entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Orders entity) throws Exception {
        return false;
    }

    @Override
    public Orders find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Orders> findAll() throws Exception {
        return null;
    }

    @Override
    public long getCount() throws Exception {
        return 0;
    }
}
