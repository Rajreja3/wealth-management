package com.example.wealthmanagement.repo;

import com.example.wealthmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u where u.email=?1")
    User findByEmail(String email);
}
