/*
Realizar una aplicación de consola, que al ingresar una frase por teclado elimine los espacios que esta contenga.
 */

package Ejercicio10;


import java.util.Scanner;

public class MainEjercicio10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String frase, nuevaFrase;

        System.out.print("Ingrese una frase: ");
        frase = entrada.nextLine();

        nuevaFrase = frase.replace(" ", "");
        System.out.println(nuevaFrase);
    }
}
