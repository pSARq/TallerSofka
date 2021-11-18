package Ejercicio17;

public class Lavadora extends Electrodomestico{
    private int carga;

    public Lavadora() {
        carga = 5;
    }

    public Lavadora(double precioBase, int peso) {
        super(precioBase, peso);
        carga = 5;
    }

    public Lavadora(double precioBase, String color, char consumoEnergetico, int peso, int carga) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public double precioFinal(){
        if (carga > 30){
            return super.precioFinal() + 50;
        }
        return super.precioFinal();
    }
}
