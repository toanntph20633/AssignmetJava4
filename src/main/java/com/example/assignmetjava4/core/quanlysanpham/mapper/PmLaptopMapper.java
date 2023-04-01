package com.example.assignmetjava4.core.quanlysanpham.mapper;

import com.example.assignmetjava4.core.quanlysanpham.entity.request.PnLaptopReq;
import com.example.assignmetjava4.entity.Laptop;

import java.math.BigDecimal;

public class PmLaptopMapper {
    public static Laptop toLaptop(PnLaptopReq req){
        return Laptop.builder()
                .laptopCode(req.getLaptopCode())
                .laptopName(req.getLaptopName())
                .price(new BigDecimal(req.getPrice()))
                .description(req.getDescription())
                .images(req.getImages())
                .build();
    }
}
