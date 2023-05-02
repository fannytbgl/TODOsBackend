package com.example.backApplication.components;

import com.example.backApplication.dto.ToDoDto;
import com.example.backApplication.entities.ToDo;
import com.example.backApplication.enums.StatusType;
import org.springframework.stereotype.Component;

@Component
public class ToDoMapper {
    public static ToDoDto convertToDto(ToDo toDo) {
        ToDoDto toDoDto = new ToDoDto();
        toDoDto.setId(toDo.getId());
        toDoDto.setTitle(toDo.getTitle());
        toDoDto.setStatusType(toDo.getStatusType());
        toDoDto.setDescription(toDo.getDescription());
        toDoDto.setDateOfCreation(toDo.getDateOfCreation());
        return toDoDto;
    }

    public ToDo convertToEntity(ToDoDto toDoDto) {
        ToDo toDo = new ToDo();
        toDo.setId(toDoDto.getId());
        toDo.setTitle(toDoDto.getTitle());
        toDo.setStatusType(toDoDto.getStatusType());
        toDo.setDescription(toDoDto.getDescription());
        toDo.setDateOfCreation(toDoDto.getDateOfCreation());
        return toDo;
    }
}
