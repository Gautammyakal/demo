package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicDTO {
	@NotBlank(message = "topic name can't be blank or null")
	private String topicName;
}
