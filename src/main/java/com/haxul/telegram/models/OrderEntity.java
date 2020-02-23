package com.haxul.telegram.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue()
    private int id;

    public OrderEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
