package com.app.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Employee;

public interface EmpRepository extends CrudRepository<Employee, Integer> {
	//pure sql syntax : BUT can use named parameters or positional params ?1 ?2 ....
	//MUST supply table names n column names
	 @Query("select * from emps where name=:firstName")
	    List<Employee> findByFirstName123(@Param("firstName") String firstName123);

	    @Modifying
	    @Query("update emps set salary=salary+:sal where emp_id = :id")
	    boolean updateSalary(@Param("id") int id, @Param("sal") double salary);
}
