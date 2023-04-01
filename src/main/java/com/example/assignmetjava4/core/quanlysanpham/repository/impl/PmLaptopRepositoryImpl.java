package com.example.assignmetjava4.core.quanlysanpham.repository.impl;

import com.example.assignmetjava4.core.quanlysanpham.repository.PmLaptopRepository;
import com.example.assignmetjava4.entity.Laptop;
import com.example.assignmetjava4.entity.LaptopDetail;
import com.example.assignmetjava4.utilities.HibernateUtil;
import com.example.assignmetjava4.utilities.LaptopDetailStatus;
import com.example.assignmetjava4.utilities.LaptopStatus;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PmLaptopRepositoryImpl implements PmLaptopRepository {
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
    public List<Laptop> getAll() {
        return null;
    }

    @Override
    public Laptop detail(String id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select l from laptop l where l.id =:id");
            query.setParameter("id", id);
            return (Laptop) query.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(Laptop laptop) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(laptop);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDetail(int soLuong, Laptop laptop) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            for (int i = 0; i < soLuong; i++) {
                LaptopDetail laptopDetail = LaptopDetail.builder().laptopDetailCode(laptop.getLaptopCode() + Math.floor(Math.random() * 1000000000000L)).laptopId(laptop)
                        .status(LaptopDetailStatus.TRONGKHO).build();
                session.merge(laptopDetail);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Laptop laptop) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(laptop);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Laptop laptop) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(laptop);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkMa(String code) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select l from laptop l where l.laptopCode =:code");
            query.setParameter("code", code);
            return query.getResultList().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkMaUpdate(String code, String id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select l from laptop l where l.laptopCode =:code and l.id !=:id");
            query.setParameter("code", code);
            query.setParameter("id", id);
            return query.getResultList().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int countPageLaptop() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select l from laptop l where l.status =:status ");
            query.setParameter("status", LaptopStatus.ACTIVE);
            return query.getResultList().size();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public int countPageLaptopDetail(String id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select l from laptop_detail l where l.laptopId.id =:id and l.status = :status");
            query.setParameter("status", LaptopDetailStatus.TRONGKHO);
            query.setParameter("id", id);
            return query.getResultList().size();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<LaptopDetail> getLaptopDetailsByLaptopId(String id, int page, int size) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select l from laptop_detail l where l.laptopId.id =:id and l.status = :status");
            query.setParameter("status", LaptopDetailStatus.TRONGKHO);
            query.setParameter("id", id);
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
