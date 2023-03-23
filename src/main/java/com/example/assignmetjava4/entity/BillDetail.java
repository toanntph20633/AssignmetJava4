package com.example.assignmetjava4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "bill_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDetail {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill billId;
    @ManyToOne
    @JoinColumn(name = "laptop_detail_id")
    private LaptopDetail laptopDetailId;
}
