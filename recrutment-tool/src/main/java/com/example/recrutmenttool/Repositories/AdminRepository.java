package com.example.recrutmenttool.Repositories;

import com.example.recrutmenttool.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Optional<Admin>findAdminByUsername(String username);
    Optional<Admin>findAdminByEmail(String email);

}
