package com.app.entities;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//salary , joinDate , lastName (Treat earlier name as first name : unique),password,email

@Getter
@Setter
@ToString
@Entity
@Table(name = "emps")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer empId;
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String lastName;
	@Column(length = 30)

	private String email;
	@Column(length = 30)

	private String password;
	@Column(length = 30)

	private String department;

	@Column(length = 30)

	private String workLocation;

	private double salary;

	private LocalDate joinDate;
	//add a property to specify image name / path
	@Column(length = 300)
	private String imagePath;// replace it byte[] : for stroing images : BLOB 

}
