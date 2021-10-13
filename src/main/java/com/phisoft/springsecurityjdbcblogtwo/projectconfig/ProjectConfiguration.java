package com.phisoft.springsecurityjdbcblogtwo.projectconfig;

import com.phisoft.springsecurityjdbcblogtwo.security.AppUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ProjectConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/save").permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    @Override
    public AppUserDetailsService userDetailsService(){
        return new AppUserDetailsService();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder();
    }
}
