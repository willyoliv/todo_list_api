package br.com.letscode.todolist.service;

import br.com.letscode.todolist.exception.BadRequesException;
import br.com.letscode.todolist.model.Comment;
import br.com.letscode.todolist.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> listAll() {
        return commentRepository.findAll();
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment findById(int id) {
        return commentRepository.findById(id).orElseThrow(() -> new BadRequesException("Comment not found"));
    }

    public void delete(int id) {
        commentRepository.delete(findById(id));
    }

    public void update(int id, Comment comment) {
        Comment savedComment = findById(id);
        commentRepository.save(comment);
    }
}
