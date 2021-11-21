package taller_kata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Statement {
    private String nombre;
    private int montoTotal;
    private ArrayList<String> estadoBancario;
    private ArrayList<String> movimientos;
    private final SimpleDateFormat formatoFecha;

    public Statement(String nombre, int montoInicial) {
        this.nombre = nombre;
        this.montoTotal = montoInicial;
        estadoBancario = new ArrayList();
        movimientos = new ArrayList<>();
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    }

    private Date verificarFecha(String date){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = new Date();
        try {
            fecha = formato.parse(date);
        } catch (ParseException e) {
            System.out.println("FECHA INCORRECTA: " + date);
        }
        return fecha;
    }

    public int consultarMonto(){
        return this.montoTotal;
    }

    public void agregarMonto(int monto, String date){
        this.montoTotal += monto;
        Date fecha = verificarFecha(date);
        String ingreso = formatoFecha.format(fecha)+ "    " +monto+ "                 ";
        movimientos.add(ingreso);
        estadoBancario.add(ingreso+ " " +montoTotal);

    }

    public void restarMonto(int monto, String date){
        this.montoTotal -= monto;
        Date fecha = verificarFecha(date);
        String retiro = formatoFecha.format(fecha)+ "               " +monto+ "       ";
        movimientos.add(retiro);
        estadoBancario.add(retiro+ " " +montoTotal);
    }

    public ArrayList consultarEstadoBancario(){
        return estadoBancario;
    }

    public ArrayList consultarMovimientos(){
        return movimientos;
    }



}
