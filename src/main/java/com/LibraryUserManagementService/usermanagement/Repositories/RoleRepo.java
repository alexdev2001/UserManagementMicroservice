package com.LibraryUserManagementService.usermanagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.LibraryUserManagementService.usermanagement.Models.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
    @Override
    Optional<Role> findById(Long roleID);

    Optional<Role> findByName(String name);
}
