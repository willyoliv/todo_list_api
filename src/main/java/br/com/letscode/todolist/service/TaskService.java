package br.com.letscode.todolist.service;

import br.com.letscode.todolist.dto.CommentPostRequest;
import br.com.letscode.todolist.dto.TaskPostRequest;
import br.com.letscode.todolist.exception.BadRequesException;
import br.com.letscode.todolist.model.Comment;
import br.com.letscode.todolist.model.State;
import br.com.letscode.todolist.model.Task;
import br.com.letscode.todolist.repository.CommentRepository;
import br.com.letscode.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;

    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    public Task saveTask(TaskPostRequest taskPostRequest) {
        Task task = Task.builder()
                .title(taskPostRequest.getTitle())
                .description(taskPostRequest.getDescription())
                .state(State.CREATED)
                .build();

        return taskRepository.save(task);
    }

    public Task findTaskById(int id) {
        return taskRepository.findById(id).orElseThrow(() -> new BadRequesException("Task not found"));
    }

    public void deleteTask(int id) {
        taskRepository.delete(findTaskById(id));
    }

    public Comment saveCommentInTask(Integer taskId, CommentPostRequest commentPostRequest) {
        Task task = findTaskById(taskId);
        Comment comment = Comment.builder()
                .text(commentPostRequest.getText())
                .task(task)
                .build();
        return commentRepository.save(comment);
    }
}
