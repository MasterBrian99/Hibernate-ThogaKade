package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.OrdersBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOTypes;
import lk.ijse.hibernate.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.hibernate.dto.OrdersDTO;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Orders;

import javax.persistence.criteria.Order;
import java.util.List;

public class OrdersBOImpl implements OrdersBO {
        OrdersDAOImpl ordersDAO=DAOFactory.getInstance().getDAO(DAOTypes.ORDER);

    @Override
    public OrdersDTO find(String s) throws Exception {
        return null;
    }

    @Override
    public long getCount() throws Exception {
        return 0;
    }

    @Override
    public List<OrdersDTO> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean add(OrdersDTO o) throws Exception {



        return false;
    }

    @Override
    public boolean addOrder(OrdersDTO o, Customer customer) throws Exception {
    Orders orders=new Orders(o.getId(),o.getDate(),o.getCustomer());

        return false;
    }
}
