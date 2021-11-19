/*
Pedir dos palabras por teclado, indicar si son iguales, sino son iguales mostrar sus diferencias.
 */

package Ejercicio12;

import java.util.Scanner;

public class MainEjercicio12 {

    static Scanner entrada = new Scanner(System.in);
    static String frase1, frase2, diferencias = "";

    public static void pedirDatos(){
        System.out.print("Ingrese una palabra: ");
        frase1 = entrada.next();

        System.out.print("Ingrese otra palabra: ");
        frase2 = entrada.next();
    }

    public static void llenarDiferenciasSobrante(String frase, int contador){
        if (contador <= frase.length()-1){
            while (contador < frase.length()){
                diferencias += frase.charAt(contador)+ ", ";
                contador++;
            }
        }
    }

    public static void compararDiferencias(){
        int contadorFrase1 = 0, contadorFrase2 = 0;
        while (contadorFrase1 < frase1.length() && contadorFrase2 < frase2.length()) {
            if (frase1.charAt(contadorFrase1) != frase2.charAt(contadorFrase2)) {
                diferencias += frase1.charAt(contadorFrase1) + "-" + frase2.charAt(contadorFrase2) + ", ";
            }
            contadorFrase1++;
            contadorFrase2++;
        }

        llenarDiferenciasSobrante(frase1, contadorFrase1);
        llenarDiferenciasSobrante(frase2, contadorFrase2);
    }

    public static void main(String[] args) {
        pedirDatos();
        compararDiferencias();

        System.out.println("Palabra1: " + frase1 + "\nPalabra2: " + frase2 + "\nSe diferencian en las siguientes letras: " + diferencias);
    }
}
