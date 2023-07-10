package domain.entities.csvreader;

import domain.entities.entidad.Entidad;
import domain.entities.entidad.Establecimiento;
import domain.entities.persona.Organizacion;
import domain.entities.persona.TipoOrganizacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CSVReader {
    private List<Organizacion> organizaciones = new ArrayList<>();
    private List<Entidad> entidades = new ArrayList<>();
    private List<Establecimiento> establecimientos = new ArrayList<>();

    public void leerCSV(String rutaDeArchivo, String tipoDeSeparacion) throws IOException {
        String csvFile = rutaDeArchivo;
        String line;
        String separarPor = tipoDeSeparacion;

        BufferedReader br = new BufferedReader(new FileReader(csvFile));

        br.readLine(); // lee la primer linea

        Organizacion organizacionAnterior = new Organizacion();
        organizacionAnterior.setRazonSocial("");
        Entidad entidadAnterior = new Entidad();
        entidadAnterior.setNombre("");
        Establecimiento establecimientoAnterior = new Establecimiento();
        establecimientoAnterior.setNombre("");

        while ((line = br.readLine()) != null) {
            String[] columnas = line.split(separarPor);
            if(!Objects.equals(organizacionAnterior.getRazonSocial(), adaptarString(columnas[0]))) {
                Organizacion organizacion = crearOrganizacion(columnas);
                organizaciones.add(organizacion);
                organizacionAnterior = organizacion;
            }
            if(!Objects.equals(entidadAnterior.getNombre(), adaptarString(columnas[2]))) {
                Entidad entidad = crearEntidad(columnas);
                organizacionAnterior.agregarEntidad(entidad);
                entidades.add(entidad);
                entidadAnterior = entidad;
            }
            if(columnas.length > 4 && !adaptarString(columnas[4]).equals("")) {
                if (!Objects.equals(establecimientoAnterior.getNombre(), adaptarString(columnas[4]))) {
                    Establecimiento establecimiento = crearEstablecimiento(columnas);
                    entidadAnterior.agregarEstablecimiento(establecimiento);
                    establecimientos.add(establecimiento);
                    establecimientoAnterior = establecimiento;
                }
            }
        }
        br.close();
    }

    private Entidad crearEntidad(String[] columnas) {
        Entidad entidad = new Entidad();
        entidad.setNombre(adaptarString(columnas[2]));
        return entidad;
    }

    private Organizacion crearOrganizacion(String[] columnas) {
        Organizacion organizacion = new Organizacion();
        organizacion.setRazonSocial(adaptarString(columnas[0]));
        organizacion.setTipoOrganizacion(obtenerTipoOrganizacion(columnas[1]));
        organizacion.setMailEncargado(columnas[3]);

        return organizacion;
    }

    private Establecimiento crearEstablecimiento(String[] columnas) {
        Establecimiento establecimiento = new Establecimiento();
        establecimiento.setNombre(adaptarString(columnas[4]));
        return establecimiento;
    }

    private String adaptarString(String palabra) {
        String normalizar = Normalizer.normalize(palabra, Normalizer.Form.NFD);
        String sinTildes = normalizar.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        String retornarPalabra = sinTildes.toLowerCase();

        return retornarPalabra;
    }

    private TipoOrganizacion obtenerTipoOrganizacion(String columna) {
        switch (columna.toLowerCase()) {
            case "entidad propietaria":
                return TipoOrganizacion.ENTIDAD_PROPIETARIA;
            case "organismo de control":
                return TipoOrganizacion.ORGANISMO_CONTROL;
            default: break;
        }
        return null;
    }

    public List<Entidad> getEntidades() { return entidades; }

    public List<Establecimiento> getEstablecimientos() { return establecimientos; }

    public List<Organizacion> getOrganizaciones() { return organizaciones; }
}
