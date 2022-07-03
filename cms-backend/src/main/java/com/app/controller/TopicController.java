package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TopicDTO;
import com.app.service.ITopicService;

@RestController
@RequestMapping("/topics")
public class TopicController {
	// dep : topic service
	@Autowired
	private ITopicService topicService;

	public TopicController() {
		System.out.println("in ctro of " + getClass());
	}

	// add REST API end point to add topic
	@PostMapping
	public ResponseEntity<?> addNewTopic(@RequestBody @Valid TopicDTO topic) {
		System.out.println("in add new topic " + topic);
		return ResponseEntity.status(HttpStatus.CREATED).body(topicService.addTopic(topic));
	}

}
