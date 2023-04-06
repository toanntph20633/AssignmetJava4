package com.example.assignmetjava4.core.themvaogiohang.entity.respone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GioHangResList {
    private String id;
    private String idLaptop;
    private String brandName;
    private String idUser;
    private String images;

    private String name;

    private int quantity;

    private BigDecimal price;

    public BigDecimal getTotal(){
        return price.multiply(new BigDecimal(quantity));
    }
}
