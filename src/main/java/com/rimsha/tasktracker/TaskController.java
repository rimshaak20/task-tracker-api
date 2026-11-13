package com.rimsha.tasktracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class TaskController {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 3;

    public TaskController() {
        tasks.add(new Task(1, "Study DSA", false));
        tasks.add(new Task(2, "Revise Java", true));
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return tasks;
    }

//    @PostMapping("/tasks")
//    public Task addTask(@RequestBody Task newTask) {
//        Task task = new Task(nextId, newTask.getTitle(), false);
//        nextId++;
//        tasks.add(task);
//        return task;
//    }
    @PostMapping("/tasks")
    public Task addTask(@RequestBody NewTaskRequest request) {
        Task task = new Task(nextId, request.getTitle(), false);
        nextId++;
        tasks.add(task);
        return task;
    }
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody UpdateTaskRequest request) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                if (request.getTitle() != null) {
                    task.setTitle(request.getTitle());
                }
                if (request.getDone() != null) {
                    task.setDone(request.getDone());
                }
                return ResponseEntity.ok(task);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        boolean removed = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                removed = true;
                break;
            }
        }
        if (removed) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
