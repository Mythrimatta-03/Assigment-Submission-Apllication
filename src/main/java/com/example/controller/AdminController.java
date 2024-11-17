package com.example.controller;
package com.example.controller;

import com.example.model.Admin;
import com.example.model.Assignment;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<Admin> register(@RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.register(admin));
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestParam String username, @RequestParam String password) {
        Admin admin = adminService.login(username, password);
        return admin != null ? ResponseEntity.ok(admin) : ResponseEntity.status(401).build();
    }

    @GetMapping("/assignments")
    public ResponseEntity<List<Assignment>> getAssignments(@RequestParam String adminId) {
        return ResponseEntity.ok(adminService.getAssignments(adminId));
    }

    @PostMapping("/assignments/{id}/accept")
    public ResponseEntity<Void> acceptAssignment(@PathVariable String id) {
        adminService.acceptAssignment(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/assignments/{id}/reject")
   