package com.presidency.petconnect.security;

import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@EnableMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig {

    //    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/petConnect/**").permitAll()  // Allow access to pet APIs
//                        .anyRequest().authenticated());
//        return http.build();
//    }
   /* @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(auth -> auth
                        // Allow all preflight requests
                        .requestMatchers(HttpMethod.OPTIONS, "/api/petConnect/**").permitAll()

                        // Shelter routes
                        .requestMatchers(HttpMethod.POST,   "/api/petConnect/shelters/**").hasRole("SHELTER")
                        .requestMatchers(HttpMethod.PUT,    "/api/petConnect/shelters/**").hasRole("SHELTER")
                        .requestMatchers(HttpMethod.DELETE, "/api/petConnect/shelters/**").hasRole("SHELTER")
                        .requestMatchers(HttpMethod.GET,    "/api/petConnect/shelters/**").hasRole("SHELTER")

                        // Pets
                        .requestMatchers(HttpMethod.GET,    "/api/petConnect/pets/**").permitAll()
                        .requestMatchers(HttpMethod.POST,   "/api/petConnect/pets/**").hasRole("SHELTER")
                        .requestMatchers(HttpMethod.PUT,    "/api/petConnect/pets/**").hasRole("SHELTER")
                        .requestMatchers(HttpMethod.DELETE, "/api/petConnect/pets/**").hasRole("SHELTER")

                        // Users
                        .requestMatchers(HttpMethod.POST,   "/api/petConnect/users/**").permitAll()
                        .requestMatchers(HttpMethod.GET,    "/api/petConnect/users/**").permitAll()

                        .anyRequest().authenticated())
                        .oauth2ResourceServer(oauth2 -> oauth2
                                .jwt(jwt -> jwt.jwtAuthenticationConverter(new JwtAuthenticationConverter()))
                );
        return http.build();
    }



    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:5173"));
        config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
        config.setAllowedHeaders(List.of("Authorization","Content-Type"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
    @Bean
    public JwtDecoder jwtDecoder(@Value("${jwt.secret}") String base64Secret) {
        byte[] keyBytes = Decoders.BASE64.decode(base64Secret);
        SecretKey secretKey = new SecretKeySpec(keyBytes, "HMACSHA256");
        return NimbusJwtDecoder.withSecretKey(secretKey).build();
    }*/




        @Value("${jwt.secret}")
        private String jwtSecret;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(AbstractHttpConfigurer::disable)
                    .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers(HttpMethod.OPTIONS, "/api/petConnect/**").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/petConnect/login/**").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/petConnect/users/**").permitAll()
                            .requestMatchers(HttpMethod.GET, "/api/petConnect/pets/**").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/petConnect/pets/**").hasRole("SHELTER")
                            .anyRequest().authenticated()
                    )
                    .oauth2ResourceServer(oauth2 -> oauth2
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
        CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration cfg = new CorsConfiguration();
            cfg.setAllowedOrigins(List.of("http://localhost:5173"));
            cfg.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
            cfg.setAllowedHeaders(List.of("Authorization","Content-Type"));
            cfg.setAllowCredentials(true);

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", cfg);
            return source;
        }
    }
