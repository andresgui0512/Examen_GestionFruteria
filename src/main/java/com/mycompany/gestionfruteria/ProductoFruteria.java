/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionfruteria;

/**
 *
 * @author andre
 */
class ProductoFruteria {
    private final String nombre;
    private final double precioKilo;
    private double pesoDisponible;

    public ProductoFruteria(String nombre, double precioKilo, double pesoDisponible) {
        this.nombre = nombre;
        this.precioKilo = precioKilo;
        this.pesoDisponible = pesoDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioKilo() {
        return precioKilo;
    }

    public double getPesoDisponible() {
        return pesoDisponible;
    }

    public void venderProducto(double peso) {
        if (peso <= pesoDisponible) {
            pesoDisponible -= peso;
            System.out.println("Producto vendido: " + nombre + " (" + peso + " kg)");
        } else {
            System.out.println("No hay suficiente peso disponible de " + nombre);
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Precio por Kilo: $" + precioKilo + ", Peso Disponible: " + pesoDisponible + " kg";
    }
}