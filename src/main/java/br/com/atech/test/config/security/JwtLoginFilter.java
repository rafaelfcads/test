package br.com.atech.test.config.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

	public JwtLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		ServletInputStream inputStream = request.getInputStream();
		if (inputStream == null || inputStream.available() == 0) return null;
		
		UserCredentials credentials = new ObjectMapper().readValue(inputStream, UserCredentials.class);
		UsernamePasswordAuthenticationToken userPassToken = new UsernamePasswordAuthenticationToken(
				credentials.getEmail(),
				credentials.getPassword(),
				Collections.emptyList());
		
		return this.getAuthenticationManager().authenticate(userPassToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain, Authentication auth) throws IOException, ServletException {

		TokenAuthenticationService.addAuthentication(response, auth.getName());
	}

}
