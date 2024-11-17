package com.example.Service;

package com.example.service;

import com.example.model.Admin;
import com.example.model.Assignment;
import com.example.repository.AdminRepository;
import com.example.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Admin register(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin login(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null; // or throw an exception
    }

    public List<Assignment> getAssignments(String adminId) {
        return assignmentRepository.findByAdminId(adminId);
    }

    public void acceptAssignment(String assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId).orElse(null);
        if (assignment != null) {
            assignment.setStatus("ACCEPTED");
            assignmentRepository.save(assignment);
        }
    }

    public void rejectAssignment(String assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId).orElse(null);
        if (assignment != null) {
            assignment.setStatus("REJECTED");
            assignmentRepository.save(assignment);
        }
    }
}