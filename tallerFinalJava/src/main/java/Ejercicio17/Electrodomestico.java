package Ejercicio17;

public class Electrodomestico {
    protected final double precioBase;
    protected String color;
    protected final char consumoEnergetico;
    protected final int peso;

    public Electrodomestico() {
        precioBase = 100;
        color = "Blanco";
        consumoEnergetico = 'F';
        peso = 5;
    }

    public Electrodomestico(double precioBase, int peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        color = "Blanco";
        consumoEnergetico = 'F';
    }

    public Electrodomestico(double precioBase, String color, char consumoEnergetico, int peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public int getPeso() {
        return peso;
    }

    private char comprobarConsumoEnergetico(char letra){
        switch (letra){
            case 'a':
            case 'A':
                return 'A';
            case 'b':
            case 'B':
                return 'B';
            case 'c':
            case 'C':
                return 'C';
            case 'd':
            case 'D':
                return 'D';
            case 'e':
            case 'E':
                return 'E';
            case 'f':
            case 'F':
                return 'F';
            default:
                return 'F';
        }
    }

    private String comprobarColor(String cadena){
        String colorAProbar = cadena.toLowerCase();
        switch (colorAProbar.toLowerCase()){
            case "blanco":
                return "Blanco";
            case "negro":
                return "Negro";
            case "rojo":
                return "Rojo";
            case "azul":
                return "Azul";
            case "gris":
                return "Gris";
            default:
                return "Blanco";
        }
    }

    public double precioFinal(){
        double precioConsumo = 0;
        double precioPeso = 0;
        double totalPrecio;

        switch (consumoEnergetico){
            case 'A':
                precioConsumo = 100;
                break;
            case 'B':
                precioConsumo = 80;
                break;
            case 'C':
                precioConsumo = 60;
                break;
            case 'D':
                precioConsumo = 50;
                break;
            case 'E':
                precioConsumo = 30;
                break;
            case 'F':
                precioConsumo = 10;
                break;
        }

        if (peso >= 0 && peso <= 19){
            precioPeso = 10;
        }else if (peso >= 20 && peso <= 49){
            precioPeso = 50;
        }else if(peso >= 50 && peso <= 79){
            precioPeso = 80;
        }else {
            precioPeso = 100;
        }
        totalPrecio = precioBase + precioConsumo + precioPeso;
         return totalPrecio;
    }

}
