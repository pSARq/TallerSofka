/*
Lee un número por teclado y comprueba que este numero es mayor o igual que cero, si no lo es lo volverá a
pedir (do while), después muestra ese número por consola.
 */

package Ejercicio7;

import java.util.Scanner;

public class MainEjercicio8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double numero;

        do {
            System.out.print("Ingrese un número igual o mayor a 0: ");
            numero = entrada.nextDouble();
        } while (numero < 0);

        System.out.println("El número que ingresaste es: " +numero);


    }
}
