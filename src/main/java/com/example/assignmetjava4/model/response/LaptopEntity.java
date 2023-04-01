package com.example.assignmetjava4.model.response;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "laptop", schema = "dbo", catalog = "ASSJAVA4")
public class LaptopEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "latop_code", nullable = true, length = 100)
    private String latopCode;
    @Basic
    @Column(name = "laptop_name", nullable = true, length = 500)
    private String laptopName;
    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private Integer price;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;
    @Basic
    @Column(name = "brand_id", nullable = true)
    private Object brandId;
    @Basic
    @Column(name = "description", nullable = true, length = 1000)
    private String description;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getLatopCode() {
        return latopCode;
    }

    public void setLatopCode(String latopCode) {
        this.latopCode = latopCode;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getBrandId() {
        return brandId;
    }

    public void setBrandId(Object brandId) {
        this.brandId = brandId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
