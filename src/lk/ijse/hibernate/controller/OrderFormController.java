package lk.ijse.hibernate.controller;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.BOTypes;
import lk.ijse.hibernate.bo.custom.CustomerBO;
import lk.ijse.hibernate.bo.custom.ItemBO;
import lk.ijse.hibernate.dto.CustomerDTO;
import lk.ijse.hibernate.dto.ItemDTO;

import java.util.List;

public class OrderFormController {

    public JFXTextField txtItemSetQty;
    public JFXTextField txtOrderTotalPrice;
    public JFXComboBox cmbCustomerId;
    public Label lblCustomerName;
    @FXML
    private TableView<ItemDTO> tblOrderItems;

    @FXML
    private TableColumn<ItemDTO, String> clmItemCode;

    @FXML
    private TableColumn<ItemDTO, String> clmItemDescription;

    @FXML
    private TableColumn<ItemDTO, Integer> clmItemQty;

    @FXML
    private TableColumn<ItemDTO, Double> clmItemTotal;

    public Label lblTotaltems;
    public Label lblTotalCustomers;
    public JFXComboBox cmbItemCode;
    public Label lblItemDescription;
    public Label lblItemUnitPrice;
    public Label lblItemQty;

    CustomerBO customerBO = BOFactory.getInstance().getBO(BOTypes.CUSTOMER);
    ItemBO itemBO = BOFactory.getInstance().getBO(BOTypes.ITEM);

    public void initialize() throws Exception {
        getTotalCustomers();
        getTotalItems();
        setItems();
        clearFields();
        getCustomers();
    }


    public void getCustomers() {
        try {
            List<CustomerDTO> all = customerBO.findAll();
            cmbCustomerId.getItems().clear();
            for (CustomerDTO customerDTO : all) {
                cmbCustomerId.getItems().add(customerDTO.getId());
            }

        } catch (Exception e) {


            e.printStackTrace();
        }


    }

    public void cmbItemCodeOnAction(ActionEvent actionEvent) {
        String s = (String) cmbItemCode.getValue();
        try {
            ItemDTO itemDTO = itemBO.find(s);
            lblItemDescription.setText(itemDTO.getDescription());
            lblItemQty.setText(String.valueOf(itemDTO.getQtyOnHand()));
            lblItemUnitPrice.setText(String.valueOf(itemDTO.getUnitPrice()));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setItems() {
        try {
            List<ItemDTO> all = itemBO.findAll();
            cmbItemCode.getItems().clear();

            for (ItemDTO itemDTO : all) {
                cmbItemCode.getItems().add(itemDTO.getCode());

            }


            System.out.println(all);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getTotalItems() {
        try {
            long all = itemBO.getCount();
            lblTotaltems.setText(String.valueOf(all));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getTotalCustomers() {
        try {
            long all = customerBO.getCount();
            lblTotalCustomers.setText(String.valueOf(all));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void clearFields() {
        lblItemDescription.setText("");
        lblItemUnitPrice.setText("");
        lblItemQty.setText("");
        txtItemSetQty.setText("1");
        lblCustomerName.setText("");

    }

    private int isAlreadyExist(String itemId) {

        for (int i = 0; i < tblOrderItems.getItems().size(); i++) {
            ItemDTO itemDTO = tblOrderItems.getItems().get(i);
            if (itemDTO.getCode().equals(itemId)) {
                return i;
            }
        }

        return -1;
    }

    public void btnAddItemOnAction(ActionEvent actionEvent) {

        int itemSetQty = Integer.parseInt(txtItemSetQty.getText());

        String itemCode = (String) cmbItemCode.getValue();
        String itemDes = lblItemDescription.getText();
        double itemTotalPrice = itemSetQty * Double.parseDouble(lblItemUnitPrice.getText());

        ItemDTO itemDTO = new ItemDTO(itemCode, itemDes, itemTotalPrice, itemSetQty);

        int row = isAlreadyExist(itemCode);

        if (row == -1) {
            tblOrderItems.getItems().add(itemDTO);
        }

        clmItemCode.setCellValueFactory(new PropertyValueFactory<ItemDTO, String>("code"));
        clmItemDescription.setCellValueFactory(new PropertyValueFactory<ItemDTO, String>("description"));
        clmItemTotal.setCellValueFactory(new PropertyValueFactory<ItemDTO, Double>("unitPrice"));
        clmItemQty.setCellValueFactory(new PropertyValueFactory<ItemDTO, Integer>("qtyOnHand"));
        getValue();
    }

    public void getValue() {
        double total = 0;
        for (int i = 0; i < tblOrderItems.getItems().size(); i++) {
            ItemDTO itemDTO = tblOrderItems.getItems().get(i);
            total += itemDTO.getUnitPrice();

        }
        txtOrderTotalPrice.setText(String.valueOf(total));

    }

    public void cmbCustomerIdOnAction(ActionEvent actionEvent) {
        String CusId = (String) cmbCustomerId.getValue();

        try {
            CustomerDTO customerDTO = customerBO.find(CusId);
            lblCustomerName.setText(customerDTO.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void placeOrderOnAction(ActionEvent actionEvent) {



    }
}
