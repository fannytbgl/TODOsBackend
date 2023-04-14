package com.example.backApplication.dto;

import com.example.backApplication.enums.StatusType;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToDoDto {
    private Long id;
    private String title;
    private StatusType statusType;
    private String description;
    private LocalDate dateOfCreation;

}
