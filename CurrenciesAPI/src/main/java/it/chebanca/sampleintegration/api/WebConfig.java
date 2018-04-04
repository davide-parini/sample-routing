package it.chebanca.sampleintegration.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan({ "it.chebanca.sampleintegration" })
public class WebConfig implements WebMvcConfigurer {

}