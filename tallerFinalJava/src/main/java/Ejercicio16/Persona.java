package Ejercicio16;

public class Persona {
    private String nombre;
    private int edad;
    private int peso;
    private float altura;
    private String DNI;
    private final char sexo;



    public Persona() {
        nombre = "";
        edad = 0;
        peso = 0;
        altura = 0;
        sexo = comprobarSexo('H');
        DNI = calcularDNI(0);

    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        peso = 0;
        altura = 0;
        DNI = calcularDNI(0);
    }

    public Persona(String nombre, int edad, int peso, float altura, int DNI, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.DNI = calcularDNI(DNI);
        this.sexo = comprobarSexo(sexo);
    }



    public int calcularIMC(){
        int resultado = (int) (peso/(Math.pow(altura, 2)));

        if (resultado < 20){
            return -1;
        }
        if (resultado >= 20 && resultado <= 25){
            return 0;
        }

        return 1;
    }

    public boolean esMayorEdad(){
        if (edad >= 18){
            return true;
        }
        return false;
    }

    private char comprobarSexo(char tipoSexo){
        if (tipoSexo == 'h' || tipoSexo == 'H' || tipoSexo == 'm' || tipoSexo == 'M'){
            return tipoSexo;
        }
        return 'H';
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                ", DNI=" + DNI +
                ", sexo=" + sexo;
    }

    private String calcularDNI(int numeroIngresado){
        int min = 10000000;
        int max = 99999999;
        int numeroDni;
        if (numeroIngresado<=9999999 || numeroIngresado>99999999) {
            numeroDni = (int) (Math.random()*(max-min) + min);
        }else {
            numeroDni = numeroIngresado;
        }
        char letraDni = calcularLetraDNI(numeroDni);
        String dni = numeroDni+ "" +letraDni;

        return dni;
    }

    private char calcularLetraDNI(int dni){
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numeroLetra = dni%23;
        return letras.charAt(numeroLetra);
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public char getSexo() {
        return sexo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
