package com.example.springapp.services;

import com.example.springapp.models.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskServiceImpl implements TasksService{
    private List<Task> taskList;

    public TaskServiceImpl() {
        taskList = new ArrayList<>();
        taskList.add(new Task(1,"sample task ",false,new Date()));
        taskList.add(new Task(2,"another task ",false,new Date()));
        taskList.add(new Task(3,"more tasks ",false,new Date()));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskList;
    }

    @Override
    public Task findTaskById(int id) {
        boolean f=false;
        for(Task t:taskList)
        {
            if(t.getId()==id)
                return t;
        }
        if(!f)
            throw new TaskNotFoundException(id);
        return null;
    }

    @Override
    public Task getTaskById(int id) {
        return findTaskById(id);
    }

    @Override
    public Task createTask(Task task) {
        Task t=new Task(task.getId(),task.getName(),task.isCompleted(),new Date());
        taskList.add(t);
        return t;
    }

    @Override
    public Task updateTask(int id, Task task) {
        Task t=findTaskById(id);
        t.setName(task.getName());
        t.setCompleted(task.isCompleted());
        t.setDueBy(task.getDueBy());
        return t;
    }

    @Override
    public void deleteTask(int id) {
        taskList.remove(findTaskById(id));
    }
}
