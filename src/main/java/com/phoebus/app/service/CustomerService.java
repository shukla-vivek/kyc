package com.phoebus.app.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.phoebus.app.dto.CustomerAccountDTO;
import com.phoebus.app.entity.Customer;

public interface CustomerService {

    public Set<Customer>  getCustomerByAccountId(List<String> accountId);

    public Customer addCustomer(CustomerAccountDTO customerDTO);

	public boolean matchCustomerAccountDetails (CustomerAccountDTO customerDTO);
}
