package domain.georef;

import domain.entities.ubicacion.Municipio;
import domain.entities.ubicacion.Provincia;
import domain.services.georef.entities.ListadoDeMunicipios;
import domain.services.georef.entities.ListadoDeProvincias;
import domain.services.georef.ServicioGeoref;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class GeoRefMainTest {

    public static void main(String[] args) throws IOException {
        ServicioGeoref servicioGeoref = ServicioGeoref.instancia();
        System.out.println("Seleccione una de las siguientes provincias, ingresando su id:");

        ListadoDeProvincias listadoDeProvinciasArgentinas = servicioGeoref.listadoDeProvincias();

        listadoDeProvinciasArgentinas.provincias.sort((p1, p2) -> p1.getId() >= p2.getId()? 1 : -1);

        for(Provincia unaProvincia:listadoDeProvinciasArgentinas.provincias){
            System.out.println(unaProvincia.getId() + ") " + unaProvincia.getNombre());
        }

        Scanner entradaEscaner = new Scanner(System.in);
        int idProvinciaElegida = Integer.parseInt(entradaEscaner.nextLine());

        Optional<Provincia> posibleProvincia = listadoDeProvinciasArgentinas.provinciaDeId(idProvinciaElegida);

        if(posibleProvincia.isPresent()){
            Provincia provinciaSeleccionada = posibleProvincia.get();
            ListadoDeMunicipios municipiosDeLaProvincia = servicioGeoref.listadoDeMunicipiosDeProvincia(provinciaSeleccionada);
            System.out.println("Los municipios de la provincia "+ provinciaSeleccionada.getNombre() +" son:");
            for(Municipio unMunicipio: municipiosDeLaProvincia.municipios){
                System.out.println(unMunicipio.getNombre());
            }
        }
        else{
            System.out.println("No existe la provincia seleccionada");
        }
    }
}
