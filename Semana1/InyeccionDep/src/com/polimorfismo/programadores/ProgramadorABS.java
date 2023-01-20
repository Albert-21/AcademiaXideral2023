package com.polimorfismo.programadores;

public abstract class ProgramadorABS implements Programador {
	protected String nombre;
	protected String apellidos;
	
	public ProgramadorABS(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	

	@Override
	public String toString() {
		return " [nombre=" + nombre + ", apellidos=" + apellidos + ", nivel=" + this.getClass().getSimpleName() + "]";
	}
}
