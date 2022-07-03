package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sec_users")
@Getter
@Setter
@ToString(exclude ="userRoles")
public class UserEntity extends BaseEntity{
	
	@Column(length = 20)
	private String userName;
	@Column(length = 20, unique = true)
	private String email;
	@Column(length = 350)
	private String password;
	// many-to-many , User *--->* Role
	@ManyToMany
	@JoinTable(name = "users_roles", 
	joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> userRoles = new HashSet<>();

}
