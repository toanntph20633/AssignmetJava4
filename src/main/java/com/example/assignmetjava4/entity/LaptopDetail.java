package com.example.assignmetjava4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "laptop_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LaptopDetail {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "laptop_detail_code")
    private String laptopDetailCode;
    @ManyToOne
    @JoinColumn(name = "laptop_id")
    private Laptop laptopId;
}
