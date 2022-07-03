package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.TopicDTO;
import com.app.entities.Topic;
import com.app.repository.TopicRepository;

@Service
@Transactional
public class TopicServiceImpl implements ITopicService {
	//dep : repo
	@Autowired
	private TopicRepository topicRepo;
	//dep : mapper
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public TopicDTO addTopic(TopicDTO topicDTO) {
		Topic transientTopic=mapper.map(topicDTO, Topic.class);
		Topic persistentTopic=topicRepo.save(transientTopic);
		return mapper.map(persistentTopic, TopicDTO.class);
	}

}
