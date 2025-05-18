/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sesion14;
import java.util.Scanner;
/**
 *
 * @author subkel
 */
public class Sesion14 {

    public static void main(String[] args) {
         ArbolAVL arbol = new ArbolAVL();
        try (Scanner scanner = new Scanner(System.in)) {
            String entrada;
            
            while (true) {
                System.out.println("\nMENÚ:");
                System.out.println("1. Insertar número");
                System.out.println("2. Buscar número");
                System.out.println("3. Mostrar árbol");
                System.out.println("4. Salir (escriba 'exit' o -1)");
                System.out.print("Seleccione una opción: ");
                entrada = scanner.nextLine();
                
                if (entrada.equalsIgnoreCase("exit") || entrada.equals("-1")) {
                    System.out.println("Programa terminado.");
                    break;
                }
                
                switch (entrada) {
                    case "1" -> {
                        System.out.print("Ingrese un número a insertar: ");
                        try {
                            int valor = Integer.parseInt(scanner.nextLine());
                            arbol.insertar(valor);
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Debe ser un número entero.");
                        }
                    }
                        
                    case "2" -> {
                        System.out.print("Ingrese un número a buscar: ");
                        try {
                            int valor = Integer.parseInt(scanner.nextLine());
                            int resultado = arbol.buscar(valor);
                            if (resultado != -1) {
                                System.out.println("Número encontrado: " + resultado);
                            } else {
                                System.out.println("Número NO encontrado en el árbol.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Debe ser un número entero.");
                        }
                    }
                        
                    case "3" -> {
                        System.out.println("\nÁrbol AVL:");
                        arbol.mostrarArbol();
                    }
                        
                    default -> System.out.println("Opción inválida. Intente de nuevo.");
                }
            }
        }
    }
       
        
        //---ArbolAVL miArbol = new ArbolAVL();
//        miArbol.insertar(1);
//        miArbol.insertar(3);
//        miArbol.insertar(5);
//        miArbol.insertar(7);
//        miArbol.insertar(9);
//        miArbol.insertar(11);
//        miArbol.insertar(13);
//        miArbol.insertar(15);
//        miArbol.insertar(17);
//        miArbol.insertar(19);
//        miArbol.insertar(21);
//        //miArbol.mostrarArbol();
    }
    
    
        
    

