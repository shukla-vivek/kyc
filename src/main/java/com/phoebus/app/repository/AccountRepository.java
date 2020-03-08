package com.phoebus.app.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.phoebus.app.entity.Account;
import com.phoebus.app.entity.Customer;


public interface AccountRepository extends CrudRepository <Account, String> {

     Set<Account>  findAllByCustomersIn(Set<Customer> customer);
     
     
}
