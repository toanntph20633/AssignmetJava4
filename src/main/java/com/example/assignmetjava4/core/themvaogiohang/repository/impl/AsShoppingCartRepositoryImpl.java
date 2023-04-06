package com.example.assignmetjava4.core.themvaogiohang.repository.impl;

import com.example.assignmetjava4.core.themvaogiohang.entity.respone.GioHangResList;
import com.example.assignmetjava4.core.themvaogiohang.repository.AsDetailShoppingCartRepository;
import com.example.assignmetjava4.core.themvaogiohang.repository.AsShoppingCartRepository;
import com.example.assignmetjava4.utilities.HibernateUtil;
import com.example.assignmetjava4.utilities.ShoppingCartStatus;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;

import java.util.List;

public class AsShoppingCartRepositoryImpl implements AsShoppingCartRepository, AsDetailShoppingCartRepository {

    @Override
    public void save() {

    }

    @Transactional
    @Override
    public List<GioHangResList> getListGioHang(String idUser) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select new com.example.assignmetjava4.core.themvaogiohang.entity.respone.GioHangResList(" +
                    "o.id,o.laptopId.id,o.laptopId.brandId.brandName,o.customerId.id,o.laptopId.images,o.laptopId.laptopName,o.quantity,o.laptopId.price)  from ShoppingCart o " +
                    "where o.status = :status and o.customerId.id = :id", GioHangResList.class);

            query.setParameter("status", ShoppingCartStatus.CHOTHANHTOAN);
            query.setParameter("id", idUser);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        AsShoppingCartRepository repository = new AsShoppingCartRepositoryImpl();
        System.out.println(repository.getListGioHang("595EEEA5-FCFC-44AC-8B54-84C9C5491EC8"));
    }
}
