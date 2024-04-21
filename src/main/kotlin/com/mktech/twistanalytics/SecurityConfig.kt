package com.mktech.twistanalytics

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {
    private final val PUBLIC_MATCHERS: Array<String> =
        arrayOf("/stat_login/**")

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .authorizeHttpRequests { auth ->
                setupAuth(auth)
            }
            .formLogin { formLogin ->
                setupLogin(formLogin)
            }
            .logout { logout ->
                setupLogout(logout)
            }
            .build()
    }

    private fun setupLogout(logout: LogoutConfigurer<HttpSecurity>) {
        logout.logoutSuccessUrl("/login")
    }

    private fun setupAuth(auth: AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry) {
        auth
            .requestMatchers(*PUBLIC_MATCHERS)
            .permitAll()
        auth
            .requestMatchers("/", "/**")
            .hasRole("USER")
    }

    private fun setupLogin(formLogin: FormLoginConfigurer<HttpSecurity>) {
        formLogin
            .loginPage("/login")
            .permitAll()
        formLogin.defaultSuccessUrl("/", true)
    }

    @Bean
    fun userDetailsService(): InMemoryUserDetailsManager {
        val user1: UserDetails = User.withUsername("use")
            .password(passwordEncoder().encode("PSW"))
            .roles("USER")
            .build()
        val user2: UserDetails = User.withUsername("user2")
            .password(passwordEncoder().encode("user2Pass"))
            .roles("USER")
            .build()
        val admin: UserDetails = User.withUsername("admin")
            .password(passwordEncoder().encode("adminPass"))
            .roles("ADMIN")
            .build()
        return InMemoryUserDetailsManager(user1, user2, admin)
    }
}
