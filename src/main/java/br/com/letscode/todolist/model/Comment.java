package br.com.letscode.todolist.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @ManyToOne
    @JoinColumn
    @Setter
    private Task task;

    @NotNull(message = "O texto não pode ser nulo!")
    @Getter
    private String text;

    @Getter
    private Date createdAt;

    @Getter
    private Date updateAt;

    @PrePersist
    public void preSave() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updateAt = new Date();
    }
}
