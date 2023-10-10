package com.develhope.develhopespringboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DevelhopeSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevelhopeSpringBootApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){

        /*return an instance*/
        return new ModelMapper();

    }
}
