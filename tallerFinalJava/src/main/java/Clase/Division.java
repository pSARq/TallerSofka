package Clase;

public class Division extends CalculadoraSimple{

    public Division(double numero1, double numero2) {
        super(numero1, numero2);
    }

    @Override
    public void mostrarResultado(){
        System.out.println("El resultado de la división es de: " +getResultado());
    }
}
