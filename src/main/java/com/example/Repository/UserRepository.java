package com.example.Repository;

import com.example.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
