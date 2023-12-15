/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionfruteria;

import com.stopwatch.IStopWatch;
import com.stopwatch.StopWatch;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * La clase GestionFruteria posee un atributo llamado inventario que es un ArrayList
 * en donde se almacenan todos los objetos de la clase ProductoFruteria, podemos agregar
 * productos al ArrayList, mostrarlos por pantalla y restar su parámetro de peso.
 * 
 * @author ChatGpt.
 * @author Andrés Guillén.
 */
public class GestionFruteria {
    final ArrayList<ProductoFruteria> inventario;
    static IStopWatch relojStopWatch;

    /**
     * Constructor de la clase GestionFruteria 
     * define a la variable inventario como un nuevo ArrayList
     * y la variable relojStopWatch como un StopWatch.create().
     */
    public GestionFruteria() {
        inventario = new ArrayList<>();
        relojStopWatch =StopWatch.create();
    }

    /**
     * El método agregarProducto recibe unos parámetros, crea un objeto de ProductoFruteria
     * y le pasa esos parámetros como argumento, luego muestra por pantalla el producto. 
     * 
     * @param nombre Es un String que va a representar el nombre del producto.
     * @param precioKilo Es un double que representa el precio por kilo del producto.
     * @param pesoDisponible Es un double que almacena el peso disponible. 
     */
    public void agregarProducto(String nombre, double precioKilo, double pesoDisponible) {
        relojStopWatch.start();
        
        ProductoFruteria nuevoProducto = new ProductoFruteria(nombre, precioKilo, pesoDisponible);
        inventario.add(nuevoProducto);
        System.out.println("Producto agregado: " + nuevoProducto);
        
        System.out.println("agregarProducto Tiempo transcurrido: "+relojStopWatch.elapsedMillis()+" milisegundos.");
        relojStopWatch.stop();
    }

    /**
     * El método mostrarInventario confirma primero si hay objetos dentro del array
     * inventario si es así muestra por pantalla los objetos almacenados, pero si no hay
     * muestra un mensaje señalando que está vacío.
     */
    public void mostrarInventario() {
        relojStopWatch.start();
        
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario de la frutería:");
            for (ProductoFruteria producto : inventario) {
                System.out.println(producto);
            }
        }
        
        System.out.println("mostrarInventario Tiempo transcurrido: "+relojStopWatch.elapsedMillis()+" milisegundos.");
        relojStopWatch.stop();
    }

    /**
     * El método venderProducto recibe unos parametros y en base a estos 
     * buscará un producto para venderlo, si no se encuentra el producto muestra un 
     * mensaje de ausencia y si lo encuentra llama al método venderProducto de la clase
     * ProductoFruteria y le pasa como argumento el peso.
     * 
     * @param nombre Es un String y en base a este se buscará al objeto dentro del array.
     * @param peso Es un double y su valor restará el pesoDisponible del objeto seleccionado.
     */
    public void venderProducto(String nombre, double peso) {
        relojStopWatch.start();
          
        boolean encontrado = false;
        for (ProductoFruteria producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.venderProducto(peso);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado en el inventario.");
        }      
        System.out.println("venderProducto Tiempo transcurrido: "+relojStopWatch.elapsedMillis()+" milisegundos.");
        relojStopWatch.stop();
    }

    /**
     * El método adaptadorNumero recibe un valor y elimina
     * el signo negativo (si lo tiene) y reemplaza la coma
     * por un punto para luego devolver una variable de tipo double.
     * Este método fue creado para evitar que los usuarios ingresen
     * números no válidos para el buen funcionamiento del programa.
     * 
     * @param numero Es un String y si este posee un signo negativo
     * será eliminado y si posee una coma será sustituido por un punto.
     * @return Retorna un double sin negativo.
     */
    public double adaptadorNumero(String numero){
        relojStopWatch.start();    
        
        String numeroSinNegativo = numero.startsWith("-") ? numero.substring(1) : numero;
        String reemplazar = numeroSinNegativo.replace(",", ".");
        double numeroConPunto = Double.parseDouble(reemplazar);
 
        System.out.println("adaptadorNumero Tiempo transcurrido: "+relojStopWatch.elapsedMillis()+" milisegundos.");
        relojStopWatch.stop();
        
        return numeroConPunto;
    }
    
    /**
     * El método soloLetras recibe un String y devuelve un valor booleano
     * si este contiene solo letras o no. Este método fue hecho con el 
     * propósito de que el usuario ingrese un nombre correcto al producto.
     * 
     * @param nombre Es un String y puede contener cualquier conjunto de caracteres.
     * @return Retorna verdadero o falso dependiendo de si el String nombre
     * solo contiene letras.
     */
    public boolean soloLetras(String nombre){

        return nombre.matches("[a-zA-Z]+");
    }
    
    /**
     * El main muestra unas opciones identificadas por un número que puedes realizar con el programa,
     * el usuario escribe un número y de acuerdo al mismo el main puede pedirle unos datos para llamar 
     * al método correspondiente el cual se encargará de realizar el resto del trabajo.
     * 
     * @param args parámetro por defecto del main.
     */
    public static void main(String[] args) {
        
        GestionFruteria gestionFruteria = new GestionFruteria();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar producto al inventario");
            System.out.println("2. Mostrar inventario de la frutería");
            System.out.println("3. Vender producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try{
            int opcion = scanner.nextInt();
            scanner.nextLine();// Consumir el salto de línea después del número
            
                     switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();  
                    
                    //Comprueba si el usuario introdujo un nombre con solo letras
                    //de no ser así muestra un mensaje y detiene la ejecución.
                    if(gestionFruteria.soloLetras(nombre)==false){
                        System.out.println("Por favor ingrese un nombre válido");
                        break;
                    }
                    
                    System.out.print("Ingrese el precio por kilo del producto: $");
                    String cadenaPrecioKilo = scanner.nextLine();    
                    
                    //Si el número ingresado tiene un signo negativo se lo quita y si tiene 
                    //una coma lo cambia por un punto.
                    double precioKilo= gestionFruteria.adaptadorNumero(cadenaPrecioKilo);
                            
                    System.out.print("Ingrese el peso disponible del producto en kilos: ");
                    String cadenaPeso = scanner.nextLine();                               
                    double peso= gestionFruteria.adaptadorNumero(cadenaPeso);
                    
                    gestionFruteria.agregarProducto(nombre, precioKilo, peso);
                    break;
                case 2:
                    gestionFruteria.mostrarInventario();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto a vender: ");
                    String productoVender = scanner.nextLine();
                    
                    System.out.print("Ingrese el peso a vender en kilos: ");
                    String cadenaPesoVender = scanner.nextLine();
                    double pesoVender = gestionFruteria.adaptadorNumero(cadenaPesoVender);                    
                    gestionFruteria.venderProducto(productoVender, pesoVender);
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }             
            
            }catch(InputMismatchException | NumberFormatException e){
                System.out.println("Opción no válida, por favor inténtelo de nuevo.");
                scanner.nextLine(); 
            }
        }
    }
}