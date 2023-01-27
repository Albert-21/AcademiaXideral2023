# Comandos de Git
## git branch
El comando "git branch" en Git se utilizado para mostrar, crear o eliminar ramas. 
Los comandos mas utilizados son los siguientes:
`git branch`  Se utiliza para mostrar las ramas existentes en un repositorio.

`git branch nombre_de_la_rama`  Se utiliza para crear una nueva rama en el repositorio.

`git checkout nombre_de_la_rama` Se utiliza para cambiarte a una rama a otra pero esta rama debe existir.

`git branch -d nombre_de_la_rama`  Se usa para eliminar una rama siempre y cundo esta no tenga cambios hechos.

Argumentos que se pueden utilizar con git branch :

`-a  o --all`  Muestra todas las ramas, incluyendo las remotas.

`-r o --remotes` Muestra solo las ramas remotas.

`-v o --verbose`   Mestra la informacion de la rama incluyendo el ultimo commit.

`-vv:` Muestra información adicional, como el nombre del remote al que está vinculada cada rama remota.

`-l o --create-reflog` Crea un reflog para la  rama que se  creo.

`-d o --delete` Elimina una rama existente siempre y cundo no tenga cambios.
`-D` Elimina una rama existente incluso si tiene cambios.

`-m o --move`  Renombra una rama existente.

`-f o --force` Forza la eliminación o renombramiento de una rama, incluso si tiene cambios.

## git merge
Se utiliza para combinar el contenido de una rama en otra la cual es:

`git merge nombre_de_la_rama`  esto indica que combinará el contenido de la rama especificada en la rama en la que te encuentras actualmente, creando un "commit de fusión". En caso de que hayan conflictos en los archivos, Git te notificará y tendrás que resolverlos manualmente antes de poder hacer el commit.

# Solucionar los conflictos en java
Un conflicto ocurre en Git cuando dos o más ramas tienen cambios en los mismos archivos y no se pueden combinar automáticamente mediante un merge.

Cuando Git detecta un conflicto al intentar hacer un merge, coloca marcadores especiales en los archivos en conflicto para indicar dónde están los cambios que no se pueden combinar automáticamente. Los marcadores son "<<<<<
Malformed citation <<", "|||||||" y ">>>>>>>".
Un ejemplo de conflicto  podría ser si dos desarrolladores están trabajando en una clase llamada Carro y ambos hacen cambios en el mismo método.

Archivo orginal
```java
public class Carro {
    public void encender() {
        System.out.println("El auto encendio");
    }
}
```
Ahora, supongamos que el desarrollador A hace un cambio para agregar una nueva línea de código que imprime un mensaje adicional:
```java
public class Carro {
    public void encender() {
        System.out.println("El auto encendio");
        System.out.println("Bienvenido");
    }
}
```
Y al mismo tiempo el desarrollador B hace un cambio para cambiar el mensaje de salida:

```java
public class Carro {
    public void encender() {
        System.out.println("El auto se ha encendido correctamente");
    }
}
```
Cuando Git intenta hacer un merge automático, genera un conflicto en el archivo "Carro.java" y coloca marcadores especiales para indicar dónde están los cambios que no se pueden combinar automáticamente. El archivo quedaría así:
```java
public class Carro {
    public void encender() {
<<<<<&#8203;`oaicite:{"index":0,"invalid_reason":"Malformed citation 
<< HEAD\n        System.out.println(\El auto encendio\");\n        			System.out.println(\"Bienvenido\");\n =======\n        
		System.out.println(\"El auto se ha encendido correctamente\");\n        >>>>>>>"}`&#8203; futura_rama
    }
}
```
Para resolver el conflicto, el desarrollador debería editar el archivo y eliminar los marcadores, quedando el archivo así:
```java
public class Carro {
    public void encender() {
        System.out.println("El auto se ha encendido correctamente");
        System.out.println("Bienvenido");
    }
}

