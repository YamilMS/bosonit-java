package com.bosonit.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TerceraClase implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Los parametros de la tercera clase son: " + args);
    }
}
