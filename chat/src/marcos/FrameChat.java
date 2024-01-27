package marcos;


import paqueteEnvio.PaqueteMensaje;
import paneles.PanelChat;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrameChat extends JFrame {

    private String nombre = "";

    public FrameChat(String nombre) {
        this.nombre = nombre;

        this.add(new PanelChat(nombre), BorderLayout.CENTER);

        this.setBounds(0, 0, 500, 550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle(nombre);

        this.addWindowListener(new EventoVentana());

    }

    private class EventoVentana extends WindowAdapter {

        @Override
        public void windowOpened(WindowEvent e) {
            try {
                Socket miSocket = new Socket("192.168.18.253", 9999);
                PaqueteMensaje datos = new PaqueteMensaje();

                datos.setMensaje("En Linea");
                datos.setNick(nombre);

                ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
                paqueteDatos.writeObject(datos);

                miSocket.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "El servidor esta apagado \n" + ex.getMessage(), "Warning", 2);
            }
        }

    }

}
