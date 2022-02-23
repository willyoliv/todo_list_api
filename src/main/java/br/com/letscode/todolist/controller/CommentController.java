//package br.com.letscode.todolist.controller;
//
//import br.com.letscode.todolist.model.Comment;
//import br.com.letscode.todolist.service.CommentService;
//import javax.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("comments")
//@RequiredArgsConstructor
//public class CommentController {
//
//    private final CommentService commentService;
//
//    @GetMapping
//    private ResponseEntity<List<Comment>> listAll() {
//        return ResponseEntity.ok(commentService.listAll());
//    }
//
//    @PostMapping(path = "{id}")
//    private ResponseEntity<Comment> save(@RequestBody @Valid Comment comment, @PathVariable Integer id) {
//        return new ResponseEntity<>(commentService.save(comment, id), HttpStatus.CREATED);
//    }
//
//    @GetMapping(path = "/{id}")
//    private ResponseEntity<Comment> findById(@PathVariable int id) {
//        return new ResponseEntity<>(commentService.findById(id), HttpStatus.OK);
//    }
//
//    @PutMapping(path = "/{id}")
//    private ResponseEntity<Void> update(@PathVariable int id, @RequestBody Comment comment) {
//        commentService.update(id, comment);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @DeleteMapping(path = "/{id}")
//    private ResponseEntity<Void> delete(@PathVariable int id) {
//        commentService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
