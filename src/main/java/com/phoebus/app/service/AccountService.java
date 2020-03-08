package com.phoebus.app.service;

import java.util.List;
import java.util.Set;

import com.phoebus.app.entity.Account;

public interface AccountService {

    public Set<Account> getAccountByCustomerId(List<String> customerIds);

}
