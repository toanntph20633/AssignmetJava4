package com.example.assignmetjava4.entity;

import com.example.assignmetjava4.utilities.BrandStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "brand")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brand {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "brand_code")
    private String brandCode;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private BrandStatus status;
    @OneToMany(mappedBy = "brandId", fetch = FetchType.LAZY)
    private Set<Laptop> laptops;
}
