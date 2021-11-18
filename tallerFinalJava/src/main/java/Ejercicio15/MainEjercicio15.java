/*
Hacer un programa que muestre el siguiente menú de opciones
****** GESTION CINEMATOGRaFICA ********
1-NUEVO ACTOR
2-BUSCAR ACTOR
3-ELIMINAR ACTOR
4-MODIFICAR ACTOR
5-VER TODOS LOS ACTORES
6- VER PELICULAS DE LOS ACTORES

7-VER CATEGORIA DE LAS PELICULAS DE LOS ACTORES
8-SALIR


EL SISTEMA SOLO VA A SALIR CUANDO SE DIGITE EL NUMERO 8, MIENTRAS SE DIGITE UNA DE LAS CINCO OPCIONES
DEBE SEGUIR MOSTRADO EL MENU Y SI EL USUARIO DIGITA UN NUMERO QUE NO ESTA EN EL MENU SE DEBE ARROJAR
UN MENSAJE " OPCION INCORRECTO". Y MOSTRAR EL MENU NUEVAMENTE.
PISTA: CONVINAR SWICHT Y ALGUNO DE LOS BUCLES.
 */

package Ejercicio15;

import java.util.Scanner;

public class MainEjercicio15 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String entradaDatos;
        boolean esEntero = false, esProgramaActivo = true;
        int opcion = 0;

        while (esProgramaActivo){
            do {
                System.out.print("****** GESTION CINEMATOGRAFICA ********\n" +
                        "1-NUEVO ACTOR\n" +
                        "2-BUSCAR ACTOR\n" +
                        "3-ELIMINAR ACTOR\n" +
                        "4-MODIFICAR ACTOR\n" +
                        "5-VER TODOS LOS ACTORES\n" +
                        "6- VER PELICULAS DE LOS ACTORES\n" +
                        "7-VER CATEGORIA DE LAS PELICULAS DE LOS ACTORES\n" +
                        "8-SALIR\n");
                entradaDatos = entrada.next();

                try {
                    opcion = Integer.parseInt(entradaDatos);
                    esEntero = true;
                }catch (NumberFormatException e){
                    System.out.println("\nDebe ingresar un número entero\n");
                }
            }while (!esEntero);

            switch (opcion){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                case 8:
                    esProgramaActivo = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }
    }
}
