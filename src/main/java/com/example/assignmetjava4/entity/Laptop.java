package com.example.assignmetjava4.entity;

import com.example.assignmetjava4.utilities.LaptopStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "laptop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Laptop {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;
    @Column(name = "laptop_code")
    private String laptopCode;
    @Column(name = "laptop_name")
    private String laptopName;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brandId;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private LaptopStatus status;
    @Column(name = "description")
    private String description;
    @Column(name = "images")
    private String images;
//    @OneToMany(mappedBy = "laptopId", fetch = FetchType.LAZY)
//    private Set<LaptopDetail> laptopDetails;

    @Override
    public String toString() {
        return "Laptop{" +
                "id='" + id + '\'' +
                ", laptopCode='" + laptopCode + '\'' +
                ", laptopName='" + laptopName + '\'' +
                ", price='" + price + '\'' +
                ", brandId=" + brandId +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}' + "\n";
    }
}
