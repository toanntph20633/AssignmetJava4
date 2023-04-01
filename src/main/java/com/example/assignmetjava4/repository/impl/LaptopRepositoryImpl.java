package com.example.assignmetjava4.repository.impl;

import com.example.assignmetjava4.entity.Account;
import com.example.assignmetjava4.entity.Laptop;
import com.example.assignmetjava4.repository.LaptopRepository;
import com.example.assignmetjava4.utilities.HibernateUtil;
import com.example.assignmetjava4.utilities.LaptopStatus;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class LaptopRepositoryImpl implements LaptopRepository {
    @Override
    public List<Laptop> getAll(int page, int size) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select l from laptop l where l.status =:status ");
            query.setParameter("status", LaptopStatus.ACTIVE);
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Laptop getOne(String id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(" from laptop l where l.id =:id");
            query.setParameter("id", id);
            return (Laptop) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Laptop> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(" from laptop b where b.status =:status");
            query.setParameter("status", LaptopStatus.ACTIVE);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        LaptopRepository laptopRepository = new LaptopRepositoryImpl();
        int size = 4;
        List<Laptop> list = new ArrayList<>();
        while (true) {
            list = laptopRepository.getAll(0 * size, size);
            if (!list.isEmpty()) {
                break;
            }
            size--;
            if (size < 0) {
                break;
            }
        }
        System.out.println(list);
    }
}
