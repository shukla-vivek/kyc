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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/int/kyc/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "getCustomerByAccountId", nickname = "getCustomerByAccountId",  response = Customer.class,responseContainer = "Set",
	              tags = {"Customer" })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = Customer.class,responseContainer = "Set"),
		                    @ApiResponse(code = 400, message = "Input mismatch"),                
		                    @ApiResponse(code = 500, message = "Problem occured while serving the request") })
    @GetMapping
    public Set<Customer> getCustomerByAccountId(@RequestParam(value = "accountId") List<String> accountIds) {
        return customerService.getCustomerByAccountId(accountIds);
    }

    @ApiOperation(value = "Add a new customer always", nickname = "addAccountWithCustomer",  response = Customer.class,
            tags = {"Customer" })
     @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = Customer.class),
	                    @ApiResponse(code = 400, message = "Input mismatch"),                
	                    @ApiResponse(code = 500, message = "Problem occured while serving the request") })
    @PostMapping(value = "/add-account")
    public Customer addAccountWithCustomer(@Valid @RequestBody CustomerAccountDTO customerDTO) {

        return customerService.addCustomer(customerDTO);

    }
    
    @ApiOperation(value = "match customer and account details", nickname = "matchCustomerAccountDetails",  response = Boolean.class,
            tags = {"Customer" })
     @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = Boolean.class),
	                    @ApiResponse(code = 400, message = "Input mismatch"),                
	                    @ApiResponse(code = 500, message = "Problem occured while serving the request") })
    @PostMapping(value = "/match-customer-account")
    public boolean matchCustomerAccountDetails(@Valid @RequestBody CustomerAccountDTO customerDTO) {
    	return customerService.matchCustomerAccountDetails(customerDTO);
    	
    }
}
