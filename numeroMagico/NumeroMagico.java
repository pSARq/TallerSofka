package numeroMagico;

import javax.swing.*;

public class NumeroMagico {
    public static void main(String[] args) {
        int maximo = 100, minimo = 1, numeroUsuario;
        int numeroMagico = (int) (Math.random()*(maximo-minimo)+minimo);


        while (true){
            numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero para adivinar el numero " +
                    "magico"));

            if (numeroUsuario == numeroMagico){
                JOptionPane.showMessageDialog(null,"Has ganado");
                break;
            }else if(numeroUsuario == 0){
                break;
            }else if (numeroUsuario < numeroMagico){
                JOptionPane.showMessageDialog(null, "El numero magico es mayor, vuelve a intentarlo");
            }else if(numeroUsuario > numeroMagico){
                JOptionPane.showMessageDialog(null,"El numero magico es menor, vuelve a intentarlo");
            }
        }

    }
}
