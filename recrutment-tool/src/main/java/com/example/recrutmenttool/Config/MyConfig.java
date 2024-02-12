package com.example.recrutmenttool.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
class MyConfig {
//<<<<<<< HEAD
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.builder().username("PUNEETH").password(passwordEncoder().encode("abc")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }
//=======
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.builder().username("PUNEETH").password(passwordEncoder().encode("abc")).roles("ADMIN").build();
//        UserDetails userDetails2 = User.builder().username("ANKIT").password(passwordEncoder().encode("abc")).roles("ADMIN").build();
//        UserDetails userDetails3 = User.builder().username("ALOK").password(passwordEncoder().encode("abc")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(userDetails, userDetails2, userDetails3);
//    }
//>>>>>>> a2277e4da444fdbe64d17b4badf6b3202d5fb293

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
