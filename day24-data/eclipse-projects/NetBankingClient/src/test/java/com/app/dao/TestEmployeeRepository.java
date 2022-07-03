package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Employee;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestEmployeeRepository {
	@Autowired
	private EmployeeRepository repo;
	

	@Test
	void test() {
		assertNotNull(repo);
	}
	@Test
	void testFindBySalaryGreaterThan() {
		List<Employee> emps = repo.findBySalaryGreaterThan(10000);
		emps.forEach(System.out::println);
		assertEquals(2,emps.size());
	}
	@Test
	void testFindByDepartmentAndWorkLocation() {
		List<Employee> emps = repo.findByDepartmentAndWorkLocation("Finance", "Delhi");
		emps.forEach(System.out::println);
		assertEquals(2,emps.size());
	}
	@Test
	@Rollback(false)
	void testUpdateEmpSalaryByDept() {
		int count = repo.updateEmpSalaryByDept(1000,"RnD");
		assertEquals(2, count);
	}

}
