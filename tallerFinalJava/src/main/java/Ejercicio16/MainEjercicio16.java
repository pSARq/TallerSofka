/*
Haz una clase llamada Persona que siga las siguientes condiciones:

Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura. No queremos que se
accedan directamente a ellos. Piensa que modificador de acceso es el más adecuado, también su tipo.
Si quieres añadir algún atributo puedes hacerlo.


Por defecto, todos los atributos menos el DNI serán valores por defecto según su tipo (0 números, cadena vacía
para String, etc.). Sexo será hombre por defecto, usa una constante para ello.


Se implantarán varios constructores:

Un constructor por defecto.
Un constructor con el nombre, edad y sexo, el resto por defecto.
Un constructor con todos los atributos como parámetro.

Los métodos que se implementaran son:


calcularIMC(): calculara si la persona está en su peso ideal (peso en kg/(altura^2  en m)),
si esta fórmula devuelve un valor menor que 20, la función devuelve un -1, si devuelve un número entre 20 y 25
(incluidos), significa que está por debajo de su peso ideal la función devuelve un 0  y si devuelve un valor
mayor que 25 significa que tiene sobrepeso, la función devuelve un 1. Te recomiendo que uses constantes para
devolver estos valores.

esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
comprobarSexo(char sexo): comprueba que el sexo introducido es correcto. Si no es correcto, sera H.
No será visible al exterior.
toString(): devuelve toda la información del objeto.
generaDNI(): genera un número aleatorio de 8 cifras, genera a partir de este su número su letra correspondiente.
Este método será invocado cuando se construya el objeto. Puedes dividir el método para que te sea más fácil.
No será visible al exterior.
Métodos set de cada parámetro, excepto de DNI.

Ahora, crea una clase ejecutable que haga lo siguiente:


Pide por teclado el nombre, la edad, sexo, peso y altura.
Crea 3 objetos de la clase anterior, el primer objeto obtendrá las anteriores variables pedidas por teclado, el segundo objeto obtendrá todos los anteriores menos el peso y la altura y el último por defecto, para este último utiliza los métodos set para darle a los atributos un valor.
Para cada objeto, deberá comprobar si está en su peso ideal, tiene sobrepeso o por debajo de su peso ideal con un mensaje.
Indicar para cada objeto si es mayor de edad.
Por último, mostrar la información de cada objeto.
 */

package Ejercicio16;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MainEjercicio16 {
    static Scanner entrada = new Scanner(System.in);
    static String nombre;
    static int edad = 0, peso = 0;
    static float altura = 0.0f;
    static char sexo;

    public static boolean validarEntero(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        }catch (NumberFormatException e){
            System.out.println("\nIngrese un número entero\n");
            return false;
        }
    }

    public static void pedirNombre(){
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.nextLine();
    }

    public static void pedirSexo(){
        System.out.print("Hombre = H \nMujer = M \nIngrese el sexo: ");
        sexo = entrada.next().charAt(0);
    }

    public static void pedirEdad(){
        String entradaDatos;
        boolean esEntero = false;

        do {
            System.out.print("Ingrese la edad: ");
            entradaDatos = entrada.next();
            esEntero = validarEntero(entradaDatos);
        }while (!esEntero);
        edad = Integer.parseInt(entradaDatos);
    }

    public static void pedirPeso(){
        String entradaDatos;
        boolean esEntero = false;

        do {
            System.out.print("Ingrese el peso (kg): ");
            entradaDatos = entrada.next();
            esEntero = validarEntero(entradaDatos);
        }while (!esEntero);
        peso = Integer.parseInt(entradaDatos);
    }

    public static void pedirAltura(){
        String entradaDatos;
        boolean esNumero = false;

        do {
            System.out.print("Ingrese la altura (metros): ");
            entradaDatos = entrada.next();

            try {
                altura = Float.parseFloat(entradaDatos);
                esNumero = true;
            }catch (NumberFormatException e){
                System.out.println("\nIngrese un número \n");
            }
        }while (!esNumero);
    }

    public static String pesoIdeal(int numero){

        if (numero == -1){
            return "Esta por debajo de su peso ideal";
        }
        if (numero == 0){
            return "Esta en su peso ideal";
        }
        return "Esta con sobrepeso";
    }

    public static String mayorEdad(boolean laEdad){
        if (laEdad == true){
            return "Es mayor de edad";
        }
        return "Es menor de edad";
    }

    public static void main(String[] args) {
        pedirNombre();
        pedirSexo();
        pedirEdad();
        pedirPeso();
        pedirAltura();

        Persona persona1 = new Persona(MainEjercicio16.nombre, MainEjercicio16.edad, MainEjercicio16.peso,
                MainEjercicio16.altura, 0, MainEjercicio16.sexo);
        Persona persona2 = new Persona(MainEjercicio16.nombre, MainEjercicio16.edad, MainEjercicio16.sexo);
        Persona persona3 = new Persona();

        persona3.setNombre(MainEjercicio16.nombre);
        persona3.setEdad(MainEjercicio16.edad);
        persona3.setPeso(MainEjercicio16.peso);
        persona3.setAltura(MainEjercicio16.altura);

        System.out.println("\nPeso");
        System.out.println(pesoIdeal(persona1.calcularIMC()));
        System.out.println(pesoIdeal(persona2.calcularIMC()));
        System.out.println(pesoIdeal(persona3.calcularIMC()));

        System.out.println("\nEdad");
        System.out.println(mayorEdad(persona1.esMayorEdad()));
        System.out.println(mayorEdad(persona2.esMayorEdad()));
        System.out.println(mayorEdad(persona3.esMayorEdad()));

        System.out.println("\nToda la información");
        System.out.println(persona1.toString());
        System.out.println(persona2.toString());
        System.out.println(persona3.toString());


    }
}
