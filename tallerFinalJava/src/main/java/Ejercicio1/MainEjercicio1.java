/*
Declara 2 variables numéricas (con el valor que desees), he indica cual es mayor de los dos.
Si son iguales indicarlo también. Ve cambiando los valores para comprobar que funciona.
 */
package Ejercicio1;

import jdk.nashorn.api.tree.IfTree;

public class MainEjercicio1 {

    public static void main(String[] args) {
        double numero1 = 8.0;
        double numero2 = 5.0;

        if(numero1 == numero2){
            System.out.println("Los números son iguales");
        }else if (numero1 > numero2){
            System.out.println("El número " +numero1+ " es mayor que el número " +numero2);
        }else{
            System.out.println("El número " +numero2+ " es mayor que el número " +numero1);
        }
    }


}
