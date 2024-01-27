package ejersiciosPractica_funcional;

import java.util.Objects;

public class PrestamosVideojuegos {

    private String nombreCliente;
    private int numPrestamo;
    private int idCliente;
    private VideJuego videJuego;

    private PrestamosVideojuegos(PrestamosBuilder p){
        this.nombreCliente = p.nombreCliente;
        this.numPrestamo = p.numPrestamo;
        this.idCliente = p.idCliente;
        this.videJuego = p.videJuego;
    }

    public static class PrestamosBuilder {

        private String nombreCliente;
        private int numPrestamo;
        private int idCliente;
        private VideJuego videJuego;

        public PrestamosBuilder nombreCliente(String nombre){
            this.nombreCliente = nombre;
            return this;
        }

        public PrestamosBuilder idCliente(int idCliente){
            this.idCliente = idCliente;
            return this;
        }

        public PrestamosBuilder numPrestamos(int numPrestamo){
            this.numPrestamo = numPrestamo;
            return this;
        }

        public PrestamosBuilder videjuego(int idPrestamo, String nombreVideojuego){
            this.videJuego = new VideJuego( nombreVideojuego,idPrestamo);
            return this;
        }

        public PrestamosVideojuegos build(){
            if (idCliente==0){
                return null;
            }
            return new PrestamosVideojuegos(this);
        }



    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getNumPrestamo() {
        return numPrestamo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public VideJuego getVideJuego() {
        return videJuego;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrestamosVideojuegos that)) return false;
        return getIdCliente() == that.getIdCliente();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCliente());
    }

    @Override
    public String toString() {
        return "{" +
                "\nnombreCliente='" + nombreCliente + '\'' +
                ",\nnumPrestamo=" + numPrestamo +
                ",\nidCliente=" + idCliente +
                ",\nvideJuego=" + videJuego +
                '}';
    }
}
