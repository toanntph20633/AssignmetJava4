package com.example.assignmetjava4.model.response;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bill_detail", schema = "dbo", catalog = "ASSJAVA4")
public class BillDetailEntity {
    @Basic
    @Column(name = "laptop_detail_id", nullable = true)
    private Object laptopDetailId;
    @Basic
    @Column(name = "bill_id", nullable = true)
    private Object billId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;

    public Object getLaptopDetailId() {
        return laptopDetailId;
    }

    public void setLaptopDetailId(Object laptopDetailId) {
        this.laptopDetailId = laptopDetailId;
    }

    public Object getBillId() {
        return billId;
    }

    public void setBillId(Object billId) {
        this.billId = billId;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
