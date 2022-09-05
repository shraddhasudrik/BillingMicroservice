package com.hms.billingms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hms.billingms.filter.JwtFilter;
import com.hms.billingms.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtFilter jwtFilter;
	

	//then we'll override the configure method
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);          //we'll implementing the custom userdetailsservice. SPring security provide the userDetailsService and we need to use the our user data stored in db
		//we have to create user service here and that user service will get the user details from the database and send that user info
	}
	
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		
		return super.authenticationManager();
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/authenticate")		//.permitAll()
                //.antMatchers(HttpMethod.POST,"/issuebill").hasAnyAuthority("receptionist")
                .permitAll()
                .anyRequest()
               // .authenticated()
                .permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
 

    }
	
}
