package Ejercicio18;

import Clase.Main;

public class MainEjercicio18 {
    static Serie series[] = new Serie[5];
    static VideoJuego videojuegos[] = new  VideoJuego[5];

    public static void llenarArregloSeries(){
        series[0] = new Serie();
        series[1] = new Serie("Dexter", "James Manos");
        series[2] = new Serie();
        series[3] = new Serie("Expediente X", 11, "Misterio", "Chris Carter");
        series[4] = new Serie("American Horror Story", "Ryan Murphy");
    }

    public static void llenarArregloVideojuegos(){
        videojuegos[0] = new VideoJuego();
        videojuegos[1] = new VideoJuego("Mortal Kombat", 8);
        videojuegos[2] = new VideoJuego("God of War", 50, "Accion", "SCE Santa Monica Studio");
        videojuegos[3] = new VideoJuego("Pac-Man", 5);
        videojuegos[4] = new VideoJuego("Halo", 24);
    }

    public static void entregarSeriesYVideojuegos(){
        for (int i = 0; i < 3; i++) {
            series[i].entregar();
            videojuegos[i].entregar();
        }
    }

    public static int consultarSeriesEntregados(){
        int contadorSeries = 0;
        for (int i = series.length-1; i >= 0 ; i--) {
            if (series[i].isEntregado() == true){
                contadorSeries++;
                series[i].devolver();
            }
        }
        return contadorSeries;
    }

    public static int consultarVideojuegosEntregados(){
        int contadorVideojuegos = 0;
        for (int i = videojuegos.length-1; i >= 0 ; i--) {
            if (videojuegos[i].isEntregado() == true){
                contadorVideojuegos++;
                videojuegos[i].devolver();
            }
        }
        return contadorVideojuegos;
    }

    public static int videojuegoMayorHoras(){
        int posicionVideojuego = videojuegos.length-1;
        for (int i = videojuegos.length-1; i > 0 ; i--) {
            if (videojuegos[i].compareTo(videojuegos[i-1])){
                posicionVideojuego = i;
            }
        }
        return posicionVideojuego;
    }

    public static int serieMayorTemporadas(){
        int posicionSerie = series.length-1;
        for (int i = series.length-1; i > 0 ; i--) {
            if (series[i].compareTo(series[i-1])){
                posicionSerie = i;
            }
        }
        return posicionSerie;
    }

    public static void main(String[] args) {
        llenarArregloSeries();
        llenarArregloVideojuegos();
        entregarSeriesYVideojuegos();

        System.out.println("Series entregadas: " + consultarSeriesEntregados());
        System.out.println("Videojuegos entregados: " +consultarVideojuegosEntregados());

        System.out.println("El videojuego con mayor horas estimadas es \n" +videojuegos[videojuegoMayorHoras()].toString());
        System.out.println("La serie con mas temporadas es \n" +series[serieMayorTemporadas()].toString());


    }
}
