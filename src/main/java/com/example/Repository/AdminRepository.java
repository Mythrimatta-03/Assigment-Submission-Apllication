package com.example.Repository;



import com.example.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findByUsername(String username);
}