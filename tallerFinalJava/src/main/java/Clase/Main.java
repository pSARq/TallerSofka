package Clase;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double numero1, numero2;
        int opcion = 0;
        String entradaDatos;
        boolean esEntero = false;

        System.out.print("Ingrese un número: ");
        numero1 = entrada.nextDouble();

        System.out.print("Ingrese otro número: ");
        numero2 = entrada.nextDouble();

        do {
            System.out.print("¿Qué operación desea realizar? \n1.Suma \n2.Resta \n3.Multiplicación" +
                    "\n4.División \nIngrese el número de la operación: ");
            entradaDatos = entrada.next();

            try {
                opcion = Integer.parseInt(entradaDatos);
                esEntero = true;
            }catch (NumberFormatException e){
                System.out.println("Ingrese un número");
            }

        }while (!esEntero);

        switch (opcion){
            case 1:
                Suma suma = new Suma(numero1, numero2);
                suma.sumar();
                suma.mostrarResultado();
                break;
            case 2:
                Resta resta = new Resta(numero1, numero2);
                resta.restar();
                resta.mostrarResultado();
                break;
            case 3:
                Multiplicacion multiplicacion = new Multiplicacion(numero1, numero2);
                multiplicacion.multiplicar();
                multiplicacion.mostrarResultado();
                break;
            case 4:
                Division division = new Division(numero1, numero2);
                division.dividir();
                division.mostrarResultado();
                break;
            default:
                System.out.println("Número ingresado no valido");
        }

    }


}
