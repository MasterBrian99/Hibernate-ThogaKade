package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.CustomerBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOTypes;
import lk.ijse.hibernate.dao.SuperDAO;
import lk.ijse.hibernate.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.hibernate.dto.CustomerDTO;
import lk.ijse.hibernate.entity.Customer;

public class CustomerBOImpl  implements CustomerBO {
    CustomerDAOImpl customerDAO= DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);

    @Override
    public boolean add(CustomerDTO customerDTO) throws Exception {
       return customerDAO.add(new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress()));
    }

    @Override
        public String getID() throws Exception {
        String id = customerDAO.getID();
            int i = Integer.parseInt(id.substring(1, 4)) + 1;
            if (i<10){
                return "C00"+i;
            }else if (i<100) {
                return "C0"+i;
            }else{
                return "C"+i;
            }


    }
}




