package com.example.assignmetjava4.repository.impl;

import com.example.assignmetjava4.entity.Account;
import com.example.assignmetjava4.repository.AccountRepository;
import com.example.assignmetjava4.utilities.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

public class AccountRepositoryImpl implements AccountRepository {
    @Override
    public Account getAcountByUserName(String userName) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select u from account u where u.userName = :us");
            query.setParameter("us", userName);
            return (Account) query.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepositoryImpl();
        System.out.println(accountRepository.getAcountByUserName("toan8977").getCustomerId().getCusName());
    }
}
