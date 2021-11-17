package numeroMagico;

import javax.swing.*;

public class NumeroMagico {
    public static void main(String[] args) {
        int vidas = 4;
        int maximo = 100, minimo = 1, numeroUsuario;
        int numeroMagico = (int) (Math.random()*(maximo-minimo)+minimo);


        while (vidas >= 1){
            numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog("Tiene "+ vidas + " vidas.\n ingrese 0 para salir." +
                "\nDigite un numero para adivinar el numero magico"));

            if (numeroUsuario == numeroMagico){
                JOptionPane.showMessageDialog(null,"Has ganado");
                break;
            }else if(numeroUsuario == 0){
                break;
            }else if (numeroUsuario < numeroMagico){
                vidas--;
                JOptionPane.showMessageDialog(null, "El numero magico es mayor, vuelve a intentarlo");
            }else if(numeroUsuario > numeroMagico){
                vidas--;
                JOptionPane.showMessageDialog(null,"El numero magico es menor, vuelve a intentarlo");
            }
        }

    }
}
