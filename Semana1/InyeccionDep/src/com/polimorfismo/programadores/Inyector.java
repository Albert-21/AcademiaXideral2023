package com.polimorfismo.programadores;

public class Inyector {
	private static Programador programador = null;
	public static Programador getTipo(String[] datos, TiposProgramador tipo) {
		switch (tipo) {
		case JUNIOR: {
			programador = new Junior(datos[0], datos[1]);
			break;
		}
		case SEMISENIOR: {
			programador = new SemiSinior(datos[0], datos[1]);
			break;
		}
		case SINIOR: {
			programador = new Sinior(datos[0], datos[1]);
		}
		}
		return programador;	
	}
	

}
