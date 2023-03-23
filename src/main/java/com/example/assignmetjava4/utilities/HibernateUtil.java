package com.example.assignmetjava4.utilities;

import com.example.assignmetjava4.entity.*;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=ASSJAVA4;encrypt=true;trustServerCertificate=true;");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "sa");
        properties.put(Environment.SHOW_SQL, "true");
        //        gen db tư động
//        properties.put(Environment.HBM2DDL_AUTO, "create");^
        conf.setProperties(properties);
        conf.addAnnotatedClass(Customer.class);
        conf.addAnnotatedClass(Account.class);
        conf.addAnnotatedClass(Bill.class);
        conf.addAnnotatedClass(Brand.class);
        conf.addAnnotatedClass(Laptop.class);
        conf.addAnnotatedClass(LaptopDetail.class);
        conf.addAnnotatedClass(BillDetail.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        try (Session session = getFACTORY().openSession();) {
            Query query = session.createQuery(" from customer ");
            List<Customer> list = query.getResultList();
            if(!list.isEmpty()){
               for (Customer cus: list) {
                   System.out.println(cus.getAccounts().stream().map(account -> account.getUserName()).collect(Collectors.toSet()));
               }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
