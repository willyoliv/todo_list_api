package br.com.letscode.todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequesException extends RuntimeException {
    public BadRequesException(String message) {
        super(message);
    }
}
