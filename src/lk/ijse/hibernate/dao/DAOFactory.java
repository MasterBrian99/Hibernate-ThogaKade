package lk.ijse.hibernate.dao;

import lk.ijse.hibernate.dao.custom.CustomerDAO;
import lk.ijse.hibernate.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.hibernate.dao.custom.impl.ItemDAOImpl;
import lk.ijse.hibernate.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.hibernate.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.hibernate.entity.Customer;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory (){

    }

    public static DAOFactory  getInstance(){
        return (daoFactory ==null) ? daoFactory=new DAOFactory() :daoFactory;
    }
        public <T extends SuperDAO> T getDAO(DAOTypes daoTypes){
                switch (daoTypes){
                    case CUSTOMER:
                        return (T) new CustomerDAOImpl();
                    case ITEM:
                        return (T) new ItemDAOImpl();
                    case ORDER:
                        return  (T) new OrdersDAOImpl();
                    case ORDERDETAIL:
                        return (T) new OrderDetailDAOImpl();
                    default:
                        return null;
                }
        }
}
