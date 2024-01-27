package marcos;

import paneles.PanelServidor;
import java.net.UnknownHostException;
import javax.swing.JFrame;

public class FrameServidor extends JFrame {

    public static void main(String[] args) throws UnknownHostException {
        new FrameServidor().mostrarFrame();
        
    }

    public FrameServidor() {

    }

    public void mostrarFrame() {
        this.add(new PanelServidor());
        this.setBounds(0, 0, 400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Servidor");

    }

}
