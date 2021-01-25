package lk.ijse.hibernate.dao.custom;

import lk.ijse.hibernate.dao.SuperDAO;
import lk.ijse.hibernate.entity.Customer;

public interface CustomerDAO extends SuperDAO<Customer,String> {
    public String getID () throws Exception;
    public long getAll() throws Exception;
}
