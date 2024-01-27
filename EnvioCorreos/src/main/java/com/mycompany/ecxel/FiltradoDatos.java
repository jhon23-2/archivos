package com.mycompany.ecxel;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FiltradoDatos {

    private List<FormatoEcxelDos> lista = null;

    public FiltradoDatos() {
        cargarDatos();
    }

    private void cargarDatos() {

        try {
            PoijiOptions opciones = PoijiOptions.PoijiOptionsBuilder.
                    settings()
                    .sheetIndex(0)
                    .build();

            lista = Poiji.fromExcel(new File("C:\\Users\\lcamp\\Downloads\\BASE (1).xlsx"), FormatoEcxelDos.class, opciones);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error a el cargar los datos: " + e.getMessage(), "Error", 2);
        }

    }

    public void filtradoDatos(JTable tabla) {

        String emcabezados[] = {"Nombres", "Cedula", "Fecha inicio", "Fecha fin", "Entidad"};
        DefaultTableModel modelo = new DefaultTableModel(null, emcabezados);

        lista.removeIf(s -> s.getNombres().equalsIgnoreCase("nombres"));

        lista.forEach(d -> {
            String datos[] = {d.getNombres(), d.getCedula(), d.getFechaInicio(), d.getFechaFin(), d.getEntidadEps()};
            modelo.addRow(datos);
        });

        tabla.setModel(modelo);

    }

}
