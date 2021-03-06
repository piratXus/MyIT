package com.mycompany.testwebproject.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration 
@ComponentScan(basePackages = "com.mycompany.testwebproject") 
@EnableWebMvc
public class AppConfig {
}
