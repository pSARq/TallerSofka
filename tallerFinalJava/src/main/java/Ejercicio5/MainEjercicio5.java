/*
Muestra los números impares y pares del 1 al 100 (ambos incluidos). Usa un bucle while.
 */

package Ejercicio5;

public class MainEjercicio5 {
    public static void main(String[] args) {
        String numerosPar = "", numerosImpar = "";
        int i = 1;

        while (i <= 100){
            if (i%2 == 0){
                numerosPar += i + ", ";
            }else{
                numerosImpar += i + ", ";
            }
            i++;
        }

        System.out.println("Los números par entre 1 y 100 son: " +numerosPar+ "\nLos numeros impar entre 1 y 100 " +
                "son: " +numerosImpar);
    }
}
