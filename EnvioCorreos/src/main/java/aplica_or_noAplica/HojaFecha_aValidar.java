package aplica_or_noAplica;

import com.poiji.annotation.ExcelCell;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class HojaFecha_aValidar {
    

    
    @ExcelCell(0)
    private String nombre;
    
    @ExcelCell(1)
    private String cedula;
    
    @ExcelCell(2)
    private LocalDate fecha;
    
    @ExcelCell(3)
    private String observacion;
    
    public HojaFecha_aValidar() {
    }
    
    public HojaFecha_aValidar(String nombre, String cedula, LocalDate fecha, String observacion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fecha = fecha;
        this.observacion = observacion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCedula() {
        return cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public String getObservacion() {
        return observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    @Override
    public String toString() {
        return "HojaFecha_aValidar{" + "nombre=" + nombre + ", cedula=" + cedula + ", fecha=" + fecha + ", observacion=" + observacion + '}';
    }
    
}
