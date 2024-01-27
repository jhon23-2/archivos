package com.mycompany.ecxel;

import com.poiji.annotation.ExcelCell;

public class FormatoEcxelDos {

    @ExcelCell(3)
    private String nombres;
    
    @ExcelCell(4)
    private String cedula;

    @ExcelCell(5)
    private String fechaInicio;

    @ExcelCell(6)
    private String fechaFin;

    @ExcelCell(7)
    private String entidadEps;

    public FormatoEcxelDos() {
    }

    public FormatoEcxelDos(String nombres, String cedula, String fechaInicio, String fechaFin, String entidadEps) {
        this.nombres = nombres;
        this.cedula = cedula;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.entidadEps = entidadEps;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEntidadEps() {
        return entidadEps;
    }

    public void setEntidadEps(String entidadEps) {
        this.entidadEps = entidadEps;
    }

    @Override
    public String toString() {
        return "FormatoEcxelDos{" + "nombres=" + nombres + ", cedula=" + cedula + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", entidadEps=" + entidadEps + '}';
    }

}
