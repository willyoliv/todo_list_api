package br.com.letscode.todolist.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    private State state;

    private Date createdAt;

    private Date updateAt;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @PrePersist
    public void preSave() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updateAt = new Date();
    }
}
