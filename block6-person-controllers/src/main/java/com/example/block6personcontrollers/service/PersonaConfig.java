package com.example.block6personcontrollers.service;

import com.example.block6personcontrollers.model.Persona;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonaConfig {

    @Bean
    @Qualifier("bean1")
    public Persona personaBean1() {
        return new Persona("Menganito", "Narnia", 30);
    }

    @Bean
    @Qualifier("bean2")
    public Persona personaBean2() {
        return new Persona("Fulanito2", "Rivendel", 35);
    }

    @Bean
    @Qualifier("bean3")
    public Persona personaBean3() {
        return new Persona("Pepito3", "Hogwarth", 40);
    }
}
