package com.patron.observador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcion, num =1;
        Producto productoSubject = new Producto();
        boolean salir =false;
        while (!salir){
            System.out.println("Seleccione la opcion");
            System.out.println("1: Agreagar Caja");
            System.out.println("2: Actualzar precio");
            System.out.println("3: salir");

            opcion = entrada.nextInt();

            switch (opcion){
                case 1 :
                    productoSubject.registerObserver(new ObserverPrecio("Caja: "+num));
                    System.out.println("Se agrego un caja");
                    break;
                case 2 :
                    System.out.println("Agrege el nuevo precio");
                    opcion = entrada.nextInt();
                    productoSubject.setPrice(opcion);
                    break;
                case 3:
                    salir = true;
                    break;

            }


    }

    }
}