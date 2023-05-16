package com.bosonit.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PrimeraCLase {
    @PostConstruct
    public void primeraClase() {
        System.out.println("Hola desde primera clase");
    }

}
