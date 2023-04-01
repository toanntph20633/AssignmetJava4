package com.example.assignmetjava4.core.quanlysanpham.repository.impl;

import com.example.assignmetjava4.core.quanlysanpham.repository.PmBrandRepository;
import com.example.assignmetjava4.entity.Brand;
import com.example.assignmetjava4.utilities.BrandStatus;
import com.example.assignmetjava4.utilities.HibernateUtil;
import com.example.assignmetjava4.utilities.LaptopStatus;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class PmBrandRepositoryImpl implements PmBrandRepository {
    @Override
    public List<Brand> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select l from brand l where l.status =:status ");
            query.setParameter("status", BrandStatus.ACTIVE);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Brand getOne(String id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select l from brand l where l.id =:id ");
            query.setParameter("id", id);
            return (Brand) query.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
