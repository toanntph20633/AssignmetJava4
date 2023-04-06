package com.example.assignmetjava4.core.themvaogiohang.service.impl;

import com.example.assignmetjava4.core.themvaogiohang.entity.respone.GioHangResList;
import com.example.assignmetjava4.core.themvaogiohang.repository.AsDetailShoppingCartRepository;
import com.example.assignmetjava4.core.themvaogiohang.repository.AsShoppingCartRepository;
import com.example.assignmetjava4.core.themvaogiohang.repository.impl.AsShoppingCartRepositoryImpl;
import com.example.assignmetjava4.core.themvaogiohang.service.AsShoppingCartService;

import java.util.List;

public class AsShoppingCartServiceImpl implements AsShoppingCartService {
    private static final AsShoppingCartRepository SHOPPING_CART_REPOSITORY = new AsShoppingCartRepositoryImpl();

    @Override
    public List<GioHangResList> getListGioHang(String idUser) {
        return SHOPPING_CART_REPOSITORY.getListGioHang(idUser);
    }
}
