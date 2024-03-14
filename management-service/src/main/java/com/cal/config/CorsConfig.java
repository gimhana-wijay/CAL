package com.cal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	
	@Value("${allowed.origin}")
	private String allowedOrigins;

	@Bean
	public WebMvcConfigurer getCorsConfiguration() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/cal-api/employee/**")
				.allowedOrigins(allowedOrigins)
				.allowedMethods("GET", "POST")
				.allowedHeaders("*");
			}
		};
	}
}
