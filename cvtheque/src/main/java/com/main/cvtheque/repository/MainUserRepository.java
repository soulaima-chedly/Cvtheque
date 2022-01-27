package com.main.cvtheque.repository;

import com.main.cvtheque.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MainUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);


    boolean existsByUsername(String username);
}
