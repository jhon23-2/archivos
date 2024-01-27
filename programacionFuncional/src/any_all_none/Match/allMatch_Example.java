package any_all_none.Match;

import java.util.List;

// En este caso el allmatch devuelve true o false dependiendo de el predicare pero con la condicion de que todos los datos deben cumplir con la condicion establecida

public class allMatch_Example {

    public static void main(String[] args) {

        // Ejemplo Uno
        List<Integer> numeros = List.of(2, 3, 3, 3);

        boolean rpta = numeros.stream()
                .allMatch(numero -> numero.equals(numeros.get(0)));

        System.out.println(rpta);

        //Ejemplo Dos
        List<String> nombres = List.of("Jhonatan", "Jose", "Jhon");

        boolean rpta2 = nombres.stream()
                .allMatch(nombre -> nombre.startsWith("J"));

        System.out.println(rpta2);

    }

}
