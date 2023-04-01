package com.example.assignmetjava4.core.quanlysanpham.service;

import com.example.assignmetjava4.core.quanlysanpham.entity.request.PnLaptopReq;
import com.example.assignmetjava4.entity.Laptop;
import com.example.assignmetjava4.entity.LaptopDetail;

import java.util.List;

public interface PmLaptopService {
    void save(PnLaptopReq req, String soLuongString);

    void update(PnLaptopReq req);

    void delete(String id);

    List<Laptop> getAll(int page);

    Laptop detail(String id);

    int pageSizeLaptop();

    int pageSizeLaptopDetail(String id);

    List<LaptopDetail> getListDetailByLaptopId(String id, int page);
}
