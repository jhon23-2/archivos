package paneles;

import paqueteEnvio.DireccionesValores;
import paqueteEnvio.PaqueteMensaje;
import eventos.EventoBtn;
import eventos.EventoBntFile;
import eventos.EventoKey;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelChat extends JPanel implements Runnable {

    private JPanel panelSuperior = null;
    private JPanel panelInferior = null;

    private JComboBox txtDirecccionIp = null;
    private JTextArea txtMensaje = null;

    private JButton btnEnviar = null;
    private JButton btnFile = null;
    private JLabel personaEscribiendo;

    private JTextArea areaTexto = null;
    private JScrollPane panelAreaTxt = null;
    private HashMap<String, String> ipes;
    private DireccionesValores d = DireccionesValores.getInstance();

    public PanelChat() {
    }

    public PanelChat(String nombre) {
        new Thread(this).start();
        this.setLayout(new BorderLayout());

        panelSuperior = new JPanel(new GridLayout(2, 2, 3, 3));
        txtDirecccionIp = new JComboBox();
        txtDirecccionIp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        panelSuperior.add(new JLabel("Wraiting: "));
        personaEscribiendo = new JLabel();
        panelSuperior.add(personaEscribiendo);

        panelSuperior.add(new JLabel("Conectados"));
        panelSuperior.add(txtDirecccionIp);

        areaTexto = new JTextArea();
        txtMensaje = new JTextArea();

        panelAreaTxt = new JScrollPane(areaTexto);

        txtMensaje.setLineWrap(true);
        areaTexto.setLineWrap(true);
        areaTexto.setEditable(false);

        btnEnviar = new JButton("Send");
        btnFile = new JButton("Choose");

        btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        panelInferior = new JPanel(new GridLayout(1, 3));

        panelInferior.add(new JScrollPane(txtMensaje), BorderLayout.LINE_START);
        panelInferior.add(btnEnviar,BorderLayout.LINE_END);
        panelInferior.add(btnFile,BorderLayout.LINE_END);

        this.add(panelSuperior, BorderLayout.NORTH);
        this.add(panelAreaTxt, BorderLayout.CENTER);
        this.add(panelInferior, BorderLayout.SOUTH);

        btnFile.addActionListener(new EventoBntFile(nombre, txtDirecccionIp, areaTexto));
        btnEnviar.addActionListener(new EventoBtn(txtDirecccionIp, nombre, txtMensaje, areaTexto));
        txtMensaje.addKeyListener(new EventoKey(txtDirecccionIp, nombre));

    }

    @Override
    public void run() {
        try {

            ServerSocket servidorCliente = new ServerSocket(9090);
            Socket cliente;
            PaqueteMensaje paqueteRecibido;

            while (true) {
                cliente = servidorCliente.accept();

                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                paqueteRecibido = (PaqueteMensaje) flujoEntrada.readObject();

                switch (paqueteRecibido.getMensaje()) {
                    case "En Linea":

                        ipes = paqueteRecibido.getIpes();

                        txtDirecccionIp.removeAllItems();

                        for (Map.Entry<String, String> entry : ipes.entrySet()) {
                            d.agregarElementos(entry.getKey(), entry.getValue());
                            txtDirecccionIp.addItem(entry.getValue());
                        }

                        break;

                    case "Archivo":

                        areaTexto.append("\nArchivo: " + paqueteRecibido.getName());

                        if (!paqueteRecibido.getName().equalsIgnoreCase("")) {

                            int opcion = JOptionPane.showConfirmDialog(null, "Te ha llegado un Archivo quieres recibirlo ? ");

                            if (opcion == JOptionPane.YES_OPTION) {
                                try {

                                    JFileChooser chooser = new JFileChooser();
                                    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                                    chooser.setAcceptAllFileFilterUsed(false);
                                    chooser.setDialogTitle("Elije la ruta para guardar el archivo");

                                    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                                        String ruta = chooser.getSelectedFile().getAbsolutePath();

                                        FileOutputStream o = new FileOutputStream(ruta + File.separator + paqueteRecibido.getName());
                                        o.write(paqueteRecibido.getFileData());

                                        JOptionPane.showMessageDialog(null, "Archivo Recibido Correctamente");
                                    }

                                } catch (Exception e) {
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Rechazastes el archivo.", "Warning", 2);
                            }

                        }

                        break;

                    case "escribiendo":
                        personaEscribiendo.setText(paqueteRecibido.getNick() + " Esta " + paqueteRecibido.getMensaje() + "...");
                        break;

                    case "":
                        personaEscribiendo.setText(paqueteRecibido.getMensaje());
                        break;

                    default:
                        areaTexto.append("\n" + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje() + "\n");

                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
