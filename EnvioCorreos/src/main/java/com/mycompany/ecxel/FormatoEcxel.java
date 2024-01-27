package com.mycompany.ecxel;

import com.poiji.annotation.ExcelCell;


public class FormatoEcxel {

    @ExcelCell(2)
    private String nombres;

    @ExcelCell(3)
    private String cedula;

    @ExcelCell(4)
    private String correoTrabajador;

    @ExcelCell(5)
    private String correoJefe;

    @ExcelCell(6)
    private String fechaInicio;

    @ExcelCell(7)
    private String fechaFin;

    @ExcelCell(8)
    private String dias;

    @ExcelCell(9)
    private String entidad;

    @ExcelCell(10)
    private String correoEntidad;

    public FormatoEcxel() {
    }

    public FormatoEcxel(String nombres, String cedula, String correoTrabajador, String correoJefe, String fechaInicio, String fechaFin, String dias, String entidad, String correoEntidad) {
        this.nombres = nombres;
        this.cedula = cedula;
        this.correoTrabajador = correoTrabajador;
        this.correoJefe = correoJefe;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.dias = dias;
        this.entidad = entidad;
        this.correoEntidad = correoEntidad;
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

    public String getCorreoTrabajador() {
        return correoTrabajador;
    }

    public void setCorreoTrabajador(String correoTrabajador) {
        this.correoTrabajador = correoTrabajador;
    }

    public String getCorreoJefe() {
        return correoJefe;
    }

    public void setCorreoJefe(String correoJefe) {
        this.correoJefe = correoJefe;
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

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getCorreoEntidad() {
        return correoEntidad;
    }

    public void setCorreoEntidad(String correoEntidad) {
        this.correoEntidad = correoEntidad;
    }

    @Override
    public String toString() {
        return "FormatoEcxel{" + "nombres=" + nombres + ", cedula=" + cedula + ", correoTrabajador=" + correoTrabajador + ", correoJefe=" + correoJefe + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", dias=" + dias + ", entidad=" + entidad + ", correoEntidad=" + correoEntidad + '}';
    }

}
