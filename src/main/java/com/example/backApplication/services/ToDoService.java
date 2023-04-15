package com.example.backApplication.services;

import com.example.backApplication.dto.ToDoDto;

import java.util.List;

public interface ToDoService {

    /**
     * find all toDo
     * @return list of toDo
     */
    List<ToDoDto> findAll();

    /**
     * add one new toDo
     * @param toDoDto
     * @return toDo completed (id, default values)
     */
    ToDoDto add(ToDoDto toDoDto);
}
