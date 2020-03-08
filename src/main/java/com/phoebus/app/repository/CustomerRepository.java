package com.phoebus.app.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoebus.app.entity.Account;
import com.phoebus.app.entity.Customer;

public interface CustomerRepository extends JpaRepository <Customer, String> {

    
    /** supported keywords inside method names" table here: 
     * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation 
     * 
     * Otherwise you will get operator simple_property on requires a scalar argument Exception
     * **/
    Set<Customer>  findAllByAccountsIn(Set<Account> accounts);
    
     Optional<List<Customer>> findAllByForenameAndSurnameAndDateOfBirth(String forename,String surname,LocalDate dateOfBirth);
    
   
    

}
