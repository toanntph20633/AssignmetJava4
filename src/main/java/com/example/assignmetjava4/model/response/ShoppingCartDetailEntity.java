package com.example.assignmetjava4.model.response;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_cart_detail", schema = "dbo", catalog = "ASSJAVA4")
public class ShoppingCartDetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "shopping_cart_id", nullable = true)
    private Object shoppingCartId;
    @Basic
    @Column(name = "laptop_detail_id", nullable = true)
    private Object laptopDetailId;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Object shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Object getLaptopDetailId() {
        return laptopDetailId;
    }

    public void setLaptopDetailId(Object laptopDetailId) {
        this.laptopDetailId = laptopDetailId;
    }
}
