package any_all_none.Match;

import java.util.List;


/*
En este caso el noneMatch valida que ningun dato de la lista tenga el predicare asociado
devuelve true si en ningun elemento de la lista esta la y
y devuelve false en caso  de que la lista tenga en ealgunos de sus elementos esta y
 */
public class noneMatch_Example {

    public static void main(String[] args) {
        List<String> nombres = List.of("Jhonatan", "SandY", "David");
        boolean rpta = nombres.stream()
                .noneMatch(nombre -> nombre.contains("Sandy"));

        System.out.println(rpta);

    }

}
