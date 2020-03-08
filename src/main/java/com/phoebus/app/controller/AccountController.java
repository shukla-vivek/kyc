package com.phoebus.app.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phoebus.app.entity.Account;
import com.phoebus.app.service.AccountService;

@RestController
@RequestMapping("/api/int/kyc/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public Set<Account> getAccountByCustomerId(@RequestParam(value = "customerId") List<String> customerIds) {
        return accountService.getAccountByCustomerId(customerIds);
    }
    
    


}
