package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.CustomerDTO;

public interface CustomerBO extends SuperBO {
    public boolean add(CustomerDTO customerDTO) throws Exception;
        public String getID() throws Exception;


}