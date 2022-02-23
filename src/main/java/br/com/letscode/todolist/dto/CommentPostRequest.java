package br.com.letscode.todolist.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CommentPostRequest {
    @NotNull(message = "O texto não pode ser nulo!")
    private String text;
}
