package com.example.assignmetjava4.service;

import com.example.assignmetjava4.entity.Account;
import com.example.assignmetjava4.entity.Role;

public interface AccountService {
    Account login(String userName, String password) throws Exception;
    Role getAdmin(String id);
}
