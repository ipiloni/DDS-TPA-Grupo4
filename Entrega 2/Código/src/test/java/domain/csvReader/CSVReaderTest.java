package domain.csvReader;

import domain.entities.csvreader.CSVReader;
import domain.entities.entidad.Entidad;
import domain.entities.entidad.Establecimiento;
import domain.entities.persona.Organizacion;
import domain.entities.persona.TipoOrganizacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReaderTest {

    CSVReader csvReader = new CSVReader();
    List<Organizacion> organizaciones;
    List<Entidad> entidades;
    List<Establecimiento> establecimientos;

    @BeforeEach
    public void inicializar() throws IOException {
        csvReader.leerCSV("documentos/CSV_de_prueba.csv", ";");
        organizaciones = csvReader.getOrganizaciones();
    }

    @Test
    @DisplayName("CSV lee correctamente 4 Organizaciones")
    public void leeOrganizaciones() {
        Assertions.assertEquals(5, organizaciones.size());
    }

    @Test
    @DisplayName("Supermercado XYZ se obtiene correctamente")
    public void organizacionEsCorrecta() {
        Organizacion organizacion = organizaciones.get(0);
        Entidad entidad = organizacion.getEntidades().get(0);
        Assertions.assertEquals(organizacion.getRazonSocial(), "supermercado xyz");
        Assertions.assertEquals(organizacion.getTipoOrganizacion(), TipoOrganizacion.ENTIDAD_PROPIETARIA);
        Assertions.assertEquals(organizacion.getMail(), "marquitosgurru@hotmail.com");
        Assertions.assertEquals(organizacion.getEntidades().size(), 1);
        Assertions.assertEquals(entidad.getEstablecimientos().size(), 2);
    }

    @Test
    @DisplayName("Transporte Publico SA tiene 2 entidades con 2 y 3 establecimientos respectivamente")
    public void organizacionCumpleTodo() {
        Organizacion organizacion = organizaciones.get(2);
        List<String> entidades = organizacion.getEntidades().stream().map(e -> e.getNombre()).collect(Collectors.toList());
        List<Establecimiento> establecimientos = organizacion.getEntidades().stream().map(e -> e.getEstablecimientos()).flatMap(List::stream).collect(Collectors.toList());
        Assertions.assertEquals(organizacion.getRazonSocial(), "transporte publico s.a.");
        Assertions.assertEquals(organizacion.getTipoOrganizacion(), TipoOrganizacion.ENTIDAD_PROPIETARIA);
        Assertions.assertEquals(entidades.get(0), "linea a de subte");
        Assertions.assertEquals(entidades.get(1), "linea b de subte");
        Assertions.assertEquals(establecimientos.size(), 5);
    }

    @Test
    @DisplayName("Autoridad Reguladora de BA cumple con tipo organizacion y no tiene Establecimientos")
    public void autoridadReguladora() {
        Organizacion organizacion = organizaciones.get(3);
        Assertions.assertEquals(organizacion.getRazonSocial(), "autoridad reguladora de buenos aires");
        Assertions.assertEquals(organizacion.getTipoOrganizacion(), TipoOrganizacion.ORGANISMO_CONTROL);
        Assertions.assertEquals(organizacion.getEntidades().size(), 1);
        Assertions.assertEquals(organizacion.getEntidades().get(0).getNombre(), "linea d de subte");
    }
}
