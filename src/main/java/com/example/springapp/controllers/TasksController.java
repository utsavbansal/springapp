package com.example.springapp.controllers;

import com.example.springapp.dto.ErrorResponse;
import com.example.springapp.dto.SuccessResponse;
import com.example.springapp.dto.TasksResponse;
import com.example.springapp.models.Task;
import com.example.springapp.services.TaskServiceImpl;
import com.example.springapp.services.TasksService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/tasks")
public class TasksController {
   @Autowired private TasksService tasksService;
  //  private TasksService tasksService;

   /* public TasksController() {
        this.tasksService=new TaskServiceImpl();
    }
*/

    /*@Autowired
    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

     */
    @GetMapping("")
    public ResponseEntity<TasksResponse> getAllTasks()
    {
        var tasks=tasksService.getAllTasks();
        return ResponseEntity.ok(new TasksResponse(tasks,tasks.size()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id)
    {
        var task=tasksService.getTaskById(id);
        return ResponseEntity.ok(task);
        //return "TODO: Task with id " + id;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteTaskById(@PathVariable("id") Integer id)
    {
        tasksService.deleteTask(id);
        return ResponseEntity.accepted().body(new SuccessResponse("Task no "+id+" deleted"));
        //return "TODO: Delete Task no= "+id;
    }

    @PostMapping("")
    public String createTask(@PathVariable("id") String task)
    {
        return "TODO: Create Task no= "+task;
    }

    @PatchMapping("/{id}")
    public String updateTask(@PathVariable("id") String id,@RequestBody String task)
    {
        return "TOOD : Update task no= "+id+" with task= "+task;
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception ex)
    {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND
        );
    }

}
