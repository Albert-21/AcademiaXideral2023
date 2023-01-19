package com.polimorfismo.programadores;

import java.util.Random;

public class Principal {
	public static enum Tipos {
		JUNIOR, SEMISENIOR, SINIOR
	};

	public static void main(String[] args) {
		Random r = new Random();
		Programador programador = null;
		String[] Datos = { "Jose", "Hernandez Lopéz" };
		int nunRandon = r.nextInt(Tipos.values().length);
		switch (Tipos.values()[nunRandon]) {
		case JUNIOR: {
			programador = new Junior(Datos[0], Datos[1]);
			break;
		}
		case SEMISENIOR: {
			programador = new SemiSinior(Datos[0], Datos[1]);
			break;
		}
		case SINIOR: {
			programador = new Sinior(Datos[0], Datos[1]);
		}
		}
		
		System.out.println(programador);

	}

}
