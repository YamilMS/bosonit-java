package com.example.block6pathvariableheaders.controlador;

import com.example.block6pathvariableheaders.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controlador {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @PostMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/user/{id}")
    public Greeting greeting(@PathVariable("id") long id) {
        return new Greeting(id, "Usuario");
    }

    @PutMapping("/post")
    public Map<String, Object> greeting(@RequestParam("var1") long var1,
                                     @RequestParam("var2") String var2) {
        LinkedHashMap<String,Object> map = new LinkedHashMap();
        map.put("var1", var1);
        map.put("var2", var2);
        return map;
    }
}