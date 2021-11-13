package Prueba;

import java.io.*;
import java.util.HashMap;

public class Archivo {
    private File diccionario;

    public Archivo(){
        diccionario = new File("Diccionario.txt");
    }

    public void escribirDiccionario(HashMap Diccionario) {
        try {
            FileWriter escribir = new FileWriter(diccionario, true);
            escribir.write("\r\n" +String.valueOf(Diccionario)+ ",");
            escribir.close();
        } catch (IOException e) {
            System.err.println("Error, no se ha podido escribir sobre el archivo");
        }
    }

    private String traerDatosArchivo() {
        String linea = null;
        String DiccionarioString = null;
        try {
            BufferedReader lector = new BufferedReader(new FileReader(diccionario));
            StringBuilder cadena = new StringBuilder();

            while ((linea = lector.readLine()) != null) {
                cadena = cadena.append(linea);
            }
            lector.close();
            DiccionarioString = cadena.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Error, " + e);
        } catch (IOException e) {
            System.out.println("Error, " + e);
        }

        return DiccionarioString;
    }

    public HashMap leerDiccionario(){
        HashMap Diccionario = new HashMap();
        String[] separadosPorComa = traerDatosArchivo().replace("{", "").replace("}", "").replace("=", ",").split(",");
        String[] claves = new String[(separadosPorComa.length/2)+1];
        String[] valores = new String[(separadosPorComa.length/2)+1];
        int clavesC = 0, valoresC = 0;

        for (int i = 0; i < separadosPorComa.length; i++) {
            if (i % 2 == 0) {
                claves[clavesC] = separadosPorComa[i];
                clavesC++;
            }else{
                valores[valoresC] = separadosPorComa[i];
                valoresC++;
            }
        }

        for (int i = 0; i < separadosPorComa.length/2; i++) {
            Diccionario.put(claves[i], valores[i]);
        }

        return Diccionario;
    }
}
