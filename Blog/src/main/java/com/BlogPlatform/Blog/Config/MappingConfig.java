package com.BlogPlatform.Blog.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {
    // Defines a ModelMapper bean to be used for mapping between DTOs and entities
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
