package com.example.assignmetjava4.entity;

import com.example.assignmetjava4.utilities.LaptopDetailStatus;
import com.example.assignmetjava4.utilities.LaptopStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "laptop_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LaptopDetail {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;
    @Column(name = "laptop_detail_code")
    private String laptopDetailCode;
    @ManyToOne
    @JoinColumn(name = "laptop_id")
    private Laptop laptopId;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private LaptopDetailStatus status;
}
