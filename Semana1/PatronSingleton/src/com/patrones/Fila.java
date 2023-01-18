package com.patrones;

public class Fila {
	
	private static Fila fila;
	private int numFila;

	private Fila() {}
	
	static public Fila getIntsnce() {
		 if(fila == null) {
			 fila = new Fila();
		 }
		 return fila;
	}
	
	public String numeroEnFila() {
		numFila++;
		return "Usted esta  el numero "+numFila+" en la fila";
	}
	

}
