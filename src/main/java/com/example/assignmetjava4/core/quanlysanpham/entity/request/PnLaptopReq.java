package com.example.assignmetjava4.core.quanlysanpham.entity.request;

import com.example.assignmetjava4.entity.Brand;
import com.example.assignmetjava4.utilities.LaptopStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PnLaptopReq {
    private String id;
    private String laptopCode;
    private String laptopName;
    private String price;
    private String brandId;
    private String description;
    private String images;
}
