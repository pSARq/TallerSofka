
package Ejercicio17;

public class MainEjercicio17 {

    static Electrodomestico electrodomesticos[] = new Electrodomestico[10];
    static double precioLavadoras = 0;
    static double precioTelevisiones = 0;
    static double precioElectrodomesticos = 0;

    public static void llenarArreglo() {
        electrodomesticos[0] = new Lavadora();
        electrodomesticos[1] = new Lavadora(80, 80);
        electrodomesticos[2] = new Lavadora(90, "Rojo", 'A', 90, 40);
        electrodomesticos[3] = new Television();
        electrodomesticos[4] = new Television(40, 40);
        electrodomesticos[5] = new Television(50, "Naranja", 'D', 200, 280, true);
        electrodomesticos[6] = new Electrodomestico();
        electrodomesticos[7] = new Electrodomestico(2000, 200);
        electrodomesticos[8] = new Electrodomestico(500, "nose", 'Z', 2000);
        electrodomesticos[9] = new Lavadora();
    }

    public static void obtenerPrecioFinal() {

        for (Electrodomestico electro : electrodomesticos) {
            if (electro instanceof Lavadora) {
                precioLavadoras += electro.precioFinal();
            } else if (electro instanceof Television) {
                precioTelevisiones += electro.precioFinal();
            }
            precioElectrodomesticos += electro.precioFinal();
        }

    }

    public static void mostrarPrecioFinal() {
        System.out.println("El total de precio de las lavadoras es de: " + precioLavadoras);
        System.out.println("El total de precio de los televisores es de: " + precioTelevisiones);
        System.out.println("El total de precio de los electrodomesticos es de: " + precioElectrodomesticos);
    }

    public static void main(String[] args) {
        llenarArreglo();
        obtenerPrecioFinal();
        mostrarPrecioFinal();
    }
}
