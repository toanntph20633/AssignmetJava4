package com.example.assignmetjava4.entity;

import com.example.assignmetjava4.utilities.StatusAccount;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@Entity(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private StatusAccount statusAccount;
}
