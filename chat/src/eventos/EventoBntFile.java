package eventos;


import paqueteEnvio.PaqueteMensaje;
import paqueteEnvio.DireccionesValores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class EventoBntFile implements ActionListener {
    
    private String ruta = "";
    private File file = null;
    private byte byteRead[] = null;
    
    private String nick = "";
    private JComboBox opciones = null;
    private JTextArea areaTexto = null;
    
    private DireccionesValores d = DireccionesValores.getInstance();
    
    public EventoBntFile(String nick, JComboBox opciones, JTextArea areaTexto) {
        this.nick = nick;
        this.opciones = opciones;
        this.areaTexto = areaTexto;
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser choose = new JFileChooser();
        choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
        choose.setAcceptAllFileFilterUsed(false);
        choose.setDialogTitle("Selecciona un archivo");
        
        if (choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            
            ruta = choose.getSelectedFile().getAbsolutePath();
            file = new File(ruta);
            
            byteRead = new byte[(int) file.length()];
            
            try {
                
                FileInputStream inpt = new FileInputStream(file);
                inpt.read(byteRead);
                areaTexto.append("\n→ File: " + file.getName() + "\n");
                
            } catch (IOException ex) {
                System.out.println("Error a el leer chosse: " + ex.getMessage());
            }
            
            try {
                Socket miSocket = new Socket("192.168.18.253", 9999);
                PaqueteMensaje mensajePaquete = new PaqueteMensaje();
                
                mensajePaquete.setMensaje("Archivo");
                mensajePaquete.setNick(nick);
                mensajePaquete.setName(file.getName());
                
                mensajePaquete.setIp(d.obtenerClave(String.valueOf(opciones.getSelectedItem())));
                mensajePaquete.setFileData(byteRead);
                
                ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
                paqueteDatos.writeObject(mensajePaquete);
                
            } catch (IOException ex) {
                System.out.println("Error EventoBtnFile: " + ex.getMessage());
            }
            
        }
    }
    
}
