package Clase;

public class Resta extends CalculadoraSimple{

    public Resta(double numero1, double numero2) {
        super(numero1, numero2);
    }

    @Override
    public void mostrarResultado(){
        System.out.println("El resultado de la resta es de: " +getResultado());
    }
}
