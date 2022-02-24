package br.com.letscode.todolist.service;

import br.com.letscode.todolist.config.UserContext;
import br.com.letscode.todolist.dto.CommentPostRequest;
import br.com.letscode.todolist.dto.TaskPostRequest;
import br.com.letscode.todolist.exception.TaskNotFoundException;
import br.com.letscode.todolist.model.Comment;
import br.com.letscode.todolist.model.State;
import br.com.letscode.todolist.model.Task;
import br.com.letscode.todolist.repository.CommentRepository;
import br.com.letscode.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;
    private final UserContext userContext;

    public List<Task> listAllTasksByUserId() {
        var userId = userContext.getUserId();
//        UUID userId = UUID.randomUUID();
        return taskRepository.findByUserId(userId);
    }

    @Transactional
    public Task saveTask(TaskPostRequest taskPostRequest) {
        var userId = userContext.getUserId();
        System.out.println(userId);
        Task task = Task.builder()
                .userId(userId)
                .title(taskPostRequest.getTitle())
                .description(taskPostRequest.getDescription())
                .state(State.CREATED)
                .build();

        return taskRepository.save(task);
    }

    public Task findTaskById(Integer id) {
        var userId = userContext.getUserId();
//        UUID userId = UUID.randomUUID();
        return taskRepository.findByIdAndUserId(id, userId).orElseThrow(() -> new TaskNotFoundException("Task not found"));
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
