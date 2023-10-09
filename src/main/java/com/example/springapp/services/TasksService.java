package com.example.springapp.services;

import com.example.springapp.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TasksService {
    List<Task> getAllTasks();
    Task getTaskById(int id);
    Task createTask(Task task);
    Task updateTask(int id,Task task);
    void deleteTask(int id);

}
