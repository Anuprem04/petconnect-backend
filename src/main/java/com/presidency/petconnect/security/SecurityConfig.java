package com.presidency.petconnect.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.List;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/api/petConnect/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/petConnect/shelters").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/petConnect/queries").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/petConnect/queries").hasRole("SHELTER")
                        .requestMatchers(HttpMethod.GET, "/api/petConnect/shelters").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/petConnect/adoptions").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/petConnect/adoptions/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/petConnect/adoptions/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/petConnect/shelters/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/images/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/petConnect/login/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/petConnect/users/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/petConnect/pets/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/petConnect/pets/**").hasRole("SHELTER")
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        // Ensure you have a custom JwtAuthenticationConverter defined;
                        // otherwise, remove or replace this line.
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(new JwtAuthenticationConverter()))
                );
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        byte[] keyBytes = Base64.getDecoder().decode(jwtSecret);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(key).build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cfg = new CorsConfiguration();
        cfg.setAllowedOrigins(List.of("http://localhost:5173"));
        cfg.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        cfg.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        cfg.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cfg);
        return source;
    }
}
