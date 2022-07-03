package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sec_roles")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private UserRole roleName;
}
