package com.example.assignmetjava4.entity;

import com.example.assignmetjava4.utilities.LaptopStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "laptop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Laptop {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "laptop_code")
    private String laptopCode;
    @Column(name = "laptop_name")
    private String laptopName;
    @Column(name = "price")
    private String price;
    @Column(name = "quantity")
    private String quantity;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brandId;
    @Column(name = "status")
    private LaptopStatus status;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "laptopId", fetch = FetchType.LAZY)
    private Set<LaptopDetail> laptopDetails;
}
