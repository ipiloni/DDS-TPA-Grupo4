package domain.entities.csvreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) throws IOException {
        // Agregar la ruta del archivo .csv en csvFile
        String csvFile = "documentos/CSV_de_prueba.csv";
        String line;
        String csvSplitBy = ";";

        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            String[] data = line.split(csvSplitBy);

            // Procesar los datos leídos del archivo CSV

            for (String value : data) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        br.close();
    }
}
