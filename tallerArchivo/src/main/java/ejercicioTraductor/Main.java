package Prueba;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Traductor traductor;
        Scanner entrada = new Scanner(System.in);
        String entradaEspanol, entradaIngles;
        int opcion;
        boolean salir = false;

        while (salir == false){
            traductor = new Traductor();
            System.out.print("\nBIENVENIDO A EL TRADUCTOR\nA continuación estan las operaciones que puede realizar\n" +
                    "1. Insertar una nueva palabra\n" +
                    "2. Consultar la traducción de una palabra\n" +
                    "3. Consultar todas las palabras del diccionario\n" +
                    "4. Salir\n" +
                    "Ingrese el número de lo que desea hacer: ");
            opcion = entrada.nextInt();

            switch (opcion){
                case 1:
                    System.out.print("Ingrese la palabra en español: ");
                    entradaEspanol = entrada.next();
                    System.out.print("Ingrese la traducción en ingles: ");
                    entradaIngles = entrada.next();
                    traductor.agregarPalabra(entradaEspanol, entradaIngles);
                    entradaEspanol = null;
                    entradaIngles = null;
                    break;
                case 2:
                    System.out.print("¿Qué palabra desea traducir?: ");
                    entradaEspanol = entrada.next();
                    traductor.traducirPalabra(entradaEspanol);
                    break;
                case 3:
                    traductor.consultarTodo();
                    break;
                case 4:
                    System.out.println("Vuelva pronto");
                    salir = true;
                    break;
                default:
                    System.out.println("Operación invalida");
            }
        }

    }
}
