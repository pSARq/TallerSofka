/*
Haz una aplicación que calcule el área de un círculo(pi*R2). El radio se pedirá por teclado
(recuerda pasar de String a double con Double.parseDouble). Usa la constante PI y el método pow de Math.
 */

package Ejercicio3;

import org.w3c.dom.TypeInfo;

import java.util.Scanner;

public class MainEjercicio3 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String valorIngresado;
        Double radio, resultado;

        System.out.print("Ingrese el valor del radio (cm): ");
        valorIngresado = entrada.next();

        radio = Double.parseDouble(valorIngresado);
        resultado = Math.PI * Math.pow(radio, 2);

        System.out.println("El área del circulo es: " +resultado+ "cm2");
    }
}
