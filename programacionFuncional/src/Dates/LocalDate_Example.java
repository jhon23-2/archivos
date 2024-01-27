package Dates;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class LocalDate_Example {

    public static void main(String[] args) {

        new LocalDate_Example().periodoDtiempo_entreDosFechas();
        new LocalDate_Example().validarFecha_entreDosFechas(LocalDate.of(2023, Month.DECEMBER, 10), LocalDate.of(2023, Month.DECEMBER, 20), LocalDate.of(2023, Month.DECEMBER, 9));

    }

    public void periodoDtiempo_entreDosFechas() {

        LocalDate cumpleanios = LocalDate.of(2003, Month.JANUARY, 24);
        LocalDate fechaAcDate = LocalDate.now();
        Period periodo = Period.between(cumpleanios, fechaAcDate);
        System.out.println("Anios: " + periodo.getYears()
                + "\nMeses: " + periodo.getMonths()
                + "\nDias: " + periodo.getDays());

    }

    public void validarFecha_entreDosFechas(LocalDate fechaInicio, LocalDate fechaFin, LocalDate validar) {

        if (!validar.isBefore(fechaInicio) && !validar.isAfter(fechaFin)) {
            System.out.println("La fecha es valida");
        } else {
            System.out.println("La fecha es INVALIDAD");
        }
    }

}
