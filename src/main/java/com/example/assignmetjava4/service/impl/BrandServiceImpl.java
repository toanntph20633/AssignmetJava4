package com.example.assignmetjava4.service.impl;

import com.example.assignmetjava4.entity.Brand;
import com.example.assignmetjava4.repository.BrandRepository;
import com.example.assignmetjava4.repository.impl.BrandRepositoryImpl;
import com.example.assignmetjava4.service.BrandService;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    private static final BrandRepository BRAND_REPOSITORY = new BrandRepositoryImpl();

    @Override
    public List<Brand> getListBrand() {
        return BRAND_REPOSITORY.getAll();
    }
}
