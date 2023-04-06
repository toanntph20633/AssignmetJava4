package com.example.assignmetjava4.core.themvaogiohang.service;

import com.example.assignmetjava4.core.themvaogiohang.entity.respone.GioHangResList;

import java.util.List;

public interface AsShoppingCartService {
    List<GioHangResList> getListGioHang(String idUser);
}
