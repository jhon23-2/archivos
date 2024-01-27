package programacionfuncional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewMain {

    public static void main(String[] args) {

//        NewMain.recorrerYañadir(1, 10);
        NewMain.recorrerDistintic();
        

    }

    public static void recorrerYañadir(int desde, int hasta) {
        List<Integer> numeros = IntStream.rangeClosed(desde, hasta)
                .boxed() //Convierte el IntStream en una lista de tipo integer
                .collect(Collectors.toList());

        numeros.forEach(System.out::println);
    }

    public static void recorrerDistintic() {

        NewMain personaUno = new NewMain(12, "Jhonatan");
        NewMain personaDos = new NewMain(12, "Jhonatan");
        NewMain personaTres = new NewMain(17, "Leiner");
        NewMain personaCuatro = new NewMain(20, "Liliana");

        List<NewMain> personas = List.of(personaUno,personaDos,personaTres,personaCuatro);
        
        personas.stream()
                .distinct()
                .forEach(System.out::println);   
    }

    private int edad;
    private String nombre;

    public NewMain(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
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

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NewMain other = (NewMain) obj;
        if (this.edad != other.edad) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
    
    

    @Override
    public String toString() {
        return "NewMain{" + "edad=" + edad + ", nombre=" + nombre + '}';
    }

}
