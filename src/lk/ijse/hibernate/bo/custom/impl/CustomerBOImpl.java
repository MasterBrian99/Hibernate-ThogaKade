package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.CustomerBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOTypes;
import lk.ijse.hibernate.dao.SuperDAO;
import lk.ijse.hibernate.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.hibernate.dto.CustomerDTO;
import lk.ijse.hibernate.dto.ItemDTO;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAOImpl customerDAO = DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);

    @Override
    public boolean add(CustomerDTO customerDTO) throws Exception {
        return customerDAO.add(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), ""));
    }

    @Override
    public String getID() throws Exception {
        String id = customerDAO.getID();
        int i = Integer.parseInt(id.substring(1, 4)) + 1;
        if (i < 10) {
            return "C00" + i;
        } else if (i < 100) {
            return "C0" + i;
        } else {
            return "C" + i;
        }


    }

    @Override
    public CustomerDTO find(String s) throws Exception {
        Customer customer = customerDAO.find(s);
        CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());

        return customerDTO;

    }

    @Override
    public long getCount() throws Exception {

        return customerDAO.getCount();
    }

    @Override
    public List<CustomerDTO> findAll() throws Exception {
        List<Customer> all = customerDAO.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer c : all) {
            CustomerDTO customerDTO = new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getSalary());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;

    }


}