package com.mycompany.plantillas;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.*;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.mycompany.metodosDclases.MetodosDclases;
import com.mycompany.metodosDclases.Parrafos;
import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class PlantillaUno {

    private Document documento = new Document();
    private Image imagen = null, imagenParrafo = null;

    private Session sesion;
    private MimeMessage mensaje;
    private Properties propiedades = new Properties();
    private MimeBodyPart bodyPart = new MimeBodyPart();
    private MimeBodyPart imagenParte = new MimeBodyPart();
    private MimeMultipart multiParte = new MimeMultipart();
    private Transport transport;
    private final String CORREO_EMISOR = "jhoalmanza52@gmail.com";
    private final String CONTRASENIA = "knxh uzsd djqn rfrb";

    private String nombreFormato, Nombres, cc;
    private String inicio, fin, dias;

    private PlantillaUno(PlantillaBuilder b) {

        this.nombreFormato = b.nombreFormato;
        this.Nombres = b.nombreCompleto;
        this.cc = b.cedula;
        this.inicio = b.fechaInicio;
        this.fin = b.fechaFin;
        this.dias = b.dias;

    }

    public static class PlantillaBuilder {

        private String nombreCompleto;
        private String nombreFormato;
        private String cedula;
        private String fechaInicio;
        private String fechaFin;
        private String dias;

        public PlantillaBuilder() {
        }

        public PlantillaBuilder nombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
            return this;
        }

        public PlantillaBuilder nombreFormato(String nombreFormato) {
            this.nombreFormato = nombreFormato;
            return this;
        }

        public PlantillaBuilder cedula(String cedula) {
            this.cedula = cedula;
            return this;
        }

        public PlantillaBuilder fechaInicio(String fechaInicio) {
            this.fechaInicio = fechaInicio;
            return this;
        }

        public PlantillaBuilder fechaFin(String fechaFin) {
            this.fechaFin = fechaFin;
            return this;
        }

        public PlantillaBuilder dias(String dias) {
            this.dias = dias;
            return this;
        }

        public PlantillaUno build() {

            PlantillaUno plantilla = new PlantillaUno(this);
            plantilla.generarFormato();
            return plantilla;
       }

    }

    public void generarFormato() {

        try {

            FileOutputStream archivoPdf = new FileOutputStream(nombreFormato + ".pdf");
            PdfWriter.getInstance(documento, archivoPdf);
            documento.open();

            //Imagen
            imagen = Image.getInstance("C:\\Users\\lcamp\\Pictures\\Screenshots\\imagenEmpresa.png");
            imagen.scaleAbsolute(145, 50);
            imagen.setAbsolutePosition(415, 770);
            documento.add(imagen);

            //Texto capital
            Paragraph textoCapital = new Paragraph();
            textoCapital.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK));
            textoCapital.add("BOGOTA, " + MetodosDclases.getDate());
            documento.add(textoCapital);
            documento.add(Chunk.NEWLINE);

            //Textos emcabezados
            MetodosDclases.estiloTexto(documento, "Señor(a):", FontFactory.defaultEncoding, 10, Font.BOLD, BaseColor.BLACK);
            MetodosDclases.estiloTexto(documento, Nombres, FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            MetodosDclases.estiloTexto(documento, "C.C." + cc, FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            MetodosDclases.estiloTexto(documento, "Ciudad", FontFactory.defaultEncoding, 10, Font.BOLD, BaseColor.BLACK);
            documento.add(Chunk.NEWLINE);

            // Referencia 
            Paragraph ref = new Paragraph();
            ref.add("Ref.: ");
            ref.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, Font.ITALIC, BaseColor.BLACK));
            ref.setAlignment(Chunk.ALIGN_CENTER);
            ref.add(Parrafos.texto1);
            ref.setAlignment(Chunk.ALIGN_JUSTIFIED);
            documento.add(ref);

            // Linea separadora
            LineSeparator linea = new LineSeparator();
            linea.setPercentage(4);
            linea.setAlignment(Chunk.ALIGN_LEFT);
            documento.add(linea);

            Paragraph tex2 = new Paragraph();
            tex2.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, Font.ITALIC, BaseColor.BLACK));
            tex2.setAlignment(Chunk.ALIGN_LEFT);
            tex2.add(Parrafos.texto2 + "\n");
            documento.add(tex2);

            MetodosDclases.estiloTexto(documento, "Respetado(a) Sr(a).", FontFactory.defaultEncoding, 10, Font.NORMAL, BaseColor.BLACK);
            MetodosDclases.estiloTexto(documento, Nombres, FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);

            Paragraph txtIntro = new Paragraph();
            txtIntro.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL, BaseColor.BLACK));
            txtIntro.setAlignment(Chunk.ALIGN_JUSTIFIED);
            txtIntro.add(Parrafos.txtIntroduccion);
            documento.add(txtIntro);
            documento.add(Chunk.NEWLINE);

            Paragraph p2 = new Paragraph();
            p2.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL, BaseColor.BLACK));
            p2.setAlignment(Chunk.ALIGN_JUSTIFIED);
            p2.add(Parrafos.parrafo1);
            p2.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.BOLD, BaseColor.BLACK));
            p2.add(" AUDITORIA Y CONTROL ");
            p2.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL, BaseColor.BLACK));
            p2.add(Parrafos.parrafo2);
            documento.add(p2);
            documento.add(Chunk.NEWLINE);

            Paragraph p3 = new Paragraph();
            p3.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL, BaseColor.BLACK));
            p3.setAlignment(Chunk.ALIGN_JUSTIFIED);
            p3.add(Parrafos.parrafo3);
            p3.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.BOLD, BaseColor.RED));
            p3.add("  del " + inicio + " al " + fin + " de Enero 2024, ");
            p3.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL, BaseColor.BLACK));
            p3.add(Parrafos.parrafo4);
            documento.add(p3);
            documento.add(Chunk.NEWLINE);

            Paragraph p4 = new Paragraph();
            p4.setFont(FontFactory.getFont(FontFactory.defaultEncoding, 9, Font.NORMAL, BaseColor.BLACK));
            p4.setAlignment(Chunk.ALIGN_JUSTIFIED);
            p4.add(Parrafos.parrafo5);
            documento.add(p4);

            imagenParrafo = Image.getInstance("C:\\Users\\lcamp\\Pictures\\Screenshots\\emcabezado_last.png");
            imagenParrafo.scaleAbsolute(540, 250);
            imagenParrafo.setAbsolutePosition(34, 15);
            documento.add(imagenParrafo);

            documento.close();
            archivoPdf.close();
            System.out.println("Documento creado con exito...");

        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error a el Generar PDF (plantilla 1)" + e.getMessage(), "Warning", 2);
        }
    }

    public void enviarFormato(String correoReceptor, File[] archivos) {
        try {

            if (!correoReceptor.equalsIgnoreCase("") && archivos != null) {

                //Propiedades de autenticacion con el servidor de envios smtp gmail
                propiedades.put("mail.smtp.host", "smtp.gmail.com");
                propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                propiedades.setProperty("mail.smtp.starttls.enable", "true");
                propiedades.setProperty("mail.smtp.port", "587");
                propiedades.setProperty("mail.smtp.user", CORREO_EMISOR);
                propiedades.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
                propiedades.setProperty("mail.smtp.auth", "true");

                //Creamos la seccion y el mensaje con las propiedades anteriores
                sesion = Session.getDefaultInstance(propiedades);
                mensaje = new MimeMessage(sesion);

                //cargamos la imagen y le asignamos un id para incluirla en la estructura de el correo
                imagenParte = new MimeBodyPart();
                imagenParte.attachFile("C:\\Users\\lcamp\\Pictures\\Screenshots\\emcabezado.png");
                imagenParte.setContentID("<imagen1>");

                //Estructura de el correo
                String text = "VERIFICACIÓN DE AUNTENTICIDAD DE INCAPACIDAD 900154405";

                String contenido = "<html>"
                        + "<p>"
                        + "Buen dia,<br><br>"
                        + "Solicito su colaboración con la verificación de la incapacidad adjunta que corresponde a la trabajadora<b> NOMBRE</b><br>"
                        + "identificada con <b>102312312321</b> quien labora para la empresa <b>COVISIAN COLOMBIA S.A.S  con NIT. 900154405.<b/>"
                        + "</p><br>"
                        + "<table border=1>"
                        + "<tr>"
                        + "<th border-collapse = collapse>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FECHA INICIO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>"
                        + "<th border-collapse = collapse>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FECHA FIN&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>"
                        + "<th border-collapse = collapse>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DIAS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>"
                        + "</tr>"
                        + "<tr>"
                        + "<td border-collapse = collapse>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + inicio + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
                        + "<td border-collapse = collapse>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + fin + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
                        + "<td border-collapse = collapse>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + dias + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
                        + "</tr>"
                        + "</table><br><br>"
                        + "<b>Solicitamos su ayuda con la respuesta formal  y en membrete de la validación del soporte</b><br><br>"
                        + "Adjunto soporte correspondiente.<br><br>"
                        + "Gracias por su tiempo.<br><br><br><br>"
                        + "<img src=\"cid:imagen1\">"
                        + "</html>";

                bodyPart = new MimeBodyPart();
                bodyPart.setContent(contenido, "text/html");

                // añadimos el contenido y la imagen 
                multiParte.addBodyPart(imagenParte);
                multiParte.addBodyPart(bodyPart);

                //recorremos los archivos y los abjuntamos a el correo
                MimeBodyPart archivosAbjuntos = null;
                for (int i = 0; i < archivos.length; i++) {
                    archivosAbjuntos = new MimeBodyPart();
                    archivosAbjuntos.setDataHandler(new DataHandler(new FileDataSource(archivos[i].getAbsolutePath())));
                    archivosAbjuntos.setFileName(archivos[i].getName());
                    multiParte.addBodyPart(archivosAbjuntos);

                }

                //Definimos propiedades de envio
                mensaje.setFrom(new InternetAddress(CORREO_EMISOR));
                mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
                mensaje.setSubject(text);
                mensaje.setContent(multiParte);
                MetodosDclases.enviar(CORREO_EMISOR, CONTRASENIA, sesion, transport, mensaje);

            } else {
                JOptionPane.showMessageDialog(null, "HAY CAMPOS NULLOS", "Error", 2);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el CORREO (plantilla 1): " + e.getMessage(), "Error", 2);

        }
    }

}
