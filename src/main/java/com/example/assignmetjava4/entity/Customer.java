package com.example.assignmetjava4.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "cus_name")
    @Nationalized
    private String cusName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "sex")
    private boolean sex;
    @Column(name = "age")
    private int age;
    @Column(name = "cus_address")
    private String address;
    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private Set<Account> accounts;
    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private Set<Bill> bills;

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", cusName='" + cusName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
