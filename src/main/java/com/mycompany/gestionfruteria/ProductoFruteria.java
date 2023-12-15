/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionfruteria;

import static com.mycompany.gestionfruteria.GestionFruteria.relojStopWatch;

/**
 * La clase ProductoFruteria tiene los atributos nombre, precioKilo
 * y pesoDisponible, un constructor los getters y dos métodos, de esta clase
 * se crearán los distintos productos que se almacenará en un array en la clase
 * GestionFruteria.
 * 
 * @author ChatGpt.
 * @author Andrés Guillén.
 */
class ProductoFruteria {
    private final String nombre;
    private final double precioKilo;
    private double pesoDisponible;

    /**
     * El constructor ProductoFruteria recibe unos argumentos y se los asigna
     * a los atributos de la clase.
     * 
     * @param nombre Es un String y su valor es asignado al atributo de la clase nombre.
     * @param precioKilo Es un double y su valor es asignado al atributo de la clase precioKilo.
     * @param pesoDisponible Es un double y su valor es asignado al atributo de clase pesoDisponible.
     */
    public ProductoFruteria(String nombre, double precioKilo, double pesoDisponible) {
        this.nombre = nombre;
        this.precioKilo = precioKilo;
        this.pesoDisponible = pesoDisponible;
    }

    /**
     * getNombre. 
     * @return La variable de tipo String nombre.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * getPrecioKilo. 
     * @return La variable de tipo double precioKilo.
     */
    public double getPrecioKilo() {
        return precioKilo;
    }
    
    /**
     * getPesoDisponible. 
     * @return La variable de tipo double pesoDisponible.
     */
    public double getPesoDisponible() {
        return pesoDisponible;
    }

    /**
     * El método venderProducto recibe un parámetro llamado peso y si el 
     * valor de este es menor o igual al de la variable pesoDisponible lo resta
     * y muestra por pantalla el nombre del producto y su peso restado, sino 
     * muestra un mensaje señalando que no hay suficiente pesoDisponible.
     * 
     * @param peso Es un double y su valor será comparado con el de precioDisponible.
     */
    public void venderProducto(double peso) {
        relojStopWatch.start();
        
        if (peso <= pesoDisponible) {
            pesoDisponible -= peso;
            System.out.println("Producto vendido: " + nombre + " (" + peso + " kg)");
        } else {
            System.out.println("No hay suficiente peso disponible de " + nombre);
        }
        
        System.out.println("venderProducto/ProductoFruteria Tiempo transcurrido: "+relojStopWatch.elapsedMillis()+" milisegundos.");
        relojStopWatch.stop();
    }

    /**
     * El método toString sobrescribe al método toString de la clase Object,
     * y retorna los atributos del objeto ProductoFruteria.
     * 
     * @return Un String con información que presenta el valor de los atributos.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Precio por Kilo: $" + precioKilo + ", Peso Disponible: " + pesoDisponible + " kg";
    }
}