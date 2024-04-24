package com.example.buyer.buyer;

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
        config.addAllowedOrigin("http://10.166.154.49:9000");
        config.addAllowedOrigin("http://10.166.151.143:6060");
        config.addAllowedHeader("");
        config.addAllowedMethod("");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
