package br.com.letscode.todolist.controller;

import br.com.letscode.todolist.dto.CommentPostRequest;
import br.com.letscode.todolist.dto.TaskPostRequest;
import br.com.letscode.todolist.model.Comment;
import br.com.letscode.todolist.model.Task;
import br.com.letscode.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    private ResponseEntity<List<Task>> listAll() {
        return ResponseEntity.ok(taskService.listAllTasksByUserId());
    }

    @PostMapping
    private ResponseEntity<Task> save(@RequestBody @Valid TaskPostRequest taskPostRequest) {
        return new ResponseEntity<>(taskService.saveTask(taskPostRequest), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<Task> findByTaskId(@PathVariable Integer id) {
        return new ResponseEntity<>(taskService.findTaskById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(path = "/{id}/comment")
    private ResponseEntity<Comment> addComment(@PathVariable Integer id, @RequestBody @Valid CommentPostRequest commentPostRequest) {
        return new ResponseEntity<>(taskService.saveCommentInTask(id, commentPostRequest), HttpStatus.CREATED);
    }
}
