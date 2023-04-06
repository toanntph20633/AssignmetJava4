package com.example.assignmetjava4.utilities;

import com.example.assignmetjava4.entity.Account;
import com.example.assignmetjava4.entity.Bill;
import com.example.assignmetjava4.entity.BillDetail;
import com.example.assignmetjava4.entity.Brand;
import com.example.assignmetjava4.entity.Customer;
import com.example.assignmetjava4.entity.Laptop;
import com.example.assignmetjava4.entity.LaptopDetail;
import com.example.assignmetjava4.entity.Role;
import com.example.assignmetjava4.entity.RoleAccount;
import com.example.assignmetjava4.entity.ShoppingCart;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

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
        conf.addAnnotatedClass(Account.class);
        conf.addAnnotatedClass(Bill.class);
        conf.addAnnotatedClass(BillDetail.class);
        conf.addAnnotatedClass(Brand.class);
        conf.addAnnotatedClass(Customer.class);
        conf.addAnnotatedClass(Laptop.class);
        conf.addAnnotatedClass(LaptopDetail.class);
        conf.addAnnotatedClass(Role.class);
        conf.addAnnotatedClass(RoleAccount.class);
        conf.addAnnotatedClass(ShoppingCart.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
//        try (Session session = getFACTORY().openSession();) {
//            Query query = session.createQuery(" from customer ");
//            List<Customer> list = query.getResultList();
//            if(!list.isEmpty()){
//               for (Customer cus: list) {
//                   System.out.println(cus.getAccounts().stream().map(account -> account.getUserName()).collect(Collectors.toSet()));
//               }
//           }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println(getFACTORY());
    }
}
