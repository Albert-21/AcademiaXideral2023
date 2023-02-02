package com.polimorfismo.programadores;

public class Junior extends ProgramadorABS {

	public Junior(String nombre, String apellidos) {
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
