package lk.ijse.hibernate.entity;

import lk.ijse.hibernate.dto.CustomerDTO;

import javax.persistence.*;

@Entity
public class Orders implements SuperEntity {
    @Id
    private String id;
    private String date;
    @OneToOne
    private Customer customer;


    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", customer=" + customer +
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Orders(String id, String date, Customer customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
    }
}
