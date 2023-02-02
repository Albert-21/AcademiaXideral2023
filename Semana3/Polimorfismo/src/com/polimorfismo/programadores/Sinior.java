package com.polimorfismo.programadores;

public class Sinior extends ProgramadorABS {

	public Sinior(String nombre, String apellidos) {
		super(nombre, apellidos);
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String getApellidos() {
		return this.apellidos;
	}

}
