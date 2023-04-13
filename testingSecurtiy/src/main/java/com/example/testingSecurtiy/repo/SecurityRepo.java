package com.example.testingSecurtiy.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testingSecurtiy.model.UserModel;

@Repository
public interface SecurityRepo extends JpaRepository<UserModel, Integer> {
	Optional<UserModel> findByUsername(String username);
}
