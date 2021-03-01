/*Copyright [2020] [Serena Blanco, Juan Cordero, Yolanda Llop, Rita Barragan]
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package interfaz;

import dominio.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;

/**
 * Clase interfaz que crea el ArrayList y que contiene el método toString
 * @author Serena Blanco
 * @author Juan Cordero
 * @author Yolanda Llop
 * @author Rita Barragan
 * @version 2.0, 16/12/2020
 */
public class Interfaz{
    private static int contarID = 1;
    private static String TEXTO_AYUDA = "Los comandos que se pueden utilizar son los siguientes:" + "\n" +
            "- Para mostrar la información de todas las tiendas: java -jar tienda.jar list" + "\n" +
            "- Para añadir una tienda cualquiera: java -jar tienda.jar add <Marca> <Nombre> <Talla> <Precio>" + "\n" +
            "- Para añadir una tienda de Zara: java -jar tienda.jar addZara <Nombre> <Talla> <Precio>" + "\n" +
            "- Para añadir una tienda de Mango: java -jar tienda.jar addMango <Nombre> <Talla> <Precio>" + "\n" +
            "- Para añadir una tienda de Nike: java -jar tienda.jar addNike <Nombre> <Talla> <Precio>" + "\n" +
            "- Para borrar una tienda: java -jar tienda.jar remove <ID> <Marca> <Nombre> <Talla> <Precio>" + "\n" +
            "- Para modificar una tienda: java -jar tienda.jar modify <ID> <Marca> <Nombre> <Talla> <Precio> <nuevaMarca> <nuevoNombre> <nuevaTalla> <nuevoPrecio>" +  "\n" +
            "- Para generar el csv: java -jar tienda.jar csv";
    private static String NOMBRE_FICHERO = "tienda.txt";
    private static String NOMBRE_CSV = "tienda.csv";

    /**
     * Método para obtener la ID del producto
     * @return ID del producto
     */
    public static int getContarID() {
        return contarID;
    }

    /**
     * Método para establecer la ID del producto
     * @param contarID Nueva ID
     */
    public static void setContarID(int contarID) {
        Interfaz.contarID = contarID;
    }

    /**
     * Metodo para comprobar si los argumentos no son numeros
     * @param toValidate Lista de argumentos
     * @return True si ninguno es un numero, false en caso contrario
     */
    private static boolean validarArgs(ArrayList<String> toValidate) {
        for (String s : toValidate) {
            try {
                Integer.parseInt(s);
                return false;
            } catch (Exception ignored) {
            }
        }
        return true;
    }

