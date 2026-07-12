package com.tp.redes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {


    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        ArrayList<String> nombres = new ArrayList<>();

        // --- EJERCICIO 1 ---
        System.out.println("=== EJERCICIO 1 ===");
        System.out.println("Por favor, ingresá 5 nombres:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Nombre " + (i + 1) + ": ");
            nombres.add(teclado.nextLine());
        }
        
        System.out.println("\nLista completa: " + nombres);
        System.out.println("Cantidad de elementos: " + nombres.size());
        if (!nombres.isEmpty()) {
            System.out.println("Primer elemento: " + nombres.get(0));
            System.out.println("Último elemento: " + nombres.get(nombres.size() - 1));
        }
        
        System.out.println("\nExtra (Mayúsculas):");
        for (String n : nombres) {
            System.out.println("- " + n.toUpperCase());
        }

        // --- EJERCICIO 2  ---
        System.out.println("\n=== EJERCICIO 2 ===");
        System.out.print("Ingresá un nombre para buscar: ");
        String buscar = teclado.nextLine();
        
        if (nombres.contains(buscar)) {
            System.out.println(VERDE + "¡Existe! Está en la posición (índice): " + nombres.indexOf(buscar) + RESET);
        } else {
            
            System.out.println(ROJO + "El nombre ingresado no existe en la lista." + RESET);
        }

        // --- EJERCICIO 3 ---
        System.out.println("\n=== EJERCICIO 3 ===");
        if (nombres.size() >= 3) {
            System.out.print("Ingresá el nuevo valor para reemplazar al tercer elemento (" + nombres.get(2) + "): ");
            String nuevoValor = teclado.nextLine();
            nombres.set(2, nuevoValor); // Reemplaza en el índice 2 (tercer elemento)
        }
        
        System.out.print("Ingresá un nombre exacto de la lista para eliminar: ");
        String eliminar = teclado.nextLine();
        boolean eliminado = nombres.remove(eliminar); // Elimina por objeto/nombre
        
        if (eliminado) {
            System.out.println(VERDE + "Elemento eliminado correctamente." + RESET);
        } else {
            System.out.println("No se encontró el elemento para eliminar.");
        }
        System.out.println("Lista final: " + nombres);

        // --- EJERCICIO 4 ---
        System.out.println("\n=== EJERCICIO 4 ===");
        

        System.out.println("Nota del error típico: Si usáramos 'i <= nombres.size()', "
                + "daría un error IndexOutOfBoundsException porque los índices van de 0 a size()-1.");
        
        System.out.println("\n1) For clásico (Índice):");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println(AMARILLO + "Índice " + i + ": " + nombres.get(i) + RESET);
        }
        
        System.out.println("\n2) For-each:");
        for (String n : nombres) {
            System.out.println(AZUL + "Nombre: " + n + RESET);
        }
        
        System.out.println("\n3) Iterator:");
        Iterator<String> it = nombres.iterator();
        while (it.hasNext()) {
            System.out.println(VERDE + "Elemento: " + it.next() + RESET);
        }

        teclado.close();
        System.out.println("\n=== Bloque 1 finalizado ===");
    }
}