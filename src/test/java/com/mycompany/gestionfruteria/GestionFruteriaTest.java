/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.gestionfruteria;

import org.junit.jupiter.api.Test;

/**
 * La clase GestionFruteriaTest contiene un conjunto de test 
 * para los métodos de la clase GestionFruteria.
 * 
 * @author Andrés Guillén. 
 */
public class GestionFruteriaTest {
    
    /**
     * Constructor de la clase GestionFruteriaTest.
     */
    public GestionFruteriaTest() {
    }

    /**
     * Test del método agregarProducto de la clase GestionFruteria.
     * 
     * Llama al método y le pasa unos valores promedios.
     */
    @Test
    public void testAgregarProducto() {
        System.out.println("agregarProducto");
        String nombre = "Manzana";
        double precioKilo = 10.9;
        double pesoDisponible = 50.8;
        GestionFruteria instance = new GestionFruteria();
        instance.agregarProducto(nombre, precioKilo, pesoDisponible);
    }

    /**
     * Test del método mostrarInventario de la clase GestionFruteria.
     * 
     * Llama al método mostrarInventario y no hay ningún producto en el inventario.     
     */
    @Test
    public void testMostrarInventarioVacío() {
        System.out.println("mostrarInventarioVacío");
        GestionFruteria instance = new GestionFruteria();
        instance.mostrarInventario();
    }
    
    /**
     * Test del método mostrarInventario de la clase GestionFruteria.
     * 
     * Crea un producto, lo agrega al inventario y llama al método.
     */
    @Test
    public void testMostrarInventario() {
        System.out.println("mostrarInventario");
        GestionFruteria instance = new GestionFruteria();
        String nombre = "Naranja";
        double precioKilo = 12;
        double pesoDisponible = 37;       
        ProductoFruteria nuevoProducto = new ProductoFruteria(nombre, precioKilo, pesoDisponible);
        instance.inventario.add(nuevoProducto);
        instance.mostrarInventario();
    }

    /**
     * Test del método venderProducto de la clase GestionFruteria.
     * 
     * Llama al método venderProducto y no hay ningún producto en el inventario.
     */
    @Test
    public void testVenderProductoVacío() {
        System.out.println("venderProductoVacío");
        String nombre = "Lima";       
        double peso = 3.6;
        GestionFruteria instance = new GestionFruteria();
        instance.venderProducto(nombre, peso);
    }
    
    /**
     * Test del método venderProducto de la clase GestionFruteria.
     * 
     * Crea un producto, lo agrega al inventario y
     * le pasa los argumentos nombre y peso al método venderProducto.
     */
    @Test
    public void testVenderProducto() {
        System.out.println("venderProducto");
        GestionFruteria instance = new GestionFruteria();
        double peso = 3.6;
        String nombre = "Lima";
        double precioKilo = 12;
        double pesoDisponible = 37;   
        ProductoFruteria nuevoProducto = new ProductoFruteria(nombre, precioKilo, pesoDisponible);
        instance.inventario.add(nuevoProducto);
        instance.venderProducto(nombre, peso);
    }
    
    /**
     * Test del método venderProducto de la clase GestionFruteria.
     * 
     * Crea un producto, lo agrega al inventario y
     * le pasa los argumentos nombrePrueba (que en este caso
     * está escrito en mayúscula) y peso al método venderProducto.
     */
    @Test
    public void testVenderProductoNombreMayuscula() {
        System.out.println("venderProducto");
        GestionFruteria instance = new GestionFruteria();
        double peso = 3.6;
        String nombre = "Lima";
        String nombrePrueba = "lImA";
        double precioKilo = 10;
        double pesoDisponible = 10;   
        ProductoFruteria nuevoProducto = new ProductoFruteria(nombre, precioKilo, pesoDisponible);
        instance.inventario.add(nuevoProducto);
        instance.venderProducto(nombrePrueba, peso);
    }
  
}
