package ejersiciosPractica_funcional;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Random random = new Random();

        String nombre;
        boolean bandera = true;
        int idPrestamo = 0,i= 0;
        int cantidadPrestamos = 0;

        List<PrestamosVideojuegos> personaPrestamo = new ArrayList<PrestamosVideojuegos>();

        System.out.println("Desas prestas un video Juego: ");
        String opcion = leer.next();

        if (opcion.equalsIgnoreCase("si")) {

            List<Integer> idCliente = random.ints(50, 1, 1000)
                    .distinct()
                    .boxed()
                    .collect(Collectors.toList());

            while (bandera) {

                System.out.println("SELECCIONA UN VIDEOJUEGO");

                System.out.print("\n[1] -> Mario bros"
                        + "\n[2] -> Mario cars"
                        + "\n[3] -> Pes 2008"
                        + "\n[4] -> Dream league soccer"
                        + "\n[5] -> Salir"
                        + "\nIngresa el Juego a prestar: ");
                int opcionJuego = leer.nextInt();


                switch (opcionJuego) {
                    case 1 -> {
                        System.out.print("Ingresa tu nombre: ");
                        nombre = leer.next();
                        //TODO... cantidad de prestamos
                        idPrestamo++;
                        personaPrestamo.add(crearPrestamo(nombre, idCliente.get(i), cantidadPrestamos, idPrestamo, "Mario Bros"));
                        i++;
                    }
                    case 2 -> {
                        System.out.print("Ingresa tu nombre: ");
                        nombre = leer.next();
                        //TODO.. cantidad de prestamos
                        idPrestamo++;
                        personaPrestamo.add(crearPrestamo(nombre, idCliente.get(i), cantidadPrestamos, idPrestamo, "Mario Cars"));
                        i++;
                    }
                    case 3 -> {

                    }
                    case 4 -> {
                    }
                    default -> {
                        bandera = false;
                        System.out.println("Gracias por usar nuestro programa...");
                        personaPrestamo.forEach(System.out::println);
                    }
                }


            }


        } else {
            System.out.println("Your welcomne");
        }

    }

    public static PrestamosVideojuegos crearPrestamo(String nombreCliente, int idCliente, int cantPrestamos, int idPrestamo, String nombreJuego) {
        return new PrestamosVideojuegos.PrestamosBuilder()
                .nombreCliente(nombreCliente)
                .idCliente(idCliente)
                .numPrestamos(cantPrestamos)
                .videjuego(idPrestamo, nombreJuego)
                .build();
    }
}
