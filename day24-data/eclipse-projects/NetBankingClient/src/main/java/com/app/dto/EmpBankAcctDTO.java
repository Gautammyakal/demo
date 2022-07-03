package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpBankAcctDTO {
	private Integer id;
	private AcctType acctType;
	private double balance;
	private String empName;
	

}
