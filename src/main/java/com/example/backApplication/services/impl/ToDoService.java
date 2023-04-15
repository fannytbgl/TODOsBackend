package com.example.backApplication.services.impl;

import com.example.backApplication.dto.ToDoDto;
import com.example.backApplication.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService implements com.example.backApplication.services.ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    // we override the method in attempt to return dto
    @Override
    public List<ToDoDto> findAll() {
        return null;
    }

    @Override
    public ToDoDto add(ToDoDto toDoDto) {
        return null;
    }
}
