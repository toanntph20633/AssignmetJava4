package com.example.assignmetjava4.model.response;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "laptop_detail", schema = "dbo", catalog = "ASSJAVA4")
public class LaptopDetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "laptop_detail_code", nullable = true, length = 200)
    private String laptopDetailCode;
    @Basic
    @Column(name = "laptop_id", nullable = true)
    private Object laptopId;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getLaptopDetailCode() {
        return laptopDetailCode;
    }

    public void setLaptopDetailCode(String laptopDetailCode) {
        this.laptopDetailCode = laptopDetailCode;
    }

    public Object getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(Object laptopId) {
        this.laptopId = laptopId;
    }
}
