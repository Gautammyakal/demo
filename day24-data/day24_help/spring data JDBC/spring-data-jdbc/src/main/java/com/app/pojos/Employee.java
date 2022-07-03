package com.app.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table("emps")
@Setter
@Getter
@ToString
public class Employee {
	@Id
	@Column("emp_id")
	private Integer id;
	private String name;
	private double salary;

	

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}


	
}
