package paneles;

import paqueteEnvio.PaqueteMensaje;
import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelServidor extends JPanel implements Runnable {

    private JTextArea areaTxt = null;
    private JScrollPane panelAreaTxt = null;
    private HashMap<String, String> ipeValue = new HashMap<>();

    public PanelServidor() {
        new Thread(this).start();
        this.setLayout(new BorderLayout());

        areaTxt = new JTextArea();
        areaTxt.setEnabled(false);
        areaTxt.setLineWrap(true);

        panelAreaTxt = new JScrollPane(areaTxt);
        this.add(panelAreaTxt, BorderLayout.CENTER);
        this.add(new JLabel("SERVIDOR ->"), BorderLayout.LINE_START);
        this.add(new JLabel("MENSAJES DISTRIBUIDOS POR LOS SERVIDORES CONECTADOS"), BorderLayout.AFTER_LAST_LINE);
        this.add(new JLabel("TODOS LOS MENSAJES"), BorderLayout.NORTH);
    }

    @Override
    public void run() {
        try {
            ServerSocket servidor = new ServerSocket(9999);
            String nick, ip, mensaje, nameFile;
            PaqueteMensaje paqueteRecibido;

            while (true) {
                Socket miSocket = servidor.accept();

                ObjectInputStream paqueteDatos = new ObjectInputStream(miSocket.getInputStream());
                paqueteRecibido = (PaqueteMensaje) paqueteDatos.readObject();

                nick = paqueteRecibido.getNick();
                ip = paqueteRecibido.getIp();
                mensaje = paqueteRecibido.getMensaje();
                nameFile = paqueteRecibido.getName();

                //Reenvio de el paquete o de la informacion recivida
                switch (mensaje) {
                    case "En Linea":
                        try {

                        String ipLinea = miSocket.getInetAddress().getHostAddress();

                        ipeValue.put(ipLinea, nick);
                        paqueteRecibido.setIpes(ipeValue);

                        for (Map.Entry<String, String> entry : ipeValue.entrySet()) {
                            Socket enviaDestinatario = new Socket(entry.getKey(), 9090);

                            ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                            paqueteReenvio.writeObject(paqueteRecibido);

                            paqueteReenvio.close();
                            enviaDestinatario.close();
                            miSocket.close();

                        }

                    } catch (IOException e) {
                        System.out.println("Error en linea Servidor: " + e.getMessage());
                    }
                    break;

                    case "Archivo":
                       
                        try {

                        areaTxt.append("Archivo: " + paqueteRecibido.getName());

                        Socket enviaDestinatario = new Socket(ip, 9090);

                        ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                        paqueteReenvio.writeObject(paqueteRecibido);

                        paqueteReenvio.close();
                        enviaDestinatario.close();
                        miSocket.close();

                    } catch (IOException e) {
                        System.out.println("Error Archivo: " + e.getMessage());
                    }

                    break;

                    case "escribiendo":
                        try {
                        Socket enviaDestinatario = new Socket(ip, 9090);

                        ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                        paqueteReenvio.writeObject(paqueteRecibido);

                        paqueteReenvio.close();
                        enviaDestinatario.close();
                        miSocket.close();
                    } catch (IOException e) {
                        System.out.println("Error escribiendo servidor: " + e.getMessage());
                    }
                    break;

                    case "":
                        
                    try {
                        Socket enviaDestinatario = new Socket(ip, 9090);

                        ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                        paqueteReenvio.writeObject(paqueteRecibido);

                        paqueteReenvio.close();
                        enviaDestinatario.close();
                        miSocket.close();
                    } catch (IOException e) {
                        System.out.println("Error Vacio servidor: " + e.getMessage());
                    }
                    break;

                    default:
                       try {
                        areaTxt.append("\n" + ip + " (" + nick + "): " + mensaje + "\n");

                        Socket enviaDestinatario = new Socket(ip, 9090);

                        ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                        paqueteReenvio.writeObject(paqueteRecibido);

                        paqueteReenvio.close();
                        enviaDestinatario.close();
                        miSocket.close();

                    } catch (IOException e) {
                        System.out.println("Error envio mensaje servidor: " + e.getMessage());
                    }

                }

            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error panel Servidor: " + e.getMessage());
        }
    }

}
