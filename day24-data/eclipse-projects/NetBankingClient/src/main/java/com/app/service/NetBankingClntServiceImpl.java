package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.EmployeeRepository;
import com.app.dto.BankAcctDTO;
import com.app.dto.EmpBankAcctDTO;
import com.app.entities.Employee;

@Service
@Transactional // only for accessing emp details form the local db
public class NetBankingClntServiceImpl implements INetBankingClntService {
	// dep : emp repo
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private ModelMapper mapper;

	// inject value of the url
	@Value("${REST.GET}")
	private String getURL;

	// dep : synchronous rest clnt : RestTemplate
	private RestTemplate restTemplate;

	@Autowired // ctor based D.I : to inject rest template builder --to create rest template
	public NetBankingClntServiceImpl(RestTemplateBuilder builder) {
		restTemplate = builder.build();
		System.out.println("rest template "+restTemplate);
	}

	@Override
	public EmpBankAcctDTO fetchAccountDetails(int empId, int acctNo) {
		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid emp id !!!"));
		System.out.println("emp details "+emp);
		// valid emp --now proceed to making a REST call to banking server
		// API of RestTemplate : public T ResponseEntity<T> getForEntity(String url,
		// Class<T> resp ,
		// Object ... pathVars)
		BankAcctDTO acctDTO = restTemplate.getForEntity(getURL, BankAcctDTO.class, acctNo).getBody();
		//send back emp name + bank acct details
		 EmpBankAcctDTO empBankAcctDTO = mapper.map(acctDTO, EmpBankAcctDTO.class);
		 empBankAcctDTO.setEmpName(emp.getName());
		 return empBankAcctDTO;

		
	}

}
