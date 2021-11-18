/*
Crear un programa que pida un numero por teclado y que imprima por pantalla los números desde el
numero introducido hasta 1000 con saldos de 2 en 2.
 */

package Ejercicio14;

import java.util.Scanner;

public class MainEjercicio14 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String entradaDatos;
        boolean esEntero = false;
        int numero = 0;

        do {
            System.out.print("Digite un número entero: ");
            entradaDatos = entrada.next();

            try {
                numero = Integer.parseInt(entradaDatos);
                esEntero = true;
            }catch (NumberFormatException e){
                System.out.println("\nIngrese un número entero\n");
            }
        }while (!esEntero);


        for (int i = numero; i <= 1000; i+= 2) {
            System.out.println(i+ " ");
        }
    }


}
