package com.example.assignmetjava4.core.quanlysanpham.repository;

import com.example.assignmetjava4.entity.Laptop;
import com.example.assignmetjava4.entity.LaptopDetail;

import java.util.List;

public interface PmLaptopRepository {
    List<Laptop> getAll(int page, int size);

    List<Laptop> getAll();

    Laptop detail(String id);

    void save(Laptop laptop);

    void saveDetail(int soLuong, Laptop laptop);

    void update(Laptop laptop);

    void delete(Laptop laptop);

    boolean checkMa(String code);
    boolean checkMaUpdate(String code,String id);

    int countPageLaptop();
    int countPageLaptopDetail(String id);

    List<LaptopDetail> getLaptopDetailsByLaptopId(String id,int page, int size);
}
