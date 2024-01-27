package programacionfuncional;

import java.util.List;
import java.util.stream.Collectors;

public class ProgramacionFuncional {

    private int edad;
    private String nombre;
    private String apellido;

    public ProgramacionFuncional() {
    }

    public ProgramacionFuncional(int edad, String nombre, String apellido) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return ""
                + "edad=" + edad + "\n"
                + "nombre=" + nombre + "\n"
                + "apellido=" + apellido + "\n\n";
    }

    public static void main(String[] args) {

        List<ProgramacionFuncional> lista
                = List.of(new ProgramacionFuncional(12, "Jhonatan", "Almanza"),
                        new ProgramacionFuncional(20, "Sandy", "Berben"),
                        new ProgramacionFuncional(3, "Luck", "Show"));
        
        
        lista.stream().sorted((p1,p2)->p2.getEdad()-p1.getEdad())
                    .forEach(System.out::println);

    }

}
