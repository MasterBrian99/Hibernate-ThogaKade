package lk.ijse.hibernate.controller;


import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.BOTypes;
import lk.ijse.hibernate.bo.custom.CustomerBO;
import lk.ijse.hibernate.bo.custom.ItemBO;
import lk.ijse.hibernate.dto.ItemDTO;

import java.util.List;

public class OrderFormController {


    public Label lblTotaltems;
    public Label lblTotalCustomers;
    public JFXComboBox cmbItemName;

    CustomerBO customerBO = BOFactory.getInstance().getBO(BOTypes.CUSTOMER);
    ItemBO itemBO=BOFactory.getInstance().getBO(BOTypes.ITEM);

    public void initialize() throws Exception{
        getTotalCustomers();
        getTotalItems();
        setItems();

    }


    public void setItems(){
        try {
            List<ItemDTO> all = itemBO.findAll();
            cmbItemName.getItems().clear();

            for (ItemDTO itemDTO : all) {
                cmbItemName.getItems().add(itemDTO.getDescription());
            }


            System.out.println(all);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTotalItems(){
        try {
            long all = itemBO.getCount();
            lblTotaltems.setText(String.valueOf(all));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTotalCustomers() {
        try {
            long all = customerBO.getCount();
            lblTotalCustomers.setText(String.valueOf(all));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getInfoOnAction(ActionEvent actionEvent) {
        getTotalCustomers();

    }
}
