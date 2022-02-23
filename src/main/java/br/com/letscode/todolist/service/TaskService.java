package br.com.letscode.todolist.service;

import br.com.letscode.todolist.exception.BadRequesException;
import br.com.letscode.todolist.model.Comment;
import br.com.letscode.todolist.model.Task;
import br.com.letscode.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task findById(int id) {
        return taskRepository.findById(id).orElseThrow(() -> new BadRequesException("Task not found"));
    }
}
