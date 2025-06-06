package com.watchplant.app.configurations;

import com.watchplant.app.handlers.JwtAuthenticationFilter;
import com.watchplant.app.services.JwtService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    private final JwtService jwtService;

    public FilterConfig(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> loggingFilter() {
        FilterRegistrationBean<JwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtAuthenticationFilter(jwtService));
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
