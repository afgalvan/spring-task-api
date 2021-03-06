package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.services.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    public Task saveTask(Task task) {
        return taskService.saveTask(task);
    }

    public Task getById(Long id) {
        return taskService.getById(id).orElse(null);
    }

    public List<Task> getByPriority(Integer priority) {
        return taskService.getByPriority(priority);
    }

    public List<Task> getByState(Boolean state) {
        return taskService.getByState(state);
    }

    public String deleteTask(Long id) {
        Boolean ok = taskService.deleteTask(id);
        if (ok) {
            return "Task successfully deleted";
        }

        return "The task couldn't be deleted";
    }
}
