package com.subway.codingchallenge.services;

import com.subway.codingchallenge.entities.AppUser;
import com.subway.codingchallenge.entities.Role;
import com.subway.codingchallenge.repositories.AppUserRepository;
import com.subway.codingchallenge.repositories.RoleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {

	//@Lazy @Autowired
	private final PasswordEncoder passwordEncoder;
	private final AppUserRepository appUserRepository;
	private final RoleRepository roleRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AppUser appUser = appUserRepository.findByUsername(username);
		Assert.notNull(appUser, new UsernameNotFoundException(username).getMessage());
		return new User(appUser.getUsername(),appUser.getPassword(),getAuthorities(appUser.getRole()));
	}

	private List<GrantedAuthority> getAuthorities(Role userRole) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));
		return authorities;
	}


	public AppUser register(AppUser appUser) {
		roleRepository.findById(appUser.getRole().getId())
				.ifPresent(
						role -> Assert.isTrue(!role.getRoleName().equals("ROLE_ADMIN"),"only super administrator can add another admin")
				);
		String pwdCrypted  = passwordEncoder.encode(appUser.getPassword());
		appUser.setPassword(pwdCrypted);
		return appUserRepository.save(appUser);
	}

}
