package com.flightreservation.bookingservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  // Disable CSRF for simplicity
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/bookings/getAllBookings", "/bookings/getBookingById/**", "/bookings/user/**").authenticated() // Secure booking-related endpoints
                .requestMatchers("/bookings/createBooking").permitAll() // Allow booking creation without authentication
            )
            .httpBasic(); // Enable Basic Authentication

        return http.build();
    }
}