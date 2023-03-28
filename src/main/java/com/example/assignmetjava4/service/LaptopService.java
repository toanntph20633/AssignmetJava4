package com.example.assignmetjava4.service;

import com.example.assignmetjava4.entity.Laptop;

import java.util.List;

public interface LaptopService {
    List<Laptop> getAll(int page);
    Laptop getOne(String id);
}
