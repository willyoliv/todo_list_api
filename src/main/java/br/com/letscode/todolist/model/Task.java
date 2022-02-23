package br.com.letscode.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private State state;

    @CreatedDate
    private Date createdAt = new Date();

    @LastModifiedDate
    private Date updateAt = new Date();

    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
    private List<Comment> comments;
}
