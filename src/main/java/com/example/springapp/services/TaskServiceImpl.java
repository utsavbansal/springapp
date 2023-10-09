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
    public Task getTaskById(int id) {

        for(Task t:taskList)
        {
            if(t.getId()==id)
                return t;
        }
        return null;
    }

    @Override
    public Task createTask(Task task) {
        Task t=new Task(task.getId(),task.getName(),task.isCompleted(),new Date());

        return t;
    }

    @Override
    public Task updateTask(int id, Task task) {

        for(Task t:taskList)
        {
            if(t.getId()==id)
            {
                t.setName(task.getName());
                t.setCompleted(task.isCompleted());
                t.setDueBy(task.getDueBy());
                return t;
            }
        }

        return null;
    }

    @Override
    public void deleteTask(int id) {
        for(int i=0;i<taskList.size();i++)
        {
            Task t=taskList.get(i);
            if(t.getId()==id)
                taskList.remove(i);
        }

    }
}
