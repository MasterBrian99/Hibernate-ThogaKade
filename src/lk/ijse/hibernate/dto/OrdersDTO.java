package lk.ijse.hibernate.dto;

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.OrderDetail;

import javax.persistence.ManyToOne;
import java.util.List;

public class OrdersDTO {
    private String id;
    private String date;
    private CustomerDTO customer;
    private List<OrderDetailDTO> orderDetail;
    private List<ItemDTO> itemDTOS;

    public OrdersDTO() {
    }

    public OrdersDTO(String id, String date, CustomerDTO customer, List<OrderDetailDTO> orderDetail, List<ItemDTO> itemDTOS) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.orderDetail = orderDetail;
        this.itemDTOS = itemDTOS;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", customer=" + customer +
                ", orderDetail=" + orderDetail +
                ", itemDTOS=" + itemDTOS +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<OrderDetailDTO> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetailDTO> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public List<ItemDTO> getItemDTOS() {
        return itemDTOS;
    }

    public void setItemDTOS(List<ItemDTO> itemDTOS) {
        this.itemDTOS = itemDTOS;
    }
}
