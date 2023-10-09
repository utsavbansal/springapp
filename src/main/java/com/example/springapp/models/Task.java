package com.example.springapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@AllArgsConstructor
@Data
public class Task {
    private int id;
    private String name;
    private boolean completed;
    private Date dueBy;
}
