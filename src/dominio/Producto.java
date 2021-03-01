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
public class Producto{
    protected String marca;
    protected String nombre;
    protected String talla;
    protected int precioProducto;
    protected int iD = 0;
 
    /**
     * Constructor por defecto
     */
    public Producto(){
        iD = Integer.parseInt("");
        marca = "";
        nombre = "";
        talla = "";
        precioProducto = Integer.parseInt("");
    }


    /**
     * Constructor con parámetros
     * @param iD iD del producto
     * @param marca Marca del producto
     * @param nombre Nombre del producto
     * @param talla Talla del producto
     * @param precioProducto Precio del producto
     */
    public Producto(int iD, String marca, String nombre, String talla, int precioProducto){
        this.iD = iD;
        this.marca = marca;
        this.nombre = nombre;
        this.talla = talla;
        this.precioProducto = precioProducto;
    }

    /**
     * Segundo constructor con todos los parámetros menos la marca
     * @param iD iD del producto
     * @param nombre Nombre del producto
     * @param talla Talla del producto
     * @param precioProducto Precio del producto
     */
    public Producto(int iD, String nombre, String talla, int precioProducto){
        this.iD = iD;
        this.nombre = nombre;
        this.talla = talla;
        this.precioProducto = precioProducto;
    }

    /**
     * Método para obtener la marca del producto
     * @return Marca del producto
     */
    public String getMarca(){
        return marca;
    }
 
    /**
     * Método para establecer la marca del producto
     * @param marca Nueva marca
     */
    public void setMarca(String marca){
        this.marca = marca;
    }
 
    /**
     * Método para obtener el nombre del producto
     * @return Nombre del producto
     */
    public String getNombre(){
        return nombre;
    }
 
    /**
     * Método para establecer el nombre del producto
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
 
    /**
     * Método para obtener la talla del producto
     * @return Nombre de la talla
     */
    public String getTalla(){
        return talla;
    }
 
    /**
     * Método para establecer la talla del producto
     * @param talla Nueva talla
     */
    public void setTalla(String talla){
        this.talla = talla;
    }
 
    /**
     * Método para obtener el precio del producto
     * @return Precio del producto
     */
    public int getPrecioProducto(){
        return precioProducto;
    }
 
    /**
     * Método para establecer el precio del producto
     * @param pProducto Nuevo precio
     */
    public void setPrecioProducto(int pProducto){
        this.precioProducto = pProducto;
    }

    /**
     * Método para obtener la id del producto
     * @return iD del producto
     */
    public int getiD() {
        return iD;
    }

    /**
     * Método para establecer la iD del producto
     * @param iD Nueva iD
     */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * Método para comprobar si determinar si dos instancias son iguales
     * @param object Instancia a comparar
     * @return true si son iguales y false al contrario
     */
    public boolean equals(Object object){
        Producto producto = (Producto) object;
        if (iD == producto.getiD()){
            return true;
        }else{
            return false;
        }
    }
 
    /**
     * Método para devolver la información de la clase en formato String
     * @return Info en formato String
     */
    public String toString(){
        return "ID:" + " " + iD + " " + "Marca:" + " " + marca + " " + "Tipo:" +
                " " + nombre + " " + "Talla:" + " " + talla + " " + "Precio:" + " " +
                precioProducto;
    }
 
    /**
     * Método para devolver la información de la clase en formato String
     * @return Info en formato String
     */
    public String toCSV(){
        return "ID:" + "," + iD + "," + "Marca:" + "," + marca + "," + "Tipo:" +
                "," + nombre + "," + "Talla:" + "," + talla + "," + "Precio:" + "," +
                precioProducto;
    }
}
