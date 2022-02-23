package br.com.letscode.todolist.controller;

import br.com.letscode.todolist.model.Task;
import br.com.letscode.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    private ResponseEntity<List<Task>> listAll() {
        return ResponseEntity.ok(taskService.listAll());
    }

    @PostMapping
    private ResponseEntity<Task> save(@RequestBody Task task) {
        return new ResponseEntity<Task>(taskService.save(task), HttpStatus.CREATED);
    }
}
