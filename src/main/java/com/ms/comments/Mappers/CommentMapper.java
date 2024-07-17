package com.ms.comments.Mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentMapper {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