    /**
     * Método para procesar los argumentos del comando
     * @param sentencia Argumentos del main
     */
    public static void procesarPeticion(String sentencia) {
        String[] args = sentencia.split(" ");
        Tienda tienda = inicializarTienda(NOMBRE_FICHERO);

        if (args[0].equals("help")) {
            System.out.println(TEXTO_AYUDA);
        } else if (args[0].equals("list")) {
            if (tienda.toString().equals("")) {
                System.out.println("No hay ningún producto en la tienda");
            } else {
                System.out.println(tienda);
            }
        } else if (args[0].equals("add")) {
            if (args.length == 5) {
                try {
                    ArrayList<String> toValidate = new ArrayList<String>();
                    toValidate.add(args[1]);
                    toValidate.add(args[2]);
                    toValidate.add(args[3]);

                    if (validarArgs(toValidate)) {
                        contarID = tienda.getMedida();
                        Producto Producto = new Producto(contarID, args[1], args[2], args[3], Integer.parseInt(args[4]));
                        tienda.annadirProducto(Producto);
                        inicializarFichero(tienda);
                    } else {
                        System.out.println("¡Alguno de los argumentos introducidos es incorrecto!");
                        System.out.println("Teclee java -jar tienda.jar help para ver los parametros necesarios.");
                    }
                } catch (Exception exception) {
                    System.out.println("¡ERROR! Se ha introducido una palabra en vez de un numero en el precio del producto.");
                    System.out.println("Introduzca java -jar tienda.jar help para ver los parametros.");
                }
            } else {
                System.out.println("¡El numero de argumentos introducidos no son correctos!");
                System.out.println("Teclee java -jar tienda.jar help para ver los parametros necesarios.");
            }
        } else if (args[0].equals("remove")) {
            if (args.length == 6) {
                try {
                    ArrayList<String> toValidate = new ArrayList<String>();
                    toValidate.add(args[2]);
                    toValidate.add(args[3]);
                    toValidate.add(args[4]);

                    if (validarArgs(toValidate)) {
                        Producto pProducto = new Producto(Integer.parseInt(args[1]), args[2], args[3], args[4], Integer.parseInt(args[5]));
                        tienda.borrarProducto(pProducto);
                        inicializarFichero(tienda);
                        inicializarCSV(tienda);
                    } else {
                        System.out.println("¡Alguno de los argumentos introducidos es incorrecto!");
                        System.out.println("Teclee java -jar tienda.jar help para ver los parametros necesarios.");
                    }
                } catch (Exception exception) {
                    System.out.println("¡ERROR! Se ha introducido una palabra en vez de un numero en el precio del producto.");
                    System.out.println("Introduzca java -jar tienda.jar help para ver los parametros.");
                }
            } else {
                System.out.println("¡El numero de argumentos introducidos no son correctos!");
                System.out.println("Teclee java -jar tienda.jar help para ver los parametros necesarios.");
            }
        } else if (args[0].equals("modify")) {
            if (args.length == 10) {
                try {
                    ArrayList<String> toValidate = new ArrayList<String>();
                    toValidate.add(args[2]);
                    toValidate.add(args[3]);
                    toValidate.add(args[4]);
                    toValidate.add(args[6]);
                    toValidate.add(args[7]);
                    toValidate.add(args[8]);

                    if (validarArgs(toValidate)) {
                        contarID = tienda.getMedida();
                        Producto pantiguo = new Producto(Integer.parseInt(args[1]), args[2], args[3], args[4], Integer.parseInt(args[5]));
                        Producto pnuevo = new Producto(contarID, args[6], args[7], args[8], Integer.parseInt(args[9]));
                        tienda.reemplazarProducto(pantiguo, pnuevo);
                        inicializarFichero(tienda);
                        inicializarCSV(tienda);
                    } else {
                        System.out.println("¡Alguno de los argumentos introducidos es incorrecto!");
                        System.out.println("Teclee java -jar tienda.jar help para ver los parametros necesarios.");
                    }
                } catch (Exception exception) {
                    System.out.println("¡ERROR! Se ha introducido una palabra en vez de un numero en el precio del producto.");
                    System.out.println("Introduzca java -jar tienda.jar help para ver los parametros.");
                }
            } else {
                System.out.println("¡El numero de argumentos introducidos no son correctos!");
                System.out.println("Teclee java -jar tienda.jar help para ver los parametros necesarios.");
            }
        } else if (args[0].equals("csv")) {
            inicializarCSV(tienda);
        } else if (args[0].equals("addZara")) {
            if (args.length == 4) {
                try {
                    ArrayList<String> toValidate = new ArrayList<String>();
                    toValidate.add(args[1]);
                    toValidate.add(args[2]);

                    if (validarArgs(toValidate)) {
                        contarID = tienda.getMedida();
                        Zara zara = new Zara(contarID, args[1], args[2], Integer.parseInt(args[3]));
                        tienda.annadirProducto(zara);
                        inicializarFichero(tienda);
                    } else {
                        System.out.println("¡Alguno de los argumentos introducidos es incorrecto!");
                        System.out.println("Teclee java -jar tienda.jar help para ver los parametros necesarios.");
                    }
                } catch (Exception exception) {
                    System.out.println("¡ERROR! Se ha introducido una palabra en vez de un numero en el precio del producto.");
                    System.out.println("Introduzca java -jar tienda.jar help para ver los parametros.");
                }
            } else {
                System.out.println("¡El numero de argumentos introducidos no son correctos!");
                System.out.println("Teclee java -jar tienda.jar help para ver los parametros necesarios.");
            }
        } else if (args[0].equals("addMango")) {
            if (args.length == 4) {
                try {
                    ArrayList<String> toValidate = new ArrayList<String>();
                    toValidate.add(args[1]);
                    toValidate.add(args[2]);

                    if (validarArgs(toValidate)) {
                        contarID = tienda.getMedida();
                        Mango Mango = new Mango(contarID, args[1], args[2], Integer.parseInt(args[3]));
                        tienda.annadirProducto(Mango);
                        inicializarFichero(tienda);
                    } else {
                        System.out.println("¡Alguno de los argumentos introducidos es incorrecto!");
                        System.out.println("Teclee java -jar tienda.jar help para ver los parametros necesarios.");
                    }
                } catch (Exception exception) {
                    System.out.println("¡ERROR! Se ha introducido una palabra en vez de un numero en el precio del producto.");
                    System.out.println("Introduzca java -jar tienda.jar help para ver los parametros.");
                }
            } else {
                System.out.println("¡El numero de argumentos introducidos no son correctos!");
                System.out.println("Teclee java -jar tienda.jar help para ver los parametros necesarios.");
            }
        } else if (args[0].equals("addNike")){
            if (args.length == 4){
                try{
                    ArrayList<String> toValidate = new ArrayList<String>();
                    toValidate.add(args[1]);
                    toValidate.add(args[2]);

                    if (validarArgs(toValidate)){
                        contarID = tienda.getMedida();
                        Nike Nike = new Nike(contarID, args[1], args[2], Integer.parseInt(args[3]));
                        tienda.annadirProducto(Nike);
                        inicializarFichero(tienda);
                    } else {
                        System.out.println("¡Alguno de los argumentos introducidos es incorrecto!");
                        System.out.println("Teclee java -jar tienda.jar help para ver los parametros necesarios.");
                    }
                }catch (Exception exception){
                    System.out.println("¡ERROR! Se ha introducido una palabra en vez de un numero en el precio del producto.");
                    System.out.println("Introduzca java -jar tienda.jar help para ver los parametros.");
                }
            } else {
                System.out.println("¡El numero de argumentos introducidos no son correctos!");
                System.out.println("Teclee java -jar tienda.jar help para ver los parametros necesarios.");
            }
        } else {
            System.out.println("¡El argumento introducido no es correcto!");
            System.out.println("Introduzca java -jar tienda.jar help para ver los comandos disponibles");
        }
    }

