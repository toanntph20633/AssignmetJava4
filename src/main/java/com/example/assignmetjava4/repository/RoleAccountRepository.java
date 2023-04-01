package com.example.assignmetjava4.repository;

import com.example.assignmetjava4.entity.RoleAccount;

import java.util.List;

public interface RoleAccountRepository {
    List<RoleAccount> getOneByAccount(String id);
}
