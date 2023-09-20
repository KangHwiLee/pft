package com.example.demo.security;

import java.util.Optional;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


/*
public interface MemberRepository extends JpaRepository<user, Long>{

	//Optional<member> findByusername(String username);
	Optional<user> findByusername(String username);
	
}*/
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(String username);
}