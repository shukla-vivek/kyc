package com.phoebus.app.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoebus.app.entity.Account;
import com.phoebus.app.entity.Customer;
import com.phoebus.app.repository.AccountRepository;
import com.phoebus.app.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Set<Account> getAccountByCustomerId(List<String> customerIds){

        return accountRepository.findAllByCustomersIn(prepareCustomer(customerIds));
    }

    private Set<Customer> prepareCustomer(List<String> customerIds) {
    	Set<Customer> set=new HashSet<>();
    	customerIds.stream().forEach(id -> {
    		Customer cust=new Customer();
        	cust.setCustomerId(id);
        	set.add(cust);
        });
        return set;
	}

	
}
