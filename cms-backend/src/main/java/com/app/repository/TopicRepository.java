package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
