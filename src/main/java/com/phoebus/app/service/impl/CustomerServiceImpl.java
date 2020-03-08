package com.phoebus.app.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoebus.app.dto.CustomerAccountDTO;
import com.phoebus.app.entity.Account;
import com.phoebus.app.entity.Customer;
import com.phoebus.app.repository.AccountRepository;
import com.phoebus.app.repository.CustomerRepository;
import com.phoebus.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Set<Customer>  getCustomerByAccountId(List<String> accountIds) {
        return customerRepository.findAllByAccountsIn(prepareAccounts((accountIds)));
    }

    private Set<Account> prepareAccounts(List<String> accountIds) {
    	Set<Account> set=new HashSet<>();
        accountIds.stream().forEach(id -> {
        	Account account=new Account();
        	account.setAccountId(id);
        	set.add(account);
        });
        return set;
	}

	@Override
    public Customer addCustomer(CustomerAccountDTO customerDTO) {
       
        Customer customer = new Customer();
        customer.setForename(customerDTO.getForename());
        customer.setSurname(customerDTO.getSurname());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        
        Account account = new Account();
        account.setAccountNumber(customerDTO.getAccountNumber());
        
        customer.getAccounts().add(account);
        
        account.getCustomers().add(customer);

        return customerRepository.save(customer);
    }

	@Override
	public boolean matchCustomerAccountDetails(CustomerAccountDTO customerDTO) {
		Optional<List<Customer>> customers = customerRepository.findAllByForenameAndSurnameAndDateOfBirth(customerDTO.getForename(), customerDTO.getSurname(), customerDTO.getDateOfBirth());
		long count=0;
		if(customers.isPresent()) {
			count = customers.get().stream()
					    .map( c-> c.getAccounts())
					    .flatMap(a->a.stream()
					    .filter(p->p.getAccountNumber().equals(customerDTO.getAccountNumber())))
					    .count();
			return count>0?true:false;
		}
		return false;
	}

}
