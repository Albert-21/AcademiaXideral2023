package com.lambdas.ejercicio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Se crean las acciones que se desean crear y o se ejecutan
        Operaciones suma = (int a, int b) -> a + b;
        Operaciones resta = (int a, int b) -> a - b;
        Operaciones multiplicacion = (int a, int b) -> a * b;
        Operaciones divicion = (int a, int b) -> a / b;

        //Aqui es cuando se llaman que se ejecuta la lambda
        System.out.println("____________Operaciones________________");
        System.out.println("Suma: "+suma.operacion(4,5));
        System.out.println("Resta: "+resta.operacion(34,20));
        System.out.println("Multiplicacion: "+multiplicacion.operacion(23,5));
        System.out.println("Divicion: "+divicion.operacion(21,7));
        System.out.println("_____________________________________________________");

        System.out.println("____________Filtrado de personas________________");
        List<Persona> personaList = Arrays.asList(
                new Persona("John", 30),
                new Persona("Jesus", 25),
                new Persona("Carlos", 35),
                new Persona("Pedro", 25),
                new Persona("Adan", 20),
                new Persona("Ariel", 50)
                );
        //Se crea una lista nueva a partir de los 30 años
        List<Persona> personasFiltradas = personaList.stream()
                .filter(persona -> persona.getEdad() >= 30)
                .collect(Collectors.toList());
        System.out.println(personasFiltradas);
        System.out.println("_____________________________________________________");

        //Se ordena la lista de menor a mayor
        System.out.println("____________Persona ordenadas de menor a mayor________________");
        personaList.sort((persona1, persona2) -> persona1.getEdad() - persona2.getEdad());
        personaList.forEach(System.out::println);
        System.out.println("_____________________________________________________");


    }
}