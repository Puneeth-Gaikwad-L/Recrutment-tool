package com.example.recrutmenttool.Repositories;

import com.example.recrutmenttool.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmailId(String emailId);

//    public User findByUsername(String username);
    public Optional<User> findByUsername(String username);

}
