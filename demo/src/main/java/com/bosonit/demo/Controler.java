package com.bosonit.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controler {
    @RequestMapping("/")
    public String index() {
        log.trace("Mensaje a nivel de TRACE");
        log.debug("Mensaje a nivel de DEBUG");
        log.info("Mensaje a nivel de INFO");
        log.warn("Mensaje a nivel de WARNING");
        log.error("Mensaje a nivel de ERROR");

        return "Se han generado resultados, echa un vistazo";
    }
}
