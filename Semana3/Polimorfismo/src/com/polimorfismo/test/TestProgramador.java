package com.polimorfismo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.polimorfismo.programadores.Junior;
import com.polimorfismo.programadores.Programador;
import com.polimorfismo.programadores.SemiSinior;
import com.polimorfismo.programadores.Sinior;

class TestProgramador {
	Programador programador = null;
	String[] Datos = { "Jose", "Hernandez Lopéz" };

	@Test
	void getJunior() {
		programador = new Junior(Datos[0], Datos[1]);
		assertEquals(" [nombre=Jose, apellidos=Hernandez Lopéz, nivel=Junior]",programador.toString());
	}
	@Test
	void getSemiSenior() {
		programador = new SemiSinior(Datos[0], Datos[1]);
		assertEquals(" [nombre=Jose, apellidos=Hernandez Lopéz, nivel=SemiSinior]",programador.toString());
	}
	
	@Test
	void getSenior() {
		programador = new Sinior(Datos[0], Datos[1]);
		assertEquals(" [nombre=Jose, apellidos=Hernandez Lopéz, nivel=Sinior]",programador.toString());
	}

}
