package Ejercicio17;

public class Television extends Electrodomestico{

    private int resolucion;
    private boolean sintonizadorTDT;

    public Television() {
        resolucion = 20;
        sintonizadorTDT = false;
    }

    public Television(double precioBase, int peso) {
        super(precioBase, peso);
        resolucion = 20;
        sintonizadorTDT = false;
    }

    public Television(double precioBase, String color, char consumoEnergetico, int peso, int resolucion, boolean sintonizadorTDT) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public int getResolucion() {
        return resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    public double precioFinal(){
        double precio;
        double totalPrecio = super.precioFinal();
        if (resolucion > 40 && sintonizadorTDT == true){
            precio = super.precioFinal() * 0.30 + 50;
            return totalPrecio + precio;
        }
        if (resolucion > 40){
            precio = super.precioFinal() * 0.30;
            return totalPrecio + precio;
        }
        if (sintonizadorTDT == true){
            precio = 50;
            return totalPrecio + precio;
        }
        return totalPrecio;
    }
}
