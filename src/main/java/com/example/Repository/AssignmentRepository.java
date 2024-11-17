package com.example.Repository;


import com.example.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    List<Assignment> findByAdminId(String adminId);
    List<Assignment> findByUser Id(String userId);
}