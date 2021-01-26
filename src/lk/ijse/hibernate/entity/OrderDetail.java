package lk.ijse.hibernate.entity;

import javax.persistence.*;

@Entity
public class OrderDetail implements SuperEntity {
    @Id
    private String id;

    @ManyToOne
    private Item code;

    private int qty;
    private double price;
    @ManyToOne
    private Orders orders;

    public OrderDetail() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item getCode() {
        return code;
    }

    public void setCode(Item code) {
        this.code = code;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public OrderDetail(String id, Item code, int qty, double price, Orders orders) {
        this.id = id;
        this.code = code;
        this.qty = qty;
        this.price = price;
        this.orders = orders;
    }
}
