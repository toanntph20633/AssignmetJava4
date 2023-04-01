package com.example.assignmetjava4.core.quanlysanpham.service.impl;

import com.example.assignmetjava4.core.quanlysanpham.entity.request.PnLaptopReq;
import com.example.assignmetjava4.core.quanlysanpham.mapper.PmLaptopMapper;
import com.example.assignmetjava4.core.quanlysanpham.repository.PmBrandRepository;
import com.example.assignmetjava4.core.quanlysanpham.repository.PmLaptopRepository;
import com.example.assignmetjava4.core.quanlysanpham.repository.impl.PmBrandRepositoryImpl;
import com.example.assignmetjava4.core.quanlysanpham.repository.impl.PmLaptopRepositoryImpl;
import com.example.assignmetjava4.core.quanlysanpham.service.PmLaptopService;
import com.example.assignmetjava4.entity.Brand;
import com.example.assignmetjava4.entity.Laptop;
import com.example.assignmetjava4.entity.LaptopDetail;
import com.example.assignmetjava4.utilities.LaptopStatus;
import com.example.assignmetjava4.utilities.UtilClass;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PmLaptopServiceImpl implements PmLaptopService {
    private static final PmLaptopRepository LAPTOP_REPOSITORY = new PmLaptopRepositoryImpl();
    private static final PmBrandRepository BRAND_REPOSITORY = new PmBrandRepositoryImpl();

    @SneakyThrows
    @Transactional
    @Override
    public void save(PnLaptopReq req, String soLuongString) {
        if (!UtilClass.checkEmpty(req.getLaptopCode(), req.getLaptopName(), req.getDescription(), soLuongString, req.getImages(), req.getPrice(), req.getBrandId())) {
            throw new Exception("Không để trống thông tin");
        }
        if (!UtilClass.checkSo(soLuongString.trim())) {
            throw new Exception("Số lượng phải là số");
        }
        if (!UtilClass.checkSo(soLuongString.trim())) {
            throw new Exception("Số lượng phải là số");
        }
        if (!UtilClass.checkSo(req.getPrice().trim())) {
            throw new Exception("Giá phải là số");
        }
        if (!LAPTOP_REPOSITORY.checkMa(req.getLaptopCode())) {
            throw new Exception("Mã không được trùng");
        }
        Laptop laptop = PmLaptopMapper.toLaptop(req);
        Brand brand = BRAND_REPOSITORY.getOne(req.getBrandId());
        if (Objects.isNull(brand)) {
            throw new Exception("Brand không tồn tại");
        }
        laptop.setBrandId(brand);
        laptop.setStatus(LaptopStatus.ACTIVE);
        LAPTOP_REPOSITORY.save(laptop);
        LAPTOP_REPOSITORY.saveDetail(Integer.parseInt(soLuongString.trim()), laptop);
    }

    @SneakyThrows
    @Transactional
    @Override
    public void update(PnLaptopReq req) {
        Laptop laptop1 = LAPTOP_REPOSITORY.detail(req.getId());
        if (Objects.isNull(laptop1)) {
            throw new Exception("Không tìm thấy laptop");
        }
        if (!UtilClass.checkEmpty(req.getLaptopCode(), req.getLaptopName(), req.getDescription(), req.getPrice(), req.getBrandId())) {
            throw new Exception("Không để trống thông tin");
        }
        if (req.getImages() == null) {
            req.setImages(laptop1.getImages());
        }
        if (!UtilClass.checkSo(req.getPrice().trim())) {
            throw new Exception("Giá phải là số");
        }
        if (!LAPTOP_REPOSITORY.checkMaUpdate(req.getLaptopCode(), req.getId())) {
            throw new Exception("Mã không được trùng");
        }
        Laptop laptop = PmLaptopMapper.toLaptop(req);
        Brand brand = BRAND_REPOSITORY.getOne(req.getBrandId());
        if (Objects.isNull(brand)) {
            throw new Exception("Brand không tồn tại");
        }
        laptop.setId(req.getId());
        laptop.setBrandId(brand);
        laptop.setStatus(LaptopStatus.ACTIVE);
        LAPTOP_REPOSITORY.update(laptop);
    }

    @SneakyThrows
    @Transactional
    @Override
    public void delete(String id) {
        Laptop laptop = LAPTOP_REPOSITORY.detail(id);
        if (Objects.isNull(laptop)) {
            throw new Exception("Không tìm thấy laptop");
        }
        laptop.setStatus(LaptopStatus.DELETED);
        LAPTOP_REPOSITORY.update(laptop);
    }

    @SneakyThrows
    @Transactional
    @Override
    public List<Laptop> getAll(int page) {
        int size = 10;
        page = page - 1;

        List<Laptop> list = new ArrayList<>();
        while (true) {
            list = LAPTOP_REPOSITORY.getAll(page * size, size);
            if (list == null) {
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

    @SneakyThrows
    @Transactional
    @Override
    public Laptop detail(String id) {
        Laptop laptop = LAPTOP_REPOSITORY.detail(id);
        if (Objects.isNull(laptop)) {
            throw new Exception("Không tìm thấy laptop");
        }
        return laptop;
    }

    @Override
    public int pageSizeLaptop() {
        int size = LAPTOP_REPOSITORY.countPageLaptop();
        if (size % 10 == 0) {
            return size / 10;
        } else {
            return size / 10 + 1;
        }

    }

    @Override
    public int pageSizeLaptopDetail(String id) {
        int size = LAPTOP_REPOSITORY.countPageLaptopDetail(id);
        if (size % 10 == 0) {
            return size / 10;
        } else {
            return size / 10 + 1;
        }
    }

    @Override
    public List<LaptopDetail> getListDetailByLaptopId(String id, int page) {
        int size = 10;
        page = page - 1;

        List<LaptopDetail> list = new ArrayList<>();
        while (true) {
            list = LAPTOP_REPOSITORY.getLaptopDetailsByLaptopId(id, page, size);
            if (list == null) {
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
}
