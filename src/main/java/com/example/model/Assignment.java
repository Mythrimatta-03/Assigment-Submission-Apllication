package com.example.model;

import org.springframework.data.annotation.Id;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Document(collection = "assignments")
@Getter
@Setter
public class Assignment {
    @Id
    private String id;
    private String userId;
    private String task;
    private String adminId;
    private LocalDateTime submittedAt;
    private String status; 

    
}