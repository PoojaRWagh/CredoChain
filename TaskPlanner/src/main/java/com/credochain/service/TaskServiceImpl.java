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
	List<Long> list=new ArrayList();
	private Task task;
	@Override
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		list.add(task.getTaskid());
		System.out.println("list"+list);
		return taskrepo.save(task);
	}
	@Override
	public List<Task> listOfAllTask() {
		// TODO Auto-generated method stub
		return taskrepo.findAll();
	}
	@Override
	public void updateTask(Task task1, int taskid) {
		for (Long tid : list) {
			if(tid==taskid)
			{
				System.out.println("in if block");
				this.task.setTitle(task1.getTitle());
				this.task.setStatus(task1.getStatus());
			}
			else {
				System.out.println("No such task");
				}
			
		}
		}


}
