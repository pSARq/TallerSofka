/*
Pedir dos palabras por teclado, indicar si son iguales, sino son iguales mostrar sus diferencias.
 */

package Ejercicio12;

import java.util.Scanner;

public class MainEjercicio12 {


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String frase1, frase2, diferencias = "";
        int contadorFrase1 = 0, contadorFrase2 = 0;

        System.out.print("Ingrese una palabra: ");
        frase1 = entrada.next();

        System.out.print("Ingrese otra palabra: ");
        frase2 = entrada.next();

        while (contadorFrase1 < frase1.length() && contadorFrase2 < frase2.length()) {
            if (frase1.charAt(contadorFrase1) != frase2.charAt(contadorFrase2)) {
                diferencias += frase1.charAt(contadorFrase1) + "-" + frase2.charAt(contadorFrase2) + ", ";
            }
            contadorFrase1++;
            contadorFrase2++;
        }

        if (contadorFrase1 <= frase1.length()-1){
            while (contadorFrase1 < frase1.length()){
                diferencias += frase1.charAt(contadorFrase1)+ ", ";
                contadorFrase1++;
            }
        }

        if (contadorFrase2 <= frase2.length()-1){
            while (contadorFrase2 < frase2.length()){
                diferencias += frase2.charAt(contadorFrase2)+ ", ";
                contadorFrase2++;
            }
        }

        System.out.println("Palabra1: " + frase1 + "\nPalabra2: " + frase2 + "\nSe diferencian en las siguientes letras: " + diferencias);
    }
}
