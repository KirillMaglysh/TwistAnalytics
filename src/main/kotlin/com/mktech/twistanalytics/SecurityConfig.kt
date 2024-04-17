package com.mktech.twistanalytics

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {
    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/js/**", "/css/**", "/fonts/**", "/images/**", "/vendor/**").permitAll()
                auth
                    .requestMatchers("/", "/**").hasRole("USER")
            }
            .formLogin { formLogin ->
                formLogin
                    .loginPage("/login")
                    .permitAll()
            }.build()
    }
}
