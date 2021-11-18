/*
Realizar un algoritmo que permita consulta la fecha y hora actual en el formato (AAAA/MM/DD) (HH:MM:SS)
 */

package Ejercicio13;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MainEjercicio13 {
    public static void main(String[] args) {

        System.out.println("La fecha es: " +LocalDate.now());
        System.out.println("La hora es: " + LocalTime.now());
    }
}
