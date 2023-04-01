package com.example.assignmetjava4.service.impl;

import com.example.assignmetjava4.entity.Account;
import com.example.assignmetjava4.entity.Role;
import com.example.assignmetjava4.entity.RoleAccount;
import com.example.assignmetjava4.repository.AccountRepository;
import com.example.assignmetjava4.repository.RoleAccountRepository;
import com.example.assignmetjava4.repository.RoleRepository;
import com.example.assignmetjava4.repository.impl.AccountRepositoryImpl;
import com.example.assignmetjava4.repository.impl.RoleAccountRepositoryImpl;
import com.example.assignmetjava4.service.AccountService;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private static final AccountRepository ACCOUNT_REPOSITORY = new AccountRepositoryImpl();
    private static final RoleAccountRepository ROLE_ACCOUNT_REPOSITORY = new RoleAccountRepositoryImpl();

    @Override
    public Account login(String userName, String password) throws Exception {
        Account account = ACCOUNT_REPOSITORY.getAcountByUserName(userName);
        if (account == null) {
            throw new Exception("Không tìm thấy");
        }
        if (!account.getPassword().equals(password.trim())) {
            throw new Exception("Mật khẩu không đúng");
        }
        return account;
    }

    @Override
    public Role getAdmin(String id) {
        List<RoleAccount> list = ROLE_ACCOUNT_REPOSITORY.getOneByAccount(id);
        for (RoleAccount r : list) {
            if (r.getRoleId().getRoleName().equalsIgnoreCase("admin")) {
                return r.getRoleId();
            }
        }
        return null;
    }
}
