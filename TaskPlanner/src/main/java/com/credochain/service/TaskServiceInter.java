package com.credochain.service;

import java.util.List;

import com.credochain.model.Task;

public interface TaskServiceInter {
	public Task createTask(Task task);
	public List<Task> listOfAllTask();
	public Task updateTask(Task task,int taskid);
	public Task assignTask(int taskid,String assignto);
}
