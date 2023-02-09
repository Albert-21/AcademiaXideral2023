package com.patron.observador;

public class ObserverPrecio implements Observer<Double> {
    private String nombre;
    public ObserverPrecio(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(Double tipo) {
        System.out.println(nombre + " recibido actualización del precio: $" + tipo);
    }


}
