package Clase;


public class Suma extends CalculadoraSimple {

    public Suma(double numero1, double numero2) {
        super(numero1, numero2);
    }

    @Override
    public void mostrarResultado(){
        System.out.println("El resultado de la suma es de: " +getResultado());
    }

}
