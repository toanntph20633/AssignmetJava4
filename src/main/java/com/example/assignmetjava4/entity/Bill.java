package com.example.assignmetjava4.entity;

import com.example.assignmetjava4.utilities.BillStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "Bill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "bill_code")
    private String billCode;
    @Column(name = "date_create")
    private Date dateCreate;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "price_sale")
    private BigDecimal priceSale;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customerId;

    @Column(name = "status")
    private BillStatus status;
}
