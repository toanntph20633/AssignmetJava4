package com.example.assignmetjava4.service;

import com.example.assignmetjava4.entity.Account;

public interface AccountService {
    Account login(String userName, String password) throws Exception;
}
