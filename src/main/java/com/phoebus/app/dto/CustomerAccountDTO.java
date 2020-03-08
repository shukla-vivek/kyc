package com.phoebus.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerAccountDTO {

	//@NotEmpty(message = "Please provide a customerId")
    //private String customerId;

	@NotEmpty(message = "Please provide a forename")
    private String forename;

	@NotEmpty(message = "Please provide a surname")
    private String surname;

	@NotNull(message = "Please provide a accountNumber")
    private Integer accountNumber;

	@NotNull(message = "Please provide a dateOfBirth")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate dateOfBirth;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

	/*
	 * public String getCustomerId() { return customerId; }
	 * 
	 * public void setCustomerId(String customerId) { this.customerId = customerId;
	 * }
	 */

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}
}