    /**
     * Método para guardar la información en formato .txt de una tienda
     * @param tienda Objeto tienda
     */
    private static void inicializarFichero(Tienda tienda){
        try{
            FileWriter fw = new FileWriter(NOMBRE_FICHERO);
            fw.write(tienda.toString());
            fw.close();
        } catch (Exception e){
            System.out.println(e);
            System.out.println("No se ha podido guardar el archivo");
        }
    }

    /**
     * Método para guardar la información en formato .CSV de una tienda
     * @param tienda Objecto tienda
     */
    private static void inicializarCSV(Tienda tienda){
        try {
            FileWriter fw = new FileWriter(NOMBRE_CSV);
            fw.write(tienda.toCSV());
            fw.close();
        } catch (Exception e){
            System.out.println(e);
            System.out.println("No se ha podido guardar el archivo");
        }
    }

    /**
     * Método para cargar los datos del fichero
     * @param nombreFichero path del fichero
     * @return Objeto Tienda
     */
    private static Tienda inicializarTienda(String nombreFichero){
        Tienda tienda = new Tienda();
        try{
            File file = new File(nombreFichero);
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                String uno = sc.next();
                int contarId = Integer.parseInt(sc.next());
                String dos = sc.next();
                String marca = sc.next();
                String tres = sc.next();
                String nombre = sc.next();
                String cuatro = sc.next();
		        String talla = sc.next();
		        String cinco = sc.next();
                int precioProducto = Integer.parseInt(sc.next());
                Producto producto = new Producto(contarId, marca, nombre, talla, precioProducto);
                tienda.annadirProducto(producto);
            }
            sc.close();
        } catch (FileNotFoundException e){
            inicializarFichero(tienda);
        } catch (Exception e){
            System.out.println(e);
        }
        return tienda;
    }
}