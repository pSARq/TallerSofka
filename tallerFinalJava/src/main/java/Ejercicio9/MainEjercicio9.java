/*
Del texto, “La sonrisa sera la mejor arma contra la tristeza" Reemplaza todas las a del String anterior
por una e, adicionalmente concatenar a esta frase una adicional que ustedes quieran incluir por consola y
las muestre luego unidas.
 */

package Ejercicio9;

import java.util.Scanner;

public class MainEjercicio9 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String frase = "La sonrisa sera la mejor arma contra la tristeza";
        String anexo, nuevaFrase;

        System.out.println(frase);
        System.out.print("Ingrese una continuación de la frase: ");
        anexo = entrada.nextLine();

        nuevaFrase = frase.replace('a', 'e') +" "+ anexo;

        System.out.println(nuevaFrase);

    }
}
