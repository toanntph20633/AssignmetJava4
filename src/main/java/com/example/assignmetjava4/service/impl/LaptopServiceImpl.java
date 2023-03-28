package com.example.assignmetjava4.service.impl;

import com.example.assignmetjava4.entity.Laptop;
import com.example.assignmetjava4.repository.LaptopRepository;
import com.example.assignmetjava4.repository.impl.LaptopRepositoryImpl;
import com.example.assignmetjava4.service.LaptopService;

import java.util.ArrayList;
import java.util.List;

public class LaptopServiceImpl implements LaptopService {
    private static final LaptopRepository LAPTOP_REPOSITORY = new LaptopRepositoryImpl();

    @Override
    public List<Laptop> getAll(int page) {
        int size = 10;
        page = page -1;
        List<Laptop> list = new ArrayList<>();
        while (true) {
            list = LAPTOP_REPOSITORY.getAll( page* size, size);
            if(list == null){
                size--;
                continue;
            }
            if (size < 0) {
                break;
            }
            if (!list.isEmpty()) {
                break;
            }
        }
        return list;
    }

    @Override
    public Laptop getOne(String id) {
        return LAPTOP_REPOSITORY.getOne(id);
    }
}
