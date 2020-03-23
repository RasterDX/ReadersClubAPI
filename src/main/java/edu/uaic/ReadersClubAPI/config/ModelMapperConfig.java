package edu.uaic.ReadersClubAPI.config;

import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
