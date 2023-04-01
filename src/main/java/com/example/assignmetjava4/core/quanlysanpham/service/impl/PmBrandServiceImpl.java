package com.example.assignmetjava4.core.quanlysanpham.service.impl;

import com.example.assignmetjava4.core.quanlysanpham.repository.PmBrandRepository;
import com.example.assignmetjava4.core.quanlysanpham.repository.impl.PmBrandRepositoryImpl;
import com.example.assignmetjava4.core.quanlysanpham.service.PmBrandService;
import com.example.assignmetjava4.entity.Brand;

import java.util.List;

public class PmBrandServiceImpl implements PmBrandService {
        private static final PmBrandRepository BRAND_REPOSITORY = new PmBrandRepositoryImpl();
    @Override
    public List<Brand> getAll() {
        return BRAND_REPOSITORY.getAll();
    }
}
