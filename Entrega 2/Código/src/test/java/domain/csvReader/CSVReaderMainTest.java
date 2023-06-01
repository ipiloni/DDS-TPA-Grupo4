package domain.csvReader;

import domain.entities.csvreader.CSVReader;

import java.io.IOException;

public class CSVReaderMainTest {

    public static void main(String[] args) throws IOException {
        CSVReader csvReader = new CSVReader();
        csvReader.leerCSV("documentos/CSV_de_prueba.csv", ";");
    }
}