package com.example.model;



import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "users")
@Getter
@Setter
public class User {
    @Id
    private String id;
    private String username;
    private String password;

   
}