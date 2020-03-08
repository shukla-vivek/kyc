package com.phoebus.app.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phoebus.app.dto.CustomerAccountDTO;
import com.phoebus.app.entity.Customer;
import com.phoebus.app.service.CustomerService;

@RestController
@RequestMapping("/api/int/kyc/customer")
public class CustomerController {

    @Autowired

    private CustomerService customerService;

    @GetMapping
    public Set<Customer> getCustomerByAccountId(@RequestParam(value = "accountId") List<String> accountIds) {
        return customerService.getCustomerByAccountId(accountIds);
    }

    @PostMapping(value = "/add-account")
    public Customer addAccountWithCustomer(@Valid @RequestBody CustomerAccountDTO customerDTO) {

        return customerService.addCustomer(customerDTO);

    }
    @PostMapping(value = "/match-customer-account")
    public boolean matchCustomerAccountDetails(@Valid @RequestBody CustomerAccountDTO customerDTO) {
    	return customerService.matchCustomerAccountDetails(customerDTO);
    	
    }
}
