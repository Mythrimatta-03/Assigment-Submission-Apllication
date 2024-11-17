package com.example.controller;

package com.example.controller;

import com.example.model.Assignment;
import com.example.model.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.status(401).build();
    }

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadAssignment(@RequestBody Assignment assignment) {
        userService.uploadAssignment(assignment);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/admins")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        
    }
}