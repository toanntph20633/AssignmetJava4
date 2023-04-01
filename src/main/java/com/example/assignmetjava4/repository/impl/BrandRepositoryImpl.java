package com.example.assignmetjava4.repository.impl;

import com.example.assignmetjava4.entity.Brand;
import com.example.assignmetjava4.repository.BrandRepository;
import com.example.assignmetjava4.utilities.BrandStatus;
import com.example.assignmetjava4.utilities.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class BrandRepositoryImpl implements BrandRepository {
    @Override
    public List<Brand> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select b from brand b where b.status = :status");
            query.setParameter("status", BrandStatus.ACTIVE.getValue());
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
