package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "admins")
@Getter
@Setter
public class Admin {
    @Id
    private String id;
    private String username;
    private String password;

    
}