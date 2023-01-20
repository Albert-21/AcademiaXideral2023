package com.polimorfismo.programadores;

import java.util.Random;

public class EquipoDesarrollo {
	private Programador programador;
	private static Random r = new Random();
	private int numRandon;

	public EquipoDesarrollo(String nombre, String apelidos) {
		numRandon =  r.nextInt(TiposProgramador.values().length);
		String[] datos= {nombre,apelidos};
		programador = Inyector.getTipo(datos,TiposProgramador.values()[numRandon]);
	}
	
	public Programador getProgramador() {
		return programador;
		
	}

	

}
