package com.live.practicaapirest.repository;

import com.live.practicaapirest.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
