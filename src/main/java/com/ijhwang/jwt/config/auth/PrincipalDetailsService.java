package com.ijhwang.jwt.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ijhwang.jwt.model.UserJwt;
import com.ijhwang.jwt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// localhost:8083/login 일떄 호출된다 -> 기본 로그인 주소

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("custom UserDetails Service");
		UserJwt userEntity = userRepository.findByUsername(username);
		
		return new PrincipalDetails(userEntity);
	}

}
