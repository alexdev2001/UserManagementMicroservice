package com.LibraryUserManagementService.usermanagement.Services;

import com.LibraryUserManagementService.usermanagement.Models.User;
import com.LibraryUserManagementService.usermanagement.Repositories.RoleRepo;
import com.LibraryUserManagementService.usermanagement.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CRUDService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public CRUDService(UserRepo userRepo) {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // create book
    public User createUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepo.save(user);
    }

    // retrieve book by id
    public Optional<User> retrieveUser(Long id) {
        return userRepo.findById(id);
    }

    // update user
    public User updateUser(Long id, User userDetails) {
        User libUser = userRepo.findById(id).
                orElseThrow(() -> new RuntimeException("user not found"));

        libUser.setUsername(userDetails.getUsername());
        libUser.setPassword(userDetails.getPassword());
        libUser.setMembership_date(userDetails.getMembership_date());
        libUser.setRole(userDetails.getRole());

        return userRepo.save(libUser);

    }

    // delete user by id
    public void deleteUser(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));
        userRepo.delete(user);

    }

}
