package com.bosonit.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SegundaClase {
    @Bean
    public CommandLineRunner SegundaClase() {
        return p->{
            System.out.println("Hola desde la segunda clase");
        };
    }

}
