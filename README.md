# Catálogo de tiendas 

_El propósito de este proyecto es poder guardar, visualizar y agregar nuevas prendas de ropa con su marca, talla y precio._  

---
## Inicio

_Las siguientes instrucciones permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas del mismo._

### Pre-requisitos

_Estas son las siguientes cosas que se necesitan para poder ejecutar el proyecto:_

```
Versión 11 de Open JDK
```
```
Tener make instalado
```

### Compilación del programa

Se ejecuta el comando siguiente:

```
make jar 
```
---
## Ejecutar pruebas

_Para poder ejecutar pruebas del programa, deberá seguir las siguientes instrucciones:_

-   Para poder ver la lista de tiendas con sus prendas de vestir que hay en la lista.
```
java -jar tienda.jar list
```
-   Para mostar ayuda. Se mostrará una guía más específica de que comandos se pueden ejecutar.
```
java -jar tienda.jar help
```
-   Para añadir una tienda cualquiera.
```
java -jar tienda.jar add <Marca> <Nombre> <Talla> <Precio>
```
```
tales como,
```
```
java -jar tienda.jar add Zara Camisa M 20
```
-   Para añadir una tienda de Zara.
```
java -jar tienda.jar addZara <Nombre> <Talla> <Precio>
```
```
tales como,
```
```
java -jar tienda.jar addZara Camisa M 20
```
-   Para añadir una tienda de Mango.
```
java -jar tienda.jar addMango <Nombre> <Talla> <Precio>
```
```
tales como,
```
```
java -jar tienda.jar addMango Camisa M 20
```
-   Para añadir una tienda de Nike.
```
java -jar tienda.jar addNike <Nombre> <Talla> <Precio>
```
```
tales como,
```
```
java -jar tienda.jar addNike Camisa M 20
```
-   Para borrar una tienda.
```
java -jar tienda.jar remove <ID> <Marca> <Nombre> <Talla> <Precio>
```
```
tales como,
```
```
java -jar tienda.jar remove 1 Zara Camisa M 20
```
-   Para modificar una tienda.
```
java -jar tienda.jar modify <ID> <Marca> <Nombre> <Talla> <Precio> <nuevaMarca> <nuevoNombre> <nuevaTalla> <nuevoPrecio>
```
```
tales como,
```
```
java -jar tienda.jar modify 2 Nike Sudadera XXL 30 Mango Camisa S 15
```
-   Para generar el csv
```
java -jar tienda.jar csv
```
## Notas para los desarolladores 

---

### Generar Javadoc
Se ejecuta el siguiente comando:
```
make javadoc
```

### Visualización del Javadoc
Se ejecuta el siguiente comando (es necesesario tener `firefox`):
```
firefox html/index.html
```
###Información Adicional
Al hacer java -jar tienda.jar list cada producto que se añada aparecerá con una ID distinta al principio.
Para borrar una tienda, se deberá fijar que ID tiene la tienda que se quiera borrar.

---
## Autores ✒️

_Estos son los autores que han contribuido en el realizamiento del proyecto:_

* **[Serena Blanco García](https://serena_blanco@bitbucket.org/Yolallop/proyecto_final.git)**
* **[Juan Cordero Pascual](https://jcorderop02@bitbucket.org/Yolallop/proyecto_final.git)** 
* **[Yolanda Llop Pellisa](https://Yolallop@bitbucket.org/Yolallop/proyecto_final.git)** 
* **[Rita Barragan Barranco](https://rriitaa_@bitbucket.org/Yolallop/proyecto_final.git)**


---
## Copyright
Se permite cualquier explotación de la obra, incluyendo una
finalidad comercial, así como la creación de obras derivadas, la distribución de las cuales también está permitida sin ninguna restricción.
![Copyright.png](Copyright.png)

