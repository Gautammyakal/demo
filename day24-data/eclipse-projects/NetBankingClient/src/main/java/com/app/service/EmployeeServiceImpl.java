package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EmployeeRepository;
import com.app.dto.EmployeeDTO;
import com.app.entities.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	// dep : emp repo.
	@Autowired
	private EmployeeRepository empRepo;
	// dep : model mapper for mapping dto --- entity
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Employee> getAllEmpDetails() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public EmployeeDTO saveEmpDetails(EmployeeDTO empDto) {
		// map dto --> entity
		Employee employee = mapper.map(empDto, Employee.class);
		//persist emp details in the db
		Employee persistentEmp = empRepo.save(employee);// method rets PERSISTENT emp ref
		// map entity --> dto
		return mapper.map(persistentEmp, EmployeeDTO.class);
	}// in case of no errs : hib auto dirty chking @ session.flush ---tx.commit
		// --inserts rec --L1 cache destroyed -- pooled out db cn rets to the pool
		// --rets DETACHED pojo to the caller

	@Override
	public String deleteEmpDetails(int empId) {
		String mesg = "Deletion of emp details failed!!!!!!!!!!!";

		if (empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			mesg = "Emp details deleted successfully , for emp id :" + empId;
		}

		return mesg;
	}

	@Override
	public Employee getEmpDetails(int empId) {
		// TODO Auto-generated method stub
		Employee employee = empRepo.getById(empId);
		employee.getJoinDate();
		return employee;
		// .orElseThrow(() -> new ResourceNotFoundException("Invalid emp id !!!!!!" +
		// empId));
	}

	@Override
	public Employee updateEmpDetails(Employee updatedDetachedEmp) {
		// TODO Auto-generated method stub
		return empRepo.save(updatedDetachedEmp);
	}

}
