package br.com.letscode.todolist.repository;

import br.com.letscode.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findByIdAndUserId(Integer id, UUID userId);

    List<Task> findByUserId(UUID userId);
}
