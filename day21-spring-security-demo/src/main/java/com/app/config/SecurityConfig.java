package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // to tell SC , class below will contain @Bean annotated methods --equivalent to
				// <bean id class ...../>
@EnableWebSecurity //to enable spring security support
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// override this method to enable In memory auth.
		auth.inMemoryAuthentication() //enabled in mem auth
		.withUser("Rama").password(passwordEncoder().encode("1234")).roles("ADMIN") //1 user details 
		.and().
		withUser("Mihir").password(passwordEncoder().encode("4567")).roles("CUSTOMER"); //2 user details 
	}
	/* super class version
	 * protected void configure(HttpSecurity http) throws Exception {
		this.logger.debug("Using default configure(HttpSecurity). "
				+ "If subclassed this will potentially override subclass configure(HttpSecurity).");
		http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
		http.formLogin();
		http.httpBasic();
	}
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//override this method , to customize , authorization rules : based upon roles.
		http.authorizeRequests(). //authorize all requests
		antMatchers("/home").permitAll() // /home : accessible to all users
		.antMatchers("/customer/**").hasAnyRole("CUSTOMER","ADMIN")
		.antMatchers("/admin").hasRole("ADMIN")
		.and()
		.formLogin() //enable for login : supplies to a browser clnt login n logout features
		.and() 
		.httpBasic(); //enables Basic Auth	
		
	}
	//configure password encoder bean : vendor : Bcrypt encoder
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	

}
