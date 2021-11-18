/*
Muestra los números impares y pares del 1 al 100 (ambos incluidos).
Realiza el ejercicio anterior usando un ciclo for.
 */

package Ejercicio6;

public class MainEjercicio6 {
    public static void main(String[] args) {
        String numerosPar = "", numerosImpar = "";

        for (int i = 0; i <= 100; i++){
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
