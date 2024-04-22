package com.example.demoREST;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://127.0.0.1:5500"); // Allow requests from this origin
//        config.addAllowedOrigin("http://10.166.183.140:7070");
//        config.addAllowedOrigin("http://10.166.151.143:6060");
//        config.addAllowedOrigin("http://10.166.154.49:9000");
//        config.addAllowedOrigin("http://10.166.154.49:5500");
        config.addAllowedOrigin("*"); // Allow requests from all origins
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
