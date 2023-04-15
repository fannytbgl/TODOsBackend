package com.example.backApplication.controller;

import com.example.backApplication.dto.ToDoDto;
import com.example.backApplication.services.impl.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    // endpoint methods
    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<ToDoDto> getAll() {
        return this.toDoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoDto add(@RequestBody ToDoDto toDoDto) {
        return toDoService.add(toDoDto);
    }

}
