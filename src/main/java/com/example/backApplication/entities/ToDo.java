package com.example.backApplication.entities;

import com.example.backApplication.enums.StatusType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="todo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusType", nullable = false, length = 10)
    private StatusType statusType;

    @Column(name = "description")
    private String description;

    @Column(name = "dateOfCreation", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfCreation;
}
