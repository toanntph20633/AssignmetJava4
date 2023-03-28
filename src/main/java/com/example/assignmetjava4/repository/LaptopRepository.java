package com.example.assignmetjava4.repository;

import com.example.assignmetjava4.entity.Laptop;

import java.util.List;

public interface LaptopRepository {
    List<Laptop> getAll(int page,int size);
    Laptop getOne(String id);
}
