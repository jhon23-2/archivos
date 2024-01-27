package ejersiciosPractica_funcional;

public class VideJuego {
    private String nombreVideoJuego;
    private int idPrestamo;

    public VideJuego() {
    }

    public VideJuego(String nombreVideoJuego, int idPrestamo) {
        this.nombreVideoJuego = nombreVideoJuego;
        this.idPrestamo = idPrestamo;
    }

    public String getNombreVideoJuego() {
        return nombreVideoJuego;
    }

    public void setNombreVideoJuego(String nombreVideoJuego) {
        this.nombreVideoJuego = nombreVideoJuego;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Override
    public String toString() {
        return "VideJuego{" +
                "nombreVideoJuego='" + nombreVideoJuego + '\'' +
                ", idPrestamo=" + idPrestamo +
                '}';
    }
}
