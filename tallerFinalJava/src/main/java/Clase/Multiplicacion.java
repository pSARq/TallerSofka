package Clase;

public class Multiplicacion extends CalculadoraSimple{

    public Multiplicacion(double numero1, double numero2) {
        super(numero1, numero2);
    }

    @Override
    public void mostrarResultado(){
        System.out.println("El resultado de la multiplicación es de: " +getResultado());
    }
}
