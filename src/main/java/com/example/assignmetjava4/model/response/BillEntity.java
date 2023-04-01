package com.example.assignmetjava4.model.response;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "Bill", schema = "dbo", catalog = "ASSJAVA4")
public class BillEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "bill_code", nullable = true, length = 100)
    private String billCode;
    @Basic
    @Column(name = "id_customer", nullable = true)
    private Object idCustomer;
    @Basic
    @Column(name = "date_create", nullable = true)
    private Date dateCreate;
    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;
    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private Integer price;
    @Basic
    @Column(name = "price_sale", nullable = true, precision = 0)
    private Integer priceSale;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public Object getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Object idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Integer priceSale) {
        this.priceSale = priceSale;
    }
}
