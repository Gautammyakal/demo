package com.app.service;

import java.util.List;

import com.app.dto.EmployeeDTO;
import com.app.entities.Employee;

public interface IEmployeeService {
//get all emps
	List<Employee> getAllEmpDetails();
	//save new emp details
	EmployeeDTO saveEmpDetails(EmployeeDTO emp);
	//delete emp details
	String deleteEmpDetails(int empId);
	//get emp details by specified id
	Employee getEmpDetails(int empId);
	//update existing emp details
	Employee  updateEmpDetails(Employee updatedDetachedEmp);
}
