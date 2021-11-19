/*
Realizar la construcción de un algoritmo que permita de acuerdo a una frase pasada por consola,
indicar cual es la longitud de esta frase, adicionalmente cuantas vocales tiene de “a,e,i,o,u".
 */

package Ejercicio11;

import java.util.Scanner;

public class MainEjercicio11 {

    static Scanner entrada = new Scanner(System.in);
    static int contadorA = 0, contadorE = 0, contadorI = 0, contadorO = 0, contadorU = 0;
    static String frase;

    public static void pedirFrase(){
        System.out.print("Ingrese una oración: ");
        frase = entrada.nextLine();
    }

    public static void contarVocales(){
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 'a' || frase.charAt(i) == 'A'){
                contadorA++;
            }else if (frase.charAt(i) == 'e' || frase.charAt(i) == 'E'){
                contadorE++;
            }else if (frase.charAt(i) == 'i' || frase.charAt(i) == 'I'){
                contadorI++;
            }else if(frase.charAt(i) == 'o' || frase.charAt(i) == 'O'){
                contadorO++;
            }else if (frase.charAt(i) == 'u' || frase.charAt(i) == 'U'){
                contadorU++;
            }
        }
    }

    public static void mostrarConteoVocales(){
        System.out.println("La vocal 'a' aparece " +contadorA+ " veces en el texto \n" +
                "La vocal 'e' aparece " +contadorE+ " veces en el texto \n" +
                "La vocal 'i' aparece " +contadorI+ " veces en el texto \n" +
                "La vocal 'o' aparece " +contadorO+ " veces en el texto \n" +
                "La vocal 'U' aparece " +contadorU+ " veces en el texto");
    }

    public static void main(String[] args) {

        pedirFrase();
        contarVocales();
        mostrarConteoVocales();


    }
}
