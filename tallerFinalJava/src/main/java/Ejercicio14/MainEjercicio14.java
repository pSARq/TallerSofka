/*
Crear un programa que pida un numero por teclado y que imprima por pantalla los números desde el
numero introducido hasta 1000 con saldos de 2 en 2.
 */

package Ejercicio14;

import java.util.Scanner;

public class MainEjercicio14 {

    static int numero = 0;

    public static boolean validarEntero(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        }catch (NumberFormatException e){
            System.out.println("\nIngrese un número entero\n");
            return false;
        }
    }

    public static void pedirNumero(){
        Scanner entrada = new Scanner(System.in);
        String entradaDatos;
        boolean esEntero = false;

        do {
            System.out.print("Digite un número entero: ");
            entradaDatos = entrada.next();
            esEntero = validarEntero(entradaDatos);

        }while (!esEntero);
        numero = Integer.parseInt(entradaDatos);
    }

    public static void mostrarNumeros(){
        for (int i = numero; i <= 1000; i+= 2) {
            System.out.println(i+ " ");
        }
    }

    public static void main(String[] args) {
        pedirNumero();
        mostrarNumeros();
    }


}
