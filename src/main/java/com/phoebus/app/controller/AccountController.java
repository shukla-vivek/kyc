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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/int/kyc/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "getAccountByCustomerId", nickname = "getAccountByCustomerId", response = Account.class,responseContainer = "Set",
		          tags = {"Accounts" })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = Account.class,responseContainer = "Set"),
    		                @ApiResponse(code = 400, message = "Input mismatch"),                
    		                @ApiResponse(code = 500, message = "Problem occured while serving the request") })
    @GetMapping
    public Set<Account> getAccountByCustomerId(@RequestParam(value = "customerId") List<String> customerIds) {
        return accountService.getAccountByCustomerId(customerIds);
    }
    
    


}
