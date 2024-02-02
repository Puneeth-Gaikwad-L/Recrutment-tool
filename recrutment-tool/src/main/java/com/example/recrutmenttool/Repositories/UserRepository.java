package com.example.recrutmenttool.Repositories;

import com.example.recrutmenttool.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmailId(String emailId);

    public User findByUsername(String username);
}
