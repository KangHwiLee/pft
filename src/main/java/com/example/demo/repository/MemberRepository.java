package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MemberRepository extends JpaRepository<user, Long>{

	//Optional<member> findByusername(String username);
	Optional<user> findByusername(String username);
	
}