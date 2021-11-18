/*
Declara 2 variables numéricas (con el valor que desees), he indica cual es mayor de los dos.
Si son iguales indicarlo también. Ve cambiando los valores para comprobar que funciona.

Al ejercicio anterior agregar entrada por consola de dos valores e indicar si son mayores, menores o iguales.
 */

package Ejercicio2;

import java.util.Scanner;

public class MainEjercicio2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double numero1;
        double numero2;

        System.out.print("Ingrese un número: ");
        numero1 = entrada.nextDouble();

        System.out.print("Ingrese otro número: ");
        numero2 = entrada.nextDouble();

        if(numero1 == numero2){
            System.out.println("Los números son iguales");
        }else if (numero1 > numero2){
            System.out.println("El número " +numero1+ " es mayor que el número " +numero2);
        }else{
            System.out.println("El número " +numero2+ " es mayor que el número " +numero1);
        }
    }
}
