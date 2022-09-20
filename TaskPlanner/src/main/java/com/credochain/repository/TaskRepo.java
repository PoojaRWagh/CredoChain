package com.credochain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.credochain.model.Task;

public interface TaskRepo extends MongoRepository<Task, Long> {
	Task findByTaskid(int taskid);

}
