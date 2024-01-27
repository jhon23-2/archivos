package paqueteEnvio;


import java.util.Hashtable;
import java.util.Map;

public class DireccionesValores {

    private static DireccionesValores instancia = null;
    private Hashtable<String, String> valoresYdirecciones;

    private DireccionesValores() {
        valoresYdirecciones = new Hashtable<String, String>();
    }

    public static DireccionesValores getInstance() {
        if (instancia == null) {
            instancia = new DireccionesValores();
        }

        return instancia;
    }

    public void agregarElementos(String key, String value) {

        valoresYdirecciones.put(key, value);
    }

    public String obtenerClave(String value) {

        String key = "";

        for (Map.Entry<String, String> entry : valoresYdirecciones.entrySet()) {

            if (entry.getValue().equalsIgnoreCase(value)) {
                key = entry.getKey();
                break;
            }

        }

        return key;

    }

}
