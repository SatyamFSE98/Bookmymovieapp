package com.bookmymoviesapp;

import javax.servlet.FilterRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;

import com.bookmymoviesapp.filter.JWTfilter;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BookmovieApplication {
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean fb = new FilterRegistrationBean();
		fb.setFilter(new JWTfilter());
		fb.addUrlPatterns("/api/v1.0/*");
		return fb;
	}


	public static void main(String[] args) {
		SpringApplication.run(BookmovieApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
