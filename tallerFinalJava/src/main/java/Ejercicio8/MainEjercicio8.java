/*
Crea una aplicación por consola que nos pida un día de la semana y que nos diga si es un día laboral o no.
Usa un switch para ello.
 */

package Ejercicio8;

import java.util.Scanner;

public class MainEjercicio8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        String entradaDatos;
        boolean esEntero = false;

        do {
            System.out.print("1.Lunes \n2.Martes \n3.Miercoles \n4.Jueves \n5.Viernes" +
                    "\n6.Sabado \n7.Domingo \nIngrese el número del dia de la semana: ");
            entradaDatos = entrada.next();

            try {
                opcion = Integer.parseInt(entradaDatos);
                esEntero = true;
            }catch (NumberFormatException e){
                System.out.println("\nIngrese un número\n");
            }
        }while (!esEntero);

        switch (opcion){
            case 1:
                System.out.println("El lunes es un día laboral");
                break;
            case 2:
                System.out.println("El martes es un día laboral");
                break;
            case 3:
                System.out.println("El miercoles es un día laboral");
                break;
            case 4:
                System.out.println("El jueves es un día laboral");
                break;
            case 5:
                System.out.println("El viernes es un día laboral");
                break;
            case 6:
                System.out.println("El sábado no es un día laboral");
                break;
            case 7:
                System.out.println("El domingo no es un día laboral");
                break;
            default:
                System.out.println("Valor ingresado no valido");
        }

    }
}
