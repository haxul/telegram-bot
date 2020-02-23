package com.haxul.telegram.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @Column
    private int bottleAmount;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createOrderTime;

    public Order() {}
    public Order(User user, int bottleAmount, Date date){
        this.user = user;
        this.bottleAmount = bottleAmount;
        this.deliveryDate = date;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBottleAmount() {
        return bottleAmount;
    }

    public void setBottleAmount(int bottleAmount) {
        this.bottleAmount = bottleAmount;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getCreateOrderTime() {
        return createOrderTime;
    }

    public void setCreateOrderTime(Date createOrderTime) {
        this.createOrderTime = createOrderTime;
    }
}
