package com.patron.observador;

import java.util.ArrayList;
import java.util.List;

public class Subject<T> {
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(T dato) {
        for (Observer observer : observers) {
            observer.update(dato);
        }
    }

}
