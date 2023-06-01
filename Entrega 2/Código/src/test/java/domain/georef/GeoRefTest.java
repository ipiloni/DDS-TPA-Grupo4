package domain.georef;

import domain.entities.ubicacion.Municipio;
import domain.entities.ubicacion.Provincia;
import domain.services.georef.ServicioGeoref;
import domain.services.georef.entities.ListadoDeMunicipios;
import domain.services.georef.entities.ListadoDeProvincias;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeoRefTest {
    private Optional<Municipio> municipio = Optional.of(new Municipio());
    private Optional<Provincia> provincia = Optional.of(new Provincia());
    private ServicioGeoref servicioGeoref = ServicioGeoref.instancia();

    @Test
    @DisplayName("El servicio brinda las 23 provincias de Argentina + CABA.")
    public void provinviasTotales() throws IOException {
        ListadoDeProvincias provincias = servicioGeoref.listadoDeProvincias();
        Assertions.assertEquals(24, provincias.cantidad);
    }
/*
    @Test
    @DisplayName("La provincia de Corrientes tiene a Monte Caseros como localidad.")
    public void provinciaTiene() throws IOException {
        ListadoDeProvincias provincias = servicioGeoref.listadoDeProvincias();
        provincia = provincias.provinciaDeId(18);
        //ListadoDeMunicipios municipios = servicioGeoref.listadoDeMunicipiosDeProvincia(provincia);
    }*/



}
