package com.mycompany.plantillas;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.metodosDclases.MetodosDclases;
import com.mycompany.metodosDclases.Parrafos;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class PlantillaDos {

    private Image imagen = null, imagenSaludo = null;
    public static String seniores, nombreFormato, Nombres, cc;

    private PlantillaDos(PlantillaDosBuilder p) {

        this.nombreFormato = p.nombreFormato;
        this.Nombres = p.nombres;
        this.cc = p.cedula;
        this.seniores = p.entidad;

    }

    public static class PlantillaDosBuilder {

        private String nombres;
        private String nombreFormato;
        private String cedula;
        private String entidad;

        public PlantillaDosBuilder() {
        }

        public PlantillaDosBuilder Nombres(String nombres) {

            this.nombres = nombres;
            return this;
        }

        public PlantillaDosBuilder nombreFormato(String nombreFormato) {

            this.nombreFormato = nombreFormato;
            return this;
        }

        public PlantillaDosBuilder cedula(String cedula) {

            this.cedula = cedula;
            return this;
        }

        public PlantillaDosBuilder entidad(String entidad) {

            this.entidad = entidad;
            return this;
        }

        public PlantillaDos build() {

            PlantillaDos plantilla = new PlantillaDos(this);
            plantilla.generarFormato();
            return plantilla;

        }

    }

    public void generarFormato() {
        try {
            FileOutputStream archivo = new FileOutputStream(nombreFormato + ".pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);

            documento.open();
            documento.setPageSize(PageSize.LETTER);
            documento.addCreator("Microsoft® Word para Microsoft 365");
            documento.addAuthor("Bogota.RLaborales");
            documento.addProducer();

            //Imagen
            imagen = Image.getInstance("C:\\Users\\lcamp\\Pictures\\Screenshots\\imagenEmpresa.png");
            imagen.scaleAbsolute(145, 50);
            imagen.setAbsolutePosition(365, 760);
            documento.add(imagen);

            MetodosDclases.estiloTexto(documento, "\n\n\n                 Bogota D.C., " + MetodosDclases.getDate(), FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            MetodosDclases.estiloTexto(documento, "                 Señores", FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            MetodosDclases.estiloTexto(documento, "                   " + seniores, FontFactory.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);

            MetodosDclases.estiloTexto(documento, "                 Asunto: Derecho de peticion", FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            MetodosDclases.estiloTexto(documento, "                 Nombre: " + Nombres, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            MetodosDclases.estiloTexto(documento, "                 Cedula: " + cc, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            documento.add(Chunk.NEWLINE);

            Paragraph parrafoUno = new Paragraph();
            parrafoUno.setAlignment(Chunk.ALIGN_JUSTIFIED);
            parrafoUno.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK));
            parrafoUno.add("                 Reciban un cordial saludo de ");
            parrafoUno.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.BOLD, BaseColor.BLACK));
            parrafoUno.add("COVISIAN COLOMBIA S.A.S., ");
            parrafoUno.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK));
            parrafoUno.add(Parrafos.parrafo1_p2);
            documento.add(parrafoUno);

            MetodosDclases.estiloTexto(documento, Parrafos.parrafo1_1_p2, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            MetodosDclases.estiloTexto(documento, Parrafos.parrafo1_2_p2, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            MetodosDclases.estiloTexto(documento, Parrafos.parrafo1_3_p2, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            MetodosDclases.estiloTexto(documento, Parrafos.parrafo1_4_p2, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            documento.add(Chunk.NEWLINE);

            MetodosDclases.estiloTexto(documento, "                 Adjunto soporte;", FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);

            MetodosDclases.estiloTexto(documento, Parrafos.parrafo2_p2, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            MetodosDclases.estiloTexto(documento, Parrafos.parrafo2_1_p2, FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            BaseColor color = new BaseColor(7, 122, 158);
            MetodosDclases.estiloTexto(documento, "                 incapacidades.colombia@covisian.com", FontFactory.defaultEncoding, 10, Font.BOLD, color);

            imagenSaludo = Image.getInstance("C:\\Users\\lcamp\\Pictures\\Screenshots\\saludo.png");
            imagenSaludo.scaleAbsolute(250, 120);
            imagenSaludo.setAbsolutePosition(81, 220);
            documento.add(imagenSaludo);

            System.out.println("Documento escrito Correctamente...");
            documento.close();
            archivo.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar PDF (plantilla 2): " + e.getMessage(), "Warning", 2);
        }
    }

    public void enviarFormato(String correoReceptor, File[] archivos) {

    }

}
