package com.example.assignmetjava4.service.impl;

import com.example.assignmetjava4.entity.Laptop;
import com.example.assignmetjava4.entity.Role;
import com.example.assignmetjava4.entity.RoleAccount;
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
        page = page - 1;
        List<Laptop> list = new ArrayList<>();
        while (true) {
            list = LAPTOP_REPOSITORY.getAll(page * size, size);
            if (list == null || list.isEmpty()) {
                size--;
                if (size < 0) {
                    break;
                }
                continue;
            }
            break;

        }
        return list;
    }

    @Override
    public Laptop getOne(String id) {
        return LAPTOP_REPOSITORY.getOne(id);
    }

    @Override
    public List<Laptop> getAll() {
        return LAPTOP_REPOSITORY.getAll();
    }

    public static void main(String[] args) {
        System.out.println(new LaptopServiceImpl().getAll(1));
    }
}
