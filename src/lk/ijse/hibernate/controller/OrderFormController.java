package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXTextField;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.BOTypes;
import lk.ijse.hibernate.bo.custom.impl.CustomerBOImpl;

public class OrderFormController {
    public JFXTextField txtCustomerID;


    CustomerBOImpl customerBO = BOFactory.getInstance().getBO(BOTypes.CUSTOMER);







}
