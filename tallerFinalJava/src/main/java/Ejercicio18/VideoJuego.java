package Ejercicio18;

public class VideoJuego implements Entregable{
    private String titulo;
    private int horasEstimadas;
    private boolean entregado;
    private String genero;
    private String compania;

    public VideoJuego() {
        titulo = "";
        horasEstimadas = 10;
        entregado = false;
        genero = "";
        compania = "";
    }

    public VideoJuego(String titulo, int horasEstimadas) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        entregado = false;
        genero = "";
        compania = "";
    }

    public VideoJuego(String titulo, int horasEstimadas, String genero, String compania) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.genero = genero;
        this.compania = compania;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", horasEstimadas=" + horasEstimadas +
                ", entregado=" + entregado +
                ", genero='" + genero + '\'' +
                ", compania='" + compania + '\'';
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
        if (horasEstimadas > ((VideoJuego) a).getHorasEstimadas()){
            return true;
        }
        return false;
    }
}
