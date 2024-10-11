/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.itson.diccionario.diccionario;

import java.util.HashMap;
import java.util.Scanner;

public class Diccionario {

    public static void main(String[] args) {
        // Crear un diccionario de HashMap
        HashMap<String, String> diccionario = new HashMap<>();
        
        // Elementos del diccionario
        diccionario.put("perro", "dog");
        diccionario.put("gato", "cat");
        diccionario.put("casa", "house");
        diccionario.put("libro", "book");

        try ( // Crear un objeto para leer la entrada del usuario
                Scanner sc = new Scanner(System.in)) {
            String palabra;
            OUTER:
            while (true) {
                System.out.println("\nSelecciona una opcion:");
                System.out.println("1. Buscar palabra");
                System.out.println("2. Ver diccionario completo");
                System.out.println("3. Salir");
                int opcion = sc.nextInt();
                sc.nextLine();
                
                
                switch (opcion) {
                    case 1 -> {
                        // Opcion para buscar palabra
                        System.out.println("Introduce una palabra en español para buscar su traduccion:");
                        palabra = sc.nextLine().toLowerCase();
                        
                        // Validar que la entrada no este vacia
                        if (palabra.trim().isEmpty()) {
                            
                            System.out.println("Por favor, introduce una palabra valida.");
                            
                        } else if (diccionario.containsKey(palabra)) {
                            // Mostrar la traducción si existe
                            
                            System.out.println("La traduccion de '" + palabra + "' es: " + diccionario.get(palabra));
                            
                        } else {
                            // Informar si la palabra no está en el diccionario
                            
                            System.out.println("La palabra '" + palabra + "' no esta en el diccionario.");
                            
                            System.out.println("¿Quieres agregar esta palabra al diccionario? (yes/no)");
                            
                            String respuesta = sc.nextLine().toLowerCase();
                            
                            if (respuesta.equals("yes")) {
                                
                                // Pedir la traducción y agregarla al diccionario
                                
                                System.out.println("Introduce la traduccion de '" + palabra + "': ");
                                String traduccion = sc.nextLine();
                                diccionario.put(palabra, traduccion);
                                System.out.println("Palabra agregada con exito.");
                            }
                        }
                    }
                    case 2 -> {
                        // Opcion para ver el diccionario completo
                        System.out.println("Diccionario actual:");
                        for (String clave : diccionario.keySet()) {
                            System.out.println(clave + " : " + diccionario.get(clave));
                        }
                    }
                    case 3 -> {
                        // Opción para salir del programa
                        System.out.println("Bye");
                        break OUTER;
                    }
                    default -> // Manejar opciones inválidas
                        System.out.println("Opción invalida, selecciona una opcion valida.");
                }
            }
            //
        }
    }
}
