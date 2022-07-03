package com.app.service;

import org.springframework.http.ResponseEntity;

import com.app.dto.BankAcctDTO;
import com.app.dto.EmpBankAcctDTO;

public interface INetBankingClntService {

	EmpBankAcctDTO fetchAccountDetails(int empId, int acctNo);

}
