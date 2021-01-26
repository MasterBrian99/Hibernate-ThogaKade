package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.OrdersBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOTypes;
import lk.ijse.hibernate.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.hibernate.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.hibernate.dto.CustomerDTO;
import lk.ijse.hibernate.dto.OrdersDTO;
import lk.ijse.hibernate.entity.Customer;

import lk.ijse.hibernate.entity.Orders;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;

import java.util.List;

public class OrdersBOImpl implements OrdersBO {
    OrdersDAOImpl ordersDAO = DAOFactory.getInstance().getDAO(DAOTypes.ORDER);
    OrderDetailDAOImpl orderDetailDAO = DAOFactory.getInstance().getDAO(DAOTypes.ORDERDETAIL);

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
        Session session = FactoryConfiguration.getInstance().getSession();
        CustomerDTO customerDTO = new CustomerDTO(o.getCustomer().getId());
        Customer customer = new Customer(customerDTO.getId());
        Orders orders = new Orders(o.getId(), o.getDate(), customer);
        session.getTransaction().begin();

        System.out.println(orders);

        boolean add = ordersDAO.add(orders);

//        orderDetailDAO.add()
        session.getTransaction().commit();
        session.close();

        return add;
    }


}
