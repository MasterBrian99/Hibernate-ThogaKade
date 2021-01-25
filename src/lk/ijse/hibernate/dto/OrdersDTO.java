package lk.ijse.hibernate.dto;

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.OrderDetail;

import javax.persistence.ManyToOne;
import java.util.List;

public class OrdersDTO {
    private String id;
    private String date;
    private Customer customer;
    private List<OrderDetail> orderDetail;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public OrdersDTO(String id, String date, Customer customer, List<OrderDetail> orderDetail) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.orderDetail = orderDetail;
    }

    public OrdersDTO() {
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


}
