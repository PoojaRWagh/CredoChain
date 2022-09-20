package com.credochain.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.credochain.model.Task;
import com.credochain.repository.TaskRepo;
import com.credochain.service.TaskServiceImpl;
@EnableMongoRepositories(basePackages = {"com.credochain.repository"})
@RequestMapping("/tasks")
@RestController
public class MyController {
	@Autowired
private TaskServiceImpl taskserviceimpl;
	@PostMapping("/")
	public ResponseEntity<Task> NewTask(@RequestBody Task task)
	{
		task.setCompletedon(LocalDate.now());
		return ResponseEntity.ok(this.taskserviceimpl.createTask(task));
	}
	@GetMapping("/alltask")
	public List<Task> AllTask()
	{
		return taskserviceimpl.listOfAllTask();
	}
	@PostMapping("/update/{taskid}")
	public Task update(@RequestBody Task task,@PathVariable int taskid)
	{
		taskserviceimpl.updateTask(task, taskid);
		return task;
	}
	@PostMapping("/assign/{id}")
	public void assign(@PathVariable int id,@RequestBody String assignto )
	{
		taskserviceimpl.assignTask(id,assignto);
	}
	
}
