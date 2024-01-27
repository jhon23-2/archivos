package proyectoPrueba;

import java.awt.AWTException;

public class ProyectoPrueba {

    public static String mensaje = "";

    public static void main(String[] args) throws InterruptedException {
        Notificacion s = new Notificacion();
        mensaje = "Jhonatan";
        try {
            s.mje();

        } catch (AWTException ex) {
            System.out.println("Error: " + ex.getMessage());

        }

    }
}
