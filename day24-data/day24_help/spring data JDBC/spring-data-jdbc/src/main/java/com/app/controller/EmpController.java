package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.EmpRepository;
import com.app.pojos.Employee;

@RestController
@RequestMapping("/emps")
public class EmpController {
	@Autowired
	private EmpRepository repo;
	@GetMapping
	public List<Employee> listEmps() {
		ArrayList<Employee> emps=new ArrayList<>();
		repo.findAll().forEach(e->emps.add(e));
		System.out.println("populated list "+emps);
		System.out.println(repo.findByFirstName123("Riya"));
		repo.updateSalary(17,2000);
		return emps;
	}
}
