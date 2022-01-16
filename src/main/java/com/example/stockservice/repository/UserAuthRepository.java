package com.example.stockservice.repository;

import com.example.stockservice.model.entity.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuthEntity, Integer> {

    Optional<UserAuthEntity> findByUsername(String username);

}
