package com.example.springapp.dto;

import com.example.springapp.models.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class TasksResponse {
    private List<Task> tasks;
    private int taskCount;

}
