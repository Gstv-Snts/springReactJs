package com.example.demo.TODO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface todoRepository extends JpaRepository<TODO, Long> {
    Optional<TODO> findTodoByTask(String task);
}
