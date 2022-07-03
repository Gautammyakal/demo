package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="topics")
@Getter
@Setter
public class Topic extends BaseEntity{
	
	private String topicName;
}
