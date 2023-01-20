package com.polimorfismo.programadores;

public class SemiSinior extends ProgramadorABS {

	public SemiSinior(String nombre, String apellidos) {
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
