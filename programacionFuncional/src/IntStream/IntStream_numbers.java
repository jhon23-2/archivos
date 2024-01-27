package IntStream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStream_numbers {

    public static void main(String[] args) {

        //IntStream_numbers.numerosAleatorios(0,6,5);
        //IntStream_numbers.promedioNumeros(1,10);



    }

    /*DESCRIPCION METODO
     * En este ejemplo creamos un metodo que crea numeros aleatorios no repetidos de una manera funcional
     * en la clase RANDON existe un metodo llamado INTS que esta sobrecargado y acepta dos numeros como
     * parametros las cuales son desde hasta es decir genera un numero aleatorio en el rango estimulado
     * ademas de esto devuelve un IntStream lo ques muy conveniente ya que podemos usar el paradigma fun
     * cioanl para hacer dichas operaciones con los numeros aleatorios generados*/
    public static void numerosAleatorios(int desde, int hasta, int cantidad) {
        Random random = new Random();

        List<Integer> numerosAleatorios = random.ints(desde, hasta)
                .boxed()//convierte la secuencia de intStream en datos integer
                .distinct()
                .limit(cantidad)
                .collect(Collectors.toList());

        numerosAleatorios.forEach(System.out::println);

        System.out.println("Numero mayor Generado: " + numerosAleatorios.stream().max(Integer::compare));
        System.out.println("Numero menor Generado: " + numerosAleatorios.stream().min(Integer::compare));

    }

    /*
     * Descripcion
     * El metodo average de la interfaz funcional IntStream es un metodo que nos proporciona la media aritmetica de
     * una secuencia de elementos es decir el promedio de una serie de elementos*/

    public static void promedioNumeros(int desde, int hasta) {

        OptionalDouble promedio = IntStream.rangeClosed(desde, hasta)
                .average();

        System.out.println("Promedio de numeros: " + promedio.toString());

    }

    /*
    * DESCRIPCION
    * en este metodo calculanos el promedio de las edades pero esta vez con los metodos que nos proporciona la
    * interfaz funcional Stream.
    * puede hacerce tambien con la IF IntStream pero esta es una manera mas optima*/

    public static double promedioEdades(){

        List<IntStream_numbers> personas = Arrays.asList(
                new IntStream_numbers(12,"Jhonatan"),
                new IntStream_numbers(13,"Andres"),
                new IntStream_numbers(14,"Carlos"),
                new IntStream_numbers(15,"maria")
        );

        double promedio = personas.stream()
                .collect(Collectors.averagingInt(IntStream_numbers::getEdad));
        return promedio;
    }

    private int edad;
    private String nombre;

    public IntStream_numbers(int edad, String nombre) {
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
}

