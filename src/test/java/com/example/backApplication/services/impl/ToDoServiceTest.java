package com.example.backApplication.services.impl;

import static com.example.backApplication.components.ToDoMapper.*;
import static com.example.backApplication.enums.StatusType.TO_DO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.backApplication.components.ToDoMapper;
import com.example.backApplication.dto.ToDoDto;
import com.example.backApplication.entities.ToDo;
import com.example.backApplication.enums.StatusType;
import com.example.backApplication.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ToDoServiceTest {

    @Mock
    private ToDoRepository toDoRepository;

    @InjectMocks
    private ToDoService toDoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdd() {
        ToDoDto toDoDto = new ToDoDto();
        toDoDto.setTitle("Test ToDo");
        toDoDto.setDescription("This is a test ToDo");

        ToDo toDo = new ToDo();
        toDo.setTitle("Test ToDo");
        toDo.setDescription("This is a test ToDo");

        when(toDoRepository.save(any())).thenReturn(toDo);

        ToDoDto addedToDoDto = toDoService.add(toDoDto);

        assertEquals(toDoDto.getTitle(), addedToDoDto.getTitle());
        assertEquals(toDoDto.getDescription(), addedToDoDto.getDescription());
    }

    @Test
    public void testFindAll() {
        // Create a list of sample ToDo objects
        List<ToDo> toDoList = new ArrayList<>();
        toDoList.add(new ToDo(1L, "Ranger ma chambre", TO_DO, "Très rapidement !", LocalDate.now()));
        toDoList.add(new ToDo(1L, "Promener le chien", TO_DO, "Il fait beau !", LocalDate.now()));

        // Mock the repository's findAll() method to return the sample ToDo list
        Mockito.when(toDoRepository.findAll()).thenReturn(toDoList);

        // Call the service's findAll() method
        List<ToDoDto> result = toDoService.findAll();

        // Verify that the repository's findAll() method was called exactly once
        Mockito.verify(toDoRepository, Mockito.times(1)).findAll();

        // Verify that the size of the returned list is equal to the size of the sample list
        assertEquals(toDoList.size(), result.size());

        // Verify that each item in the returned list has the same properties as the corresponding item in the sample list
        for (int i = 0; i < toDoList.size(); i++) {
            ToDoDto expected = ToDoMapper.convertToDto(toDoList.get(i));
            ToDoDto actual = result.get(i);
            assertEquals(expected.getId(), actual.getId());
            assertEquals(expected.getTitle(), actual.getTitle());
            //assertEquals(expected.getStatusType(), actual.getStatusType());
            assertEquals(expected.getDescription(), actual.getDescription());
            assertEquals(expected.getDateOfCreation(), actual.getDateOfCreation());
        }
    }


}