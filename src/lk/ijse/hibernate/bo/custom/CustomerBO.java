package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.CustomerDTO;

public interface CustomerBO extends SuperBO<CustomerDTO,String> {
        public String getID() throws Exception;

}