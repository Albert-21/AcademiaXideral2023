package com.patron.observador;

public class Producto extends Subject<Double> {
    private double precio;

    public void setPrice(double precio) {
        this.precio = precio;
        notifyObservers(precio);
    }
}
