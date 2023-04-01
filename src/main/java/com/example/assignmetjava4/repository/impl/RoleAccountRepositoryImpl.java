package com.example.assignmetjava4.repository.impl;

import com.example.assignmetjava4.entity.RoleAccount;
import com.example.assignmetjava4.repository.RoleAccountRepository;
import com.example.assignmetjava4.utilities.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class RoleAccountRepositoryImpl implements RoleAccountRepository {
    @Override
    public List<RoleAccount> getOneByAccount(String id) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("select u from role_account u where u.accountId.id = :id");
            query.setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
