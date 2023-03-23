package com.example.assignmetjava4.repository;

import com.example.assignmetjava4.entity.Account;

public interface AccountRepository {
    Account getAcountByUserName(String userName);
}
