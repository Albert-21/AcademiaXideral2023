# Patron de diseño Singleton
El patrón de diseño singleton se encarga de manejar la creación de objetos ya que este solo nos permite crear una única instancia de la clase con el fin de no saturar la memoria de objetos innecesarios. 
## Modelado UML
La representación en el diagrama que se puede ver en la parte de abajo nos indica que debemos crear una variable de clase que va hacer de tipo privado que es del mismo tipo y el constructor se debe crear de tipo privado de igual forma y por último se crea el método getInstancia() el cual va hace de tipo público y este método lo que nos debe devolver es el objeto.

<p align="center">
  <img  src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Singleton_UML_class_diagram.svg/250px-Singleton_UML_class_diagram.svg.png">
</p>

## Implementacion en la practica
El ejemplo más practico en la vida real en el cual usamos el patrón es cuando usamos la maquina que nos da los lugares que tenemos en la fila pues en este caso pues solo es una maquina la que da los lugares a cualquier persona.

## Implementacion en Java
```java

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


```
Como podemos observar en el método para obtener la instancia se realiza una condicional si la variable es null nos crea el objeto y lo devuelve pero si la variable no esta vacía nos devuelve la instancia ya creada.