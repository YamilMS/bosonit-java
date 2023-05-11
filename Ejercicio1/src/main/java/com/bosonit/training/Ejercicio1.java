package com.bosonit.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
            System.out.println("Cagada en el main leyendo el .CSV");
        }

        List<Person> filteredPeople = filterPeople(people);
        System.out.println("Filtered people:");
        filteredPeople.forEach(System.out::println);

        List<Person> filterPeopleAgeLessThan25 = filterPeopleAgeLessThan25(people);
        System.out.println("Filtered people with less than 25:");
        filterPeopleAgeLessThan25.forEach(System.out::println);

        List<Person> filterPeopleNotStartingWithA = filterPeopleNotStartingWithA(people);
        System.out.println("Filtered people sin a:");
        filterPeopleNotStartingWithA.forEach(System.out::println);

        filterFirstPersonFromMadridWithLessThan25(filterPeopleAgeLessThan25);
        filterFirstPersonFromBarcelonaWithLessThan25(filterPeopleAgeLessThan25);


    }

    public static List<Person> readCSV(String filename) throws InvalidLineFormatException {
        List<Person> people = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(":");
                int countOfColon = 0;
                int index = linea.indexOf(":");

                while (index != -1) {
                    countOfColon++;
                    index = linea.indexOf(":", index + 1);
                }

                if (campos.length == 0 || countOfColon < 2 || campos[0].isEmpty() || campos.length > 3) {
                    throw new InvalidLineFormatException("Formato incorrecto en la linea del fichero .CSV: \n" + linea );
                }

                String name = campos[0];
                String town = "Unknown";
                String age = "0";

                if (!campos[1].isEmpty()) {
                    town=campos[1];
                }

                if (campos.length==3 && !campos[2].isEmpty()) {
                    try {
                        age = campos[2];
                    } catch (NumberFormatException e) {
                        throw new InvalidLineFormatException("Invalid age format in line: " + e);
                    }
                } else{
                    age="Unknown";
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

    public static List<Person> filterPeopleAgeLessThan25(List<Person> people) {
        return people.stream()
                .filter(p -> {
                    String age = p.getAge();
                    if (!age.isEmpty() && !age.equals("0")) {
                        try {
                            int ageInt = Integer.parseInt(age);
                            return ageInt < 25;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    }
                    return false;
                })
                .map(p -> {
                    String age = p.getAge();
                    if (age.isEmpty() || age.equals("0")) {
                        age = "unknown";
                    }
                    return new Person(p.getName(), p.getTown(), age);
                })
                .collect(Collectors.toList());
    }

    public static List<Person> filterPeopleNotStartingWithA(List<Person> people) {
        return people.stream()
                .filter(p -> !p.getName().toLowerCase().startsWith("a") )
                .map(p -> {
                    if (p.getTown().isEmpty()) {
                        p.setTown("unknown");
                    }
                    if (p.getAge().equals("0")) {
                        p.setAge("unknown");
                    }
                    return p;
                })
                .collect(Collectors.toList());
    }

    public static void filterFirstPersonFromMadridWithLessThan25(List<Person> people) {
        Optional<Person> madridPerson = people.stream()
                .filter(p -> p.getTown().equals("Madrid"))
                .findFirst();

        madridPerson.ifPresent(p -> System.out.println("La persona de Madrid es: " + p));

    }

    public static void filterFirstPersonFromBarcelonaWithLessThan25(List<Person> people) {
        Optional<Person> madridPerson = people.stream()
                .filter(p -> p.getTown().equals("Barcelona"))
                .findFirst();

        madridPerson.ifPresent(p -> System.out.println("La persona de Barcelona es: " + p));

    }





}
