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

package dominio;

/**
 * Clase Producto que contiene getter y setters de iD, marca, nombre, talla y precioProducto y el método toString
 * @author Serena Blanco
 * @author Juan Cordero
 * @author Yolanda Llop
 * @author Rita Barragan
 * @version 2.0, 16/12/2020
 */
public class Nike extends Producto {

    /**
     * Constructor que usa los atributos de la clase producto a través del extends
     * @param iD iD del producto
     * @param nombre Nombre del producto
     * @param talla Talla del producto
     * @param precioProducto Precio del producto
     */
    public Nike(int iD, String nombre, String talla, int precioProducto){
        super(iD, nombre, talla, precioProducto);
        super.marca = "Nike";
    }

    /**
     * Método para devolver la información de la clase en formato String
     * @return Info en formato String
     */
    @Override
    public String toString(){
        return "ID:" + " " + iD + " " + "Marca:" + " " + marca + " " + "Tipo:" +
                " " + nombre + " " + "Talla:" + " " + talla + " " + "Precio:" + " " +
                precioProducto;
    }

    /**
     * Método para devolver la información de la clase en formato String
     * @return Info en formato String
     */
    @Override
    public String toCSV(){
        return "ID:" + "," + iD + "," + "Marca:" + "," + marca + "," + "Tipo:" +
                "," + nombre + "," + "Talla:" + "," + talla + "," + "Precio:" + "," +
                precioProducto;
    }
}
