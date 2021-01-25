package lk.ijse.hibernate.dto;

import lk.ijse.hibernate.entity.Customer;

import javax.persistence.ManyToOne;

public class OrdersDTO {
    private String id;
    private String date;

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public OrdersDTO(String id, String date) {
        this.id = id;
        this.date = date;
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
