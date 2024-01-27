package any_all_none.Match;

import java.util.List;


/*
    El anyMatch que viene de el flujo de Stream de java acepta un predicare es decir que devuelve true o false si se cumple cierto criterio 
    este metodo lo que hace internamente es buscar en dicha lista de elementos el un elemento que cumpla con ciertos criterios cuando lo encuantra 
    finaliza la ejecucion (break) y devuelve true o false en caso de que el criterio establecido sea cierto;
 */
public class anyMatch_Example {
    
    public static void main(String[] args) {
        
        List<Persona> personas = List.of(
                new Persona(20, "Jhonatan"),
                new Persona(20, "Rafa"),
                new Persona(31, "David"),
                new Persona(22, "Sandy")
        );
        
        boolean rpt = personas.stream().anyMatch(p -> p.getNombre().startsWith("J"));
 
        if(rpt)System.out.println("SI hay personas en la cual el valor inicial es una J");
        else System.out.println("NO hay personas en la cual el valor es una es una J");
    }
    
}

class Persona {
    
    private int edad;
    private String nombre;
    
    public Persona() {
    }
    
    public Persona(int edad, String nombre) {
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
    
    
    public void mostrarDaros() {
        
        System.out.println("\nNombre: " + nombre
                + "\nEdad: " + edad + "\n");
        
    }
    
}
