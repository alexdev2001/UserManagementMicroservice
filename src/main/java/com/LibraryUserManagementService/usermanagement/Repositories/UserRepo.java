package com.LibraryUserManagementService.usermanagement.Repositories;

import com.LibraryUserManagementService.usermanagement.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long userID);

    Optional<User> findByUsername(String username);
}
