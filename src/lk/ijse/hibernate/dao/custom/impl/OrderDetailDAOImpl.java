package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.OrderDetailDAO;
import lk.ijse.hibernate.entity.OrderDetail;

import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean add(OrderDetail entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(OrderDetail entity) throws Exception {
        return false;
    }

    @Override
    public OrderDetail find(String s) throws Exception {
        return null;
    }

    @Override
    public List<OrderDetail> findAll() throws Exception {
        return null;
    }

    @Override
    public long getCount() throws Exception {
        return 0;
    }
}
