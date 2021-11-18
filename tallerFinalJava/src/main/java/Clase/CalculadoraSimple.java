package Clase;

public class CalculadoraSimple {

    private double numero1;
    private double numero2;
    private double resultado;

    public CalculadoraSimple(double numero1, double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public void sumar(){
        resultado = numero1 + numero2;
    }

    public void restar(){
        resultado = numero1 - numero2;
    }

    public void multiplicar(){
        resultado = numero1 * numero2;
    }

    public void dividir(){
        resultado = numero1 / numero2;
    }

    public void mostrarResultado(){
        System.out.println("El valor del número1 es " +numero1+ "y el valor del número 2 es " +numero2);
    }
}
