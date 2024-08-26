package com.LibraryUserManagementService.usermanagement.Controllers;

import com.LibraryUserManagementService.usermanagement.Models.User;
import com.LibraryUserManagementService.usermanagement.Repositories.UserRepo;
import com.LibraryUserManagementService.usermanagement.Services.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/usermanagement/")
public class UserController {
    @Autowired
    CRUDService crudService;

    @Autowired
    UserRepo userRepo;


    // create a user
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        crudService.createUser(user);
        return ResponseEntity.ok(user);
    }

    // retetrieve a user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));
        return ResponseEntity.ok(user);
    }

    // update user
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User userDetails) {
        crudService.updateUser(id, userDetails);
        return ResponseEntity.ok(userDetails);
    }

    // delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        crudService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
