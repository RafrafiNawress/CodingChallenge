package com.subway.codingchallenge.controller;

import com.subway.codingchallenge.entities.AppUser;
import com.subway.codingchallenge.entities.Role;
import com.subway.codingchallenge.repositories.RoleRepository;
import com.subway.codingchallenge.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AppUserService userService;
	private final RoleRepository roleRepository;

	@PostMapping("/register")
	public AppUser register(@RequestBody AppUser appUser){
		return userService.register(appUser);
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role role){
		return roleRepository.save(role);
	}


	@Secured("ROLE_ADMIN")
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("admin/sayHello")
	public String SayHelloToAdmin() {
		return "Hello Admin";
	}


	//	@Secured("ROLE_USER")
	@PreAuthorize("hasRole('USER')")
	@GetMapping("user/sayHello")
	public String SayHelloToUser() {
		return "Hello User";
	}

	

	
	
}
