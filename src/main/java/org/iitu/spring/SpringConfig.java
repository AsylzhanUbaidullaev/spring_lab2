package org.iitu.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;

@Configuration
@ComponentScan("org.iitu.spring")
@PropertySource("classpath:application.properties")
public class SpringConfig {
}
