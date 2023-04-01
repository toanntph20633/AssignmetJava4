package com.example.assignmetjava4.core.quanlysanpham.repository;

import com.example.assignmetjava4.entity.Brand;

import java.util.List;

public interface PmBrandRepository {
    List<Brand> getAll();

    Brand getOne(String id);
}
