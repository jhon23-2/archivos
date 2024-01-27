package eventos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JComboBox;
import paqueteEnvio.DireccionesValores;
import paqueteEnvio.PaqueteMensaje;

public class EventoKey extends KeyAdapter {

    private PaqueteMensaje mensaje;
    private JComboBox opciones;
    private DireccionesValores d = DireccionesValores.getInstance();
    private String nombre = "";

    public EventoKey(JComboBox opciones, String nombre) {
        this.opciones = opciones;
        this.nombre = nombre;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            Socket miSocket = new Socket("192.168.18.253", 9999);
            mensaje = new PaqueteMensaje();

            mensaje.setNick(nombre);
            mensaje.setMensaje("escribiendo");
            mensaje.setIp(d.obtenerClave(String.valueOf(opciones.getSelectedItem())));

            ObjectOutputStream outEscribiendo = new ObjectOutputStream(miSocket.getOutputStream());
            outEscribiendo.writeObject(mensaje);

        } catch (IOException ex) {
            System.out.println("Error Key Event: " + ex.getMessage());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            Socket miSocket = new Socket("192.168.18.253", 9999);
            mensaje = new PaqueteMensaje();

            mensaje.setNick(nombre);
            mensaje.setMensaje("");
            mensaje.setIp(d.obtenerClave(String.valueOf(opciones.getSelectedItem())));

            ObjectOutputStream outEscribiendo = new ObjectOutputStream(miSocket.getOutputStream());
            outEscribiendo.writeObject(mensaje);

        } catch (IOException ex) {
            System.out.println("Error Key Event: " + ex.getMessage());
        }
    }

}
