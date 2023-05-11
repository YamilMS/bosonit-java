package com.bosonit.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) {

        //Relative Path
        String filename = "src/main/resources/people.csv";

        List<Person> people = new ArrayList<>();

        try {
            people = readCSV(filename);
        } catch (InvalidLineFormatException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Cagada en el main");
        }

        List<Person> filteredPeople = filterPeople(people);
        System.out.println("Filtered people:");
        filteredPeople.forEach(System.out::println);
    }

    public static List<Person> readCSV(String filename) throws InvalidLineFormatException {
        List<Person> people = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(":");
                if (campos.length == 0 || campos.length > 3) {
                    throw new InvalidLineFormatException("Invalid format in line: " + linea);
                }
                String name = campos[0];
                String town = "";
                int age = 0;
                if (campos.length > 1 && !campos[1].isEmpty()) {
                    town = campos[1];
                }
                if (campos.length == 3 && !campos[2].isEmpty()) {
                    try {
                        age = Integer.parseInt(campos[2]);
                    } catch (NumberFormatException e) {
                        throw new InvalidLineFormatException("Invalid age format in line: " + e);
                    }
                    if (age == 0) {
                        age = -1; // Indicate unknown age
                    }
                }
                people.add(new Person(name, town, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return people;
    }

    public static List<Person> filterPeople(List<Person> people) {
        Collectors Collectors = null;
        return people.stream()
                .filter(p -> p.getName() instanceof String)
                .collect(Collectors.toList());
    }

    public static List<Person> filterPeopleAgeLessThan25AndNotFromSevilla(List<Person> people) {
        Collectors Collectors = null;
        return people.stream()
                .filter(p -> p.getAge() >= 2 && !"Sevilla".equals(p.getTown()))
                .collect(Collectors.toList());
    }

}
