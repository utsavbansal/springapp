package com.example.springapp.controllers;

import com.example.springapp.dto.TasksResponse;
import com.example.springapp.services.TaskServiceImpl;
import com.example.springapp.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {
  //  @Autowired private TasksService tasksService;
    private TasksService tasksService;

   /* public TasksController() {
        this.tasksService=new TaskServiceImpl();
    }
*/

    @Autowired
    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }
    @GetMapping("")
    public TasksResponse getAllTasks()
    {
        var tasks=tasksService.getAllTasks();
        return new TasksResponse(tasks,tasks.size());
    }
    @GetMapping("/{id}")
    public String getTaskById(@PathVariable("id") String id)
    {
        return "TODO: Task with id " + id;
    }
}
