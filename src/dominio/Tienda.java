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

import java.util.ArrayList;

/**
 * Clase tienda que contiene una ArrayList de producto
 * @author Serena Blanco
 * @author Juan Cordero
 * @author Yolanda Llop
 * @author Rita Barragan
 * @version 2.0, 16/12/2020
 */
    public class Tienda{
    private ArrayList<Producto> coleccionProductos = new ArrayList<>();

    /**
     * Método para añadir un producto a la Tienda
     * @param producto Objeto Producto a añadir
     */
    public void annadirProducto(Producto producto){
        coleccionProductos.add(producto);
    }

    /**
     * Método para borrar un producto de la tienda
     * @param productoABorrar Producto a borrar
     */
    public void borrarProducto(Producto productoABorrar){
        boolean borrado = false;
        for(int i = coleccionProductos.size()-1; i >=0; i--){
            if(coleccionProductos.get(i).toString().equals(productoABorrar.toString())){
                coleccionProductos.remove(i);
                borrado = true;
            }
        }
        if (borrado){
            System.out.println(productoABorrar.toString() + " se ha borrado");
        }else{
            System.out.println(productoABorrar.toString() + " no existe ese producto en la lista");
        }
    }

    /**
     * Método para reemplazar un producto de la tienda por otro
     * @param pAntiguo Producto que se quiere reemplazar
     * @param pNuevo Producto por el que se reemplaza
     */
    public void reemplazarProducto(Producto pAntiguo, Producto pNuevo){
        boolean modificar = false;
        for (int i = coleccionProductos.size()-1; i >=0; i--){
            if (coleccionProductos.get(i).toString().equals(pAntiguo.toString())){
                coleccionProductos.set(i, pNuevo);
                modificar = true;
            }
        }
        if (modificar){
            System.out.println(pAntiguo.toString() + ", ha sido modificado por " + pNuevo.toString());
        }else{
            System.out.println(pAntiguo.toString() + " No existe ese producto en la lista");
        }
    }

    /**
     * Método para obtener el tamaño del producto
     * @return el tamaño del producto
     */
    public int getMedida(){
        if (coleccionProductos.size() == 0){
            return 1;
        } else{
            return coleccionProductos.get(coleccionProductos.size()-1).getiD()+1;
        }
    }

    /**
     * Método para devolver la información de la clase en formato String
     * @return Info en formato String
     */
    public String toString(){
        StringBuilder datos = new StringBuilder();
        for (Producto producto : coleccionProductos){
            datos.append(producto.toString() + "\n");
        }
        return datos.toString();
    }

    /**
     * Método para devolver la información de la clase en formato String
     * @return Info en formato String
     */
    public String toCSV(){
        StringBuilder datos = new StringBuilder();
        for (Producto producto : coleccionProductos){
            datos.append(producto.toCSV() + "\n");
        }
        return datos.toString();
    }
}


