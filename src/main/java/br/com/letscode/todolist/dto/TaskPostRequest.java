package br.com.letscode.todolist.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class TaskPostRequest {
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
}
