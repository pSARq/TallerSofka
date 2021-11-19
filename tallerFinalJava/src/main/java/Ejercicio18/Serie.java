package Ejercicio18;

public class Serie implements Entregable{
    private String titulo;
    private int numeroTemporadas;
    private boolean entregado;
    private String genero;
    private String creador;

    public Serie() {
        titulo = "";
        numeroTemporadas = 3;
        entregado = false;
        genero = "";
        creador = "";
    }

    public Serie(String titulo, String creador) {
        this.titulo = titulo;
        this.creador = creador;
        numeroTemporadas = 3;
        entregado = false;
        genero = "";
    }

    public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.genero = genero;
        this.creador = creador;
        entregado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", numeroTemporadas=" + numeroTemporadas +
                ", entregado=" + entregado +
                ", genero='" + genero + '\'' +
                ", creador='" + creador + '\'';
    }

    @Override
    public void entregar() {
        entregado = true;
    }

    @Override
    public void devolver() {
        entregado = false;
    }

    @Override
    public boolean isEntregado() {
        return entregado;
    }

    @Override
    public boolean compareTo(Object a) {
        if (numeroTemporadas > ((Serie) a).getNumeroTemporadas()){
            return true;
        }
        return false;
    }
}
