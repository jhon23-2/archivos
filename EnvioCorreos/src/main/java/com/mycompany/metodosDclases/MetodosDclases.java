package com.mycompany.metodosDclases;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.time.LocalDate;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class MetodosDclases {

    public static int numMes = LocalDate.now().getMonth().getValue();
    public static String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
        "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public MetodosDclases() {

    }

    //Metodo para enviar correo
    public static void enviar(String user, String password, Session sesion, Transport transport, MimeMessage mensaje) {
        try {
            transport = sesion.getTransport("smtp");
            transport.connect(user, password);
            transport.sendMessage(mensaje, mensaje.getRecipients(Message.RecipientType.TO));
            transport.close();
            JOptionPane.showMessageDialog(null, "Mnesaje enviado correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el ENVIO: " + e.getMessage(), "Error", 2);
        }
    }

    //Metodo para dar estilo a los textos de los formatos
    public static void estiloTexto(Document documento, String texto, String formatoLetra, float tam, int stile, BaseColor color) {

        try {

            Paragraph text = new Paragraph();
            text.setFont(FontFactory.getFont(formatoLetra, tam, stile, color));
            text.add(texto);
            text.setAlignment(Chunk.ALIGN_JUSTIFIED);
            documento.add(text);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Metodo para obtener la fecha actual de el sistema
    public static String getDate() {

        String date = "";
        int numDia = LocalDate.now().getDayOfMonth();
        int numAnio = LocalDate.now().getYear();

        for (int i = 0; i < meses.length; i++) {

            if (numMes - 1 == i) {
                date = numDia + " de " + meses[i] + " de " + numAnio;
                break;
            }

        }

        return date;
    }

}
