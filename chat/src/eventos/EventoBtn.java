package eventos;


import paqueteEnvio.DireccionesValores;
import paqueteEnvio.PaqueteMensaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class EventoBtn implements ActionListener {

    private String nick = "";
    private JComboBox ipes = null;
    private JTextArea txtMensaje = null, areaTexto = null;
    private DireccionesValores d = DireccionesValores.getInstance();

    public EventoBtn(JComboBox ipes, String nick, JTextArea txtMensaje, JTextArea areaTexto) {
        this.ipes = ipes;
        this.nick = nick;
        this.txtMensaje = txtMensaje;
        this.areaTexto = areaTexto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String txtTexto = txtMensaje.getText();

        if (!txtTexto.equalsIgnoreCase("")) {
            areaTexto.append("\n→" + txtMensaje.getText() + "\n");

            try {
                Socket miSocket = new Socket("192.168.18.253", 9999);
                PaqueteMensaje mensajePaquete = new PaqueteMensaje();

                mensajePaquete.setNick(nick);
                mensajePaquete.setMensaje(txtMensaje.getText());

                mensajePaquete.setIp(d.obtenerClave(String.valueOf(ipes.getSelectedItem())));

                ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
                paqueteDatos.writeObject(mensajePaquete);

                limpiar();
                miSocket.close();

            } catch (UnknownHostException e1) {
                System.out.println("Error UnknownHostException: " + e1.getMessage());
            } catch (IOException e2) {
                System.out.println("Error IOException: " + e2.getMessage());
            }

        }

    }

    private void limpiar() {
        txtMensaje.setText("");
    }

}
