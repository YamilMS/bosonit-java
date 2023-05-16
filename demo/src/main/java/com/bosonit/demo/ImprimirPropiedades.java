package com.bosonit.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ImprimirPropiedades {


    @Value("${greeting}")
    private String saludo;
    @Value("${my.number}")
    private String numero;
    @Value("${new.property: ‘new.property no tiene valor'}")
    private String propiedad;


    @PostConstruct
    public void imprimirValues() {
        System.out.println("variable greeting: " + saludo);
        System.out.println("variable my.number: " + numero);
        System.out.println("variable new.property: " + propiedad);
    }
}
