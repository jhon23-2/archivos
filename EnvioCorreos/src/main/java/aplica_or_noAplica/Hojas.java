package aplica_or_noAplica;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import java.io.File;
import java.util.List;

public class Hojas {

    private List<?> lista;

    public List<HojaRangosFechas> listaRangoFechas() {

        PoijiOptions opciones = PoijiOptions.PoijiOptionsBuilder
                .settings()
                .sheetIndex(0)
                .build();

        lista = Poiji.fromExcel(new File("C:\\Users\\lcamp\\Downloads\\aplica_noAplica.xlsx"), HojaRangosFechas.class, opciones);

        return (List<HojaRangosFechas>) lista;
    }

    public List<HojaFecha_aValidar> fechasValidar() {

        PoijiOptions opciones = PoijiOptions.PoijiOptionsBuilder
                .settings()
                .sheetIndex(1)
                .build();

        lista = Poiji.fromExcel(new File("C:\\Users\\lcamp\\Downloads\\aplica_noAplica.xlsx"), HojaFecha_aValidar.class, opciones);

        return (List<HojaFecha_aValidar>) lista;
    }

}
