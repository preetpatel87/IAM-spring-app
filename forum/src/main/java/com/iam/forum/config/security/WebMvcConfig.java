package com.iam.forum.config.security;

import com.iam.forum.model.repository.RBACRepository;
import com.iam.forum.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private RBACRepository rbacRepository;

    @Autowired
    private UserRepository userRepository;

    private final static long MAX_AGE_SECS = 3600;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ForumServiceInterceptor(rbacRepository, userRepository));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
                .maxAge(MAX_AGE_SECS);
    }


}

