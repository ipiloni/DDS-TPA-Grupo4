package entrega2.csvreader;

import entrega2.persona.Organizacion;
import entrega2.persona.TipoOrganizacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    private String csvFile;
    private String line;
    private String separarPor = ";";

    public void leerCSV(String rutaDeArchivo) throws IOException {
        csvFile = rutaDeArchivo;
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        br.readLine(); // lee la primer linea

        Organizacion organizacion;

        String tipoOrg;
        String razonSocial;
        String mail;

        while ((line = br.readLine()) != null) {
            String[] columnas = line.split(separarPor);

            for(int i=0; i < columnas.length; i++) {
                organizacion = new Organizacion();
                switch(i) {
                    case 0:
                        organizacion.setTipoOrganizacion(this.leerPrimerColumna(columnas[i]));
                        break;
                    case 1:
                        organizacion.setRazonSocial(columnas[i]);
                        break;
                    case 2:
                        organizacion.setMailEncargado(columnas[i]);
                        break;
                }
            }

        }
        br.close();
    }

    private TipoOrganizacion leerPrimerColumna(String columna) {
        switch (columna.toLowerCase()) {
            case "entidad propietaria":
                return TipoOrganizacion.ENTIDAD_PROPIETARIA;
            case "organismo de control":
                return TipoOrganizacion.ORGANISMO_CONTROL;
            default: break;
        }
        return null;
    }
}
