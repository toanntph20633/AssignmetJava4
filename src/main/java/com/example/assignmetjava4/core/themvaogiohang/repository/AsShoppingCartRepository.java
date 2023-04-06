package com.example.assignmetjava4.core.themvaogiohang.repository;

import com.example.assignmetjava4.core.themvaogiohang.entity.respone.GioHangResList;
import com.example.assignmetjava4.repository.ShoppingCartRepository;

import java.util.List;

public interface AsShoppingCartRepository extends ShoppingCartRepository {
    void save();
    List<GioHangResList> getListGioHang(String idUser);
}
