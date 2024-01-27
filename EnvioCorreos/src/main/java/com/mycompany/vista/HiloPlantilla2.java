
package com.mycompany.vista;

import com.mycompany.plantillas.PlantillaDos;


public class HiloPlantilla2 extends Thread{

    private String nombres;
    private String cedula;
    private String entidad;
   
    
    public HiloPlantilla2(String nombres,String cedula,String entidad) {
    
        this.nombres = nombres;
        this.cedula = cedula;
        this.entidad = entidad;
    
    }

    
    @Override
    public void run() {

        String nombreFormato = "CARTA DERECHO PETICION VERACIDAD "+cedula;
        
        PlantillaDos p  = new PlantillaDos.PlantillaDosBuilder()
                .Nombres(nombres)
                .nombreFormato(nombreFormato)
                .cedula(cedula)
                .entidad(entidad)
                .build();
        
    }
    
    
    
}
