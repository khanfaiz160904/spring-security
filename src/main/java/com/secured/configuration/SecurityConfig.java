package com.secured.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager inmemoMan(PasswordEncoder encoder) {
		UserDetails admin = User.withUsername("Khan")
				.password(encoder.encode("khan@123")).roles("ADMIN").build();

		UserDetails user = User.withUsername("faiz")
				.password(encoder.encode("faiz@123")).roles("USER").build();

		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/loginform").permitAll()
				.requestMatchers("/public/**").hasRole("ADMIN")
				.requestMatchers("/user/**").hasRole("USER")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/loginform")
				.loginProcessingUrl("/index")
				.defaultSuccessUrl("/public/getall", true)
				.permitAll()
				.and()
				.logout()
				.logoutSuccessUrl("/loginform?logout")
				.permitAll();
		return http.build();
	}
}
