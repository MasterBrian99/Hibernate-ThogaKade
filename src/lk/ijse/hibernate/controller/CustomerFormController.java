package lk.ijse.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.BOTypes;
import lk.ijse.hibernate.bo.custom.impl.CustomerBOImpl;
import lk.ijse.hibernate.dto.CustomerDTO;

public class CustomerFormController {
    public Label lblID;
    CustomerBOImpl customerBO = BOFactory.getInstance().getBO(BOTypes.CUSTOMER);

    public TextField txtID;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnSave;


        public void initialize(){
            lblID.setText(generateID());
        }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String text = txtID.getText();
        String text1 = txtName.getText();
        String text2 = txtAddress.getText();
        CustomerDTO customerDTO = new CustomerDTO(text, text1, text2);
        try {
            boolean add = customerBO.add(customerDTO);
                if (add){
                    new Alert(Alert.AlertType.CONFIRMATION,"OK").showAndWait();

                }
                    txtID.clear();
                txtAddress.clear();
                    txtName.clear();
                    txtID.requestFocus();

        } catch (Exception e) {

            e.printStackTrace();
        }
        lblID.setText(generateID());
    }

    public String generateID(){
        String id=null;
        try {
          id = customerBO.getID();
        } catch (Exception e) {
            e.printStackTrace();
        }

    return id;
    }
}
