package com.subway.codingchallenge.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.subway.codingchallenge.entities.AppUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.Assert;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
												HttpServletResponse response) {

		AppUser appUser = new AppUser();

		try {
			appUser = new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Assert.notNull(appUser.getUsername(),"user empty");

		return this.getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(appUser.getUsername(),appUser.getPassword())
		);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
											HttpServletResponse response,
											FilterChain chain,
											Authentication authResult) throws IOException, ServletException {

		User springUser = (User) authResult.getPrincipal();
		String jwtToken= JWTUtils.generateToken(springUser);
		response.addHeader(SecurityConstants.HEADER_STRING , jwtToken);

	}


}
