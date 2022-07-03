package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comments", uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "tut_id" }))
@Getter
@Setter
public class Comment extends BaseEntity {
	@Column(length = 300)
	private String comment;
	// User 1<-----* Comment : uni dir asso bet User n Comment
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	// Tutorial 1<------>* Comment : bi dir asso
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tut_id")
	private Tutorial tutorial;
}
