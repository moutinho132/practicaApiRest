package com.live.practicaapirest.mapper;

import com.live.practicaapirest.domain.Task;
import com.live.practicaapirest.model.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto entityToDto(Task task);

    Task dtoToEntity(TaskDto dto);
}
