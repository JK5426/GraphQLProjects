package com.learing.graphql.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String orderDetail;
    private String address;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
