#Inyección de Dependencia
La inyección de dependencia se utiliza para crear o instanciar objetos fuera de la clase que se esta utilizando en este caso contamos un agente externo el cual se va a encargar de crear estas instancias esto con el fin de que se pueda cambiar el comportamiento de las demás clases sin que esta clase se vea afectada por dicha modificación en el código.
## Modelado UML
En la representación del diagrama podemos observar que la clase que se encarga de llamar o crear la instancia del objeto es la clase de equipo de desarrollo esto lo hace cuando se llama al método de getProgramador() ya que este devuelve un programador como tal pero sin saber a que tipo de programador ye que como habíamos mencionado que  el agente externo que en este caso es Inyector es el que se va a encargar en  ver que tipo de programador nos devuelve;.

<p align="center">
  <img  src="DIAGRAMA.png" />
  </p>

## Implementacion en Java
######  Clase que hace uso del gente

```java

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

```
######  Clase principal
Como se puede observar en esta clase solo se instancia la clase EquipoDesarrollo y solo le pasamos el nombre y apellido pero cuando lo ejecutemos nos va a mostrar en que tipo de programador es el miembro del equipo


```java
public class Principal {
	public static void main(String[] args) {
		EquipoDesarrollo miembroEquipo = new EquipoDesarrollo("Pedro", "Lopez");	
		System.out.println("El mienbro del equipo es "+ miembroEquipo.getProgramador());
	}

}
```
