
package taller_kata;

import java.util.ArrayList;
import java.util.Date;

public class Account {

    private Statement statement;

    private boolean validadRetiro(int monto){
        if (statement.consultarMonto() < monto){
            return false;
        }
        return true;
    }

    public Account(String nombre, int montoInicial) {
        this.statement = new Statement(nombre, montoInicial);
    }

    public void deposit(int amountOf, String date) {
        statement.agregarMonto(amountOf, date);
    }

    public void withdraw(int amountOf, String date){
        if (validadRetiro(amountOf)){
            statement.restarMonto(amountOf, date);
            System.out.println("Retiro realizado con exito");
            return;
        }
        System.out.println("Saldo insuficiente");
    }

    public void printStatements() {
        ArrayList<String> LineasBancarias = statement.consultarEstadoBancario();
        System.out.println("Date          credit     debit      balance");
        for (String fila: LineasBancarias) {
            System.out.println(fila);
        }
    }

    public void imprimirMovimientos(){
        ArrayList<String> LineasBancarias = statement.consultarMovimientos();
        System.out.println("Date          credit     debit");
        for (String fila: LineasBancarias) {
            System.out.println(fila);
        }
    }

    public void transferir(String cuentaTranferencia, int monto, String date){
        if (validadRetiro(monto)){
            withdraw(monto, date);
            System.out.println("Transaccion exitosa");
            return;
        }
        System.out.println("Saldo insuficiente");

    }

}

