package paqueteEnvio;


import java.io.Serializable;
import java.util.HashMap;

public class PaqueteMensaje implements Serializable {

    private String nick;
    private String ip;
    private String mensaje;

    private HashMap<String, String> ipes;

    private String name;
    private byte fileData[];

    public PaqueteMensaje() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getName() {
        return name;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public HashMap<String, String> getIpes() {
        return ipes;
    }

    public void setIpes(HashMap<String, String> ipes) {
        this.ipes = ipes;
    }

 
    public String getNick() {

        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
