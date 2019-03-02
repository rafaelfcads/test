package br.com.atech.test.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("test@test.com")
          .password("123456")
          .roles("USER");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        JwtLoginFilter jwtLoginFilter = new JwtLoginFilter("/login", authenticationManager());
		JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
		
		http
			.cors().and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers(
	            "/v2/api-docs", 
	            "/swagger-resources/**",  
	            "/swagger-ui.html", 
	            "/webjars/**" ,
	            "/swagger.json")
	        .permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilterBefore(jwtLoginFilter, UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
      return source;
    }
}
