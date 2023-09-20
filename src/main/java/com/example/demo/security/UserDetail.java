/*
package com.example.demo.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetail implements UserDetailsService{
	
	@Autowired MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		member member = memberRepository.findByusername(username).orElseThrow(() -> 
//							new IllegalArgumentException("존재하지 않는 유저입니다."));
		user user = memberRepository.findByusername(username).orElseThrow(() ->
		new IllegalArgumentException("존재하지 않는 유저입니다."));
		
		//CustomUserDetails customUserDetails = new CustomUserDetails(member);
		//	return customUserDetails;
			return new User(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.getRole())));
	}

}*/
