package me.developery.acturator_study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyLibraryInfoEndpointConfig {

    @Bean
    MyLibraryInfoEndpoint myLibraryInfoEndpoint(){
        return new MyLibraryInfoEndpoint();
    }
}
