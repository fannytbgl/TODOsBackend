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

    @Autowired
    private ModelMapper modelMapper ;

    public ToDoService() {
    }

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
        var toDoEntity = modelMapper.map(toDoDto, ToDo.class);
        this.toDoRepository.save(toDoEntity);
        return modelMapper.map(toDoEntity, ToDoDto.class);
    }
}
