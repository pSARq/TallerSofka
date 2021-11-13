package Prueba;

import java.util.HashMap;

public class Traductor {

    private Archivo diccionario;
    private HashMap listaPalabras;

    public Traductor(){
        diccionario = new Archivo();
        listaPalabras = new HashMap();
        listaPalabras = diccionario.leerDiccionario();
    }

    public void agregarPalabra(String palabraEspanol, String palabraIngles){
        HashMap palabra = new HashMap();
        String espanol = palabraEspanol.toLowerCase();
        String ingles = palabraIngles.toLowerCase();

        if (listaPalabras.containsKey(espanol)){
            System.out.println("\nNo se puede insertar la palabra, ya exite en el diccionario\n");
        }else{
            palabra.put(espanol, ingles);
            diccionario.escribirDiccionario(palabra);
            System.out.println("\n¡Palabra registrada exitosamente!");
        }
    }

    public void consultarTodo(){
        String[] arregloTerminos = diccionario.leerDiccionario().toString().split(",");
        for (String termino: arregloTerminos) {
            System.out.println(termino);
        }
    }

    public void traducirPalabra(String palabraAConsultar){
        String palabra = palabraAConsultar.toLowerCase();

        if (listaPalabras.containsKey(palabra)){
            System.out.println(palabra+ " = " +listaPalabras.get(palabra));
        }else {
            System.out.println(palabra);
            System.out.println("\nLa palabra no existe en el diccionario\n");
        }

    }
}
