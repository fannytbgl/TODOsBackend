package com.example.backApplication.services.impl;

import com.example.backApplication.entities.ToDo;
import org.modelmapper.ModelMapper;
import com.example.backApplication.dto.ToDoDto;
import com.example.backApplication.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService implements com.example.backApplication.services.ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    // we override the method in attempt to return dto
    @Override
    public List<ToDoDto> findAll() {
        return  toDoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ToDoDto convertToDto(ToDo toDo) {
        ToDoDto toDoDto = new ToDoDto();
        toDoDto.setId(toDo.getId());
        toDoDto.setTitle(toDo.getTitle());
        toDoDto.setDescription(toDo.getDescription());
        toDoDto.setDateOfCreation(toDo.getDateOfCreation());
        return toDoDto;
    }

    @Override
    public ToDoDto add(ToDoDto toDoDto) {
            ToDo toDo = new ToDo();
            toDo.setTitle(toDoDto.getTitle());
            toDo.setStatusType(toDoDto.getStatusType());
            toDo.setDescription(toDoDto.getDescription());
            toDo.setDateOfCreation(toDoDto.getDateOfCreation());

            ToDo savedToDo = toDoRepository.save(toDo);

            ToDoDto savedToDoDto = new ToDoDto();
            savedToDoDto.setId(savedToDo.getId());
            savedToDoDto.setTitle(savedToDo.getTitle());
            savedToDoDto.setStatusType(savedToDo.getStatusType());
            savedToDoDto.setDescription(savedToDo.getDescription());
            savedToDoDto.setDateOfCreation(savedToDo.getDateOfCreation());

            return savedToDoDto;
    }
}
