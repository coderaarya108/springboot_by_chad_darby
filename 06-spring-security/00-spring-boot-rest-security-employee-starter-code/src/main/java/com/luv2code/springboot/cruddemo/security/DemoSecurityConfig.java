package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig  {

    private static final String ROLE_EMPLOYEE = "EMPLOYEE";
    private static final String ROLE_MANAGER = "MANAGER";

    // add support for jdbc .  no more hard coded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource) {

        return new JdbcUserDetailsManager(datasource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {


        try {
            String employeeIdEndpoint = "/api/employees/**";

            http.authorizeHttpRequests(configurer -> configurer
                    .requestMatchers(HttpMethod.GET, "/api/employees").hasRole(ROLE_EMPLOYEE)
                    .requestMatchers(HttpMethod.GET, employeeIdEndpoint).hasRole(ROLE_EMPLOYEE)
                    .requestMatchers(HttpMethod.POST, "/api/employees").hasRole(ROLE_MANAGER)
                    .requestMatchers(HttpMethod.PUT, employeeIdEndpoint).hasRole(ROLE_MANAGER)
                    .requestMatchers(HttpMethod.PATCH, employeeIdEndpoint).hasRole(ROLE_MANAGER)
                    .requestMatchers(HttpMethod.DELETE, employeeIdEndpoint).hasRole("ADMIN")
            );

            // use HTTP Basic authentication
            http.httpBasic(Customizer.withDefaults());

            // disable CSRF (cross site request forgery)
            // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
            http.csrf(csrf -> csrf.disable());

            return http.build();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to build Spring Security Filter chain", e);
        }
    }









    /*
    private static final String ROLE_EMPLOYEE = "EMPLOYEE";
    private static final String ROLE_MANAGER = "MANAGER";

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles(ROLE_EMPLOYEE)
                .build();

        UserDetails marie = User.builder()
                .username("marie")
                .password("{noop}test123")
                .roles(ROLE_EMPLOYEE , ROLE_MANAGER )
                .build();

        UserDetails janardan = User.builder()
                .username("Janardan")
                .password("{noop}test123")
                .roles( ROLE_EMPLOYEE , ROLE_MANAGER , "ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(john, marie, janardan);
    }

    @Bean
    public SecurityFilterChain filterChain( HttpSecurity http) {


        try {
            String employeeIdEndpoint = "/api/employees/**";

            http.authorizeHttpRequests(configurer -> configurer
                    .requestMatchers(HttpMethod.GET, "/api/employees").hasRole(ROLE_EMPLOYEE)
                    .requestMatchers(HttpMethod.GET, employeeIdEndpoint).hasRole(ROLE_EMPLOYEE)
                    .requestMatchers(HttpMethod.POST, "/api/employees").hasRole(ROLE_MANAGER)
                    .requestMatchers(HttpMethod.PUT, employeeIdEndpoint).hasRole(ROLE_MANAGER)
                    .requestMatchers(HttpMethod.PATCH, employeeIdEndpoint).hasRole(ROLE_MANAGER)
                    .requestMatchers(HttpMethod.DELETE, employeeIdEndpoint).hasRole("ADMIN")
            );

            // use HTTP Basic authentication
            http.httpBasic(Customizer.withDefaults());

            // disable CSRF (cross site request forgery)
            // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
            http.csrf(csrf -> csrf.disable());

            return http.build();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to build Spring Security Filter chain" , e);
        }

    }
    */

}
