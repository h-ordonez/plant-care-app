package com.plantcareapp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(
                        "/plants/showFormForAdd",
                        "/plants/showFormForUpdate",
                        "/plants/save",
                        "/plants/delete"
                ).hasRole("ADMIN")
                .anyRequest().authenticated()
        )
        .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
        )
        .logout(logout -> logout.permitAll())
        .exceptionHandling(configurer -> configurer
                .accessDeniedPage("/access-denied")
        );

        return http.build();
    }
}
