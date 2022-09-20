package com.credochain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credochain.model.Task;
import com.credochain.repository.TaskRepo;
@Service
public class TaskServiceImpl implements TaskServiceInter {
	@Autowired
	TaskRepo taskrepo;
	private Task task;
	@Override
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		return taskrepo.save(task);
	}
	@Override
	public List<Task> listOfAllTask() {
		// TODO Auto-generated method stub
		return taskrepo.findAll();
	}
	//Update task change it's status
	@Override
	public Task updateTask(Task task1, int taskid) {
		Task task=taskrepo.findByTaskid(taskid);
		task.setStatus(task1.getStatus());
		task.setTitle(task1.getTitle());
		return taskrepo.save(task);
		}
	//Assign task to other
	@Override
	public Task assignTask(int taskid, String assignto) {
		// TODO Auto-generated method stub

		Task task=this.taskrepo.findByTaskid(taskid);
		task.setAssignedTo(assignto);
		System.out.println("assign to........."+assignto);
		return taskrepo.save(task);
	}


}
