/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.gestionfruteria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * La clase ProductoFruteriaTest contiene un conjunto de test 
 * para los métodos de la clase ProductoFruteria.
 * 
 * @author Andrés Guillén.
 */
public class ProductoFruteriaTest {
    
    /**
     * Constructor de la clase ProductoFruteriaTest.
     */
    public ProductoFruteriaTest() {
    }

    /**
     * Test del método getNombre de la clase ProductoFruteria.
     * 
     * Crea un producto con unos atributos y comprueba si el método
     * getNombre devuelve el valor del atributo nombre.
     */
    @Test
    public void testGetNombre() {
        ProductoFruteria instance = new ProductoFruteria("mango",2.6,20.3);
        String expResult = "mango";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test del método getPrecioKilo de la clase ProductoFruteria.
     * 
     * Crea un producto con unos atributos y comprueba si el método
     * getPrecioKilo devuelve el valor del atributo precioKilo.
     */
    @Test
    public void testGetPrecioKilo() {
        ProductoFruteria instance = new ProductoFruteria("mango",2.6,20.3);
        double expResult = 2.6;
        double result = instance.getPrecioKilo();
        assertEquals(expResult, result);
    }

    /**
     * Test del método getPesoDisponible de la clase ProductoFruteria.
     * 
     * Crea un producto con unos atributos y comprueba si el método
     * getPesoDisponible devuelve el valor del atributo pesoDisponible.
     */
    @Test
    public void testGetPesoDisponible() {
        ProductoFruteria instance = new ProductoFruteria("mango",2.6,20.3);
        double expResult = 20.3;
        double result = instance.getPesoDisponible();
        assertEquals(expResult, result);
    }

    /**
     * Test del método toString de la clase ProductoFruteria.
     * 
     * Comprueba si el método toString devuelve los valores de los atributos
     * del prodcuto.
     */
    @Test
    public void testToString() {
        ProductoFruteria instance = new ProductoFruteria("mango",2.6,20.3);
        String expResult = "Nombre: mango, Precio por Kilo: $2.6, Peso Disponible: 20.3 kg";
        String result = instance.toString();
        assertEquals(expResult, result);
    }  
}
