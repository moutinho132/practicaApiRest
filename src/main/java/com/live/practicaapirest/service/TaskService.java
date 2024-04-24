package com.live.practicaapirest.service;

import com.live.practicaapirest.mapper.TaskMapper;
import com.live.practicaapirest.model.TaskDto;
import com.live.practicaapirest.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    /**
     *
     * @return
     */
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream().map(taskMapper::entityToDto)
                .collect(Collectors.toUnmodifiableList());
    }
    /**
     *
     * @param id
     * @return
     */
    public TaskDto getTaskById(Long id) {
        AtomicReference<TaskDto> dto = new AtomicReference<>();
        taskRepository.findById(id).ifPresent(task -> dto.set(taskMapper.entityToDto(task)));
        return dto.get();
    }
    /**
     *
     * @param taskDto
     * @return
     */
    public TaskDto addTask(TaskDto taskDto) {
        return taskMapper.entityToDto(taskRepository.save(taskMapper.dtoToEntity(taskDto)));
    }
    /**
     *
     * @param taskDto
     * @return
     */
    public TaskDto updateTask(TaskDto taskDto) {
        return taskMapper.entityToDto(taskRepository.save(taskMapper.dtoToEntity(taskDto)));
    }
}
