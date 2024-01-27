package aplica_or_noAplica;

import com.poiji.annotation.ExcelCell;
import java.time.LocalDate;

public class HojaRangosFechas {



    @ExcelCell(0)
    private String documento;
    @ExcelCell(1)
    private String nombres;
    @ExcelCell(2)
    private String numDias;
    @ExcelCell(3)
    private LocalDate fechaInicio;
    @ExcelCell(4)
    private LocalDate fechaFin;

    public HojaRangosFechas() {
    }

    public HojaRangosFechas(String documento, String nombres, String numDias, LocalDate fechaInicio, LocalDate fechaFin) {
        this.documento = documento;
        this.nombres = nombres;
        this.numDias = numDias;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumDias() {
        return numDias;
    }

    public void setNumDias(String numDias) {
        this.numDias = numDias;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    
    @Override
    public String toString() {
        return "HojaValidar{" + "documento=" + documento + ", nombres=" + nombres + ", numDias=" + numDias + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }

}
