package com.example.noteapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.noteapp.model.UserNote;

@Repository
public interface UserRepository extends JpaRepository<UserNote, Integer>{
	Optional<UserNote> findByEmail(String email);
}
