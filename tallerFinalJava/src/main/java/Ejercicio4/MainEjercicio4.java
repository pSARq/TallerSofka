/*
Lee un número por teclado que pida el precio de un producto (puede tener decimales) y
calcule el precio final con IVA. El IVA sera una constante que sera del 21%.
 */

package Ejercicio4;

import java.util.Scanner;

public class MainEjercicio4 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        float precioProducto, precioFinal;
        final int IVA = 21;

        System.out.print("Ingrese el valor del producto: ");
        precioProducto = entrada.nextFloat();

        precioFinal = precioProducto + precioProducto * IVA / 100;

        System.out.println("El precio final del producto es de: " +precioFinal);
    }

}
