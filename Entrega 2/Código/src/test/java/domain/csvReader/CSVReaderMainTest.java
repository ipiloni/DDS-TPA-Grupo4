package domain.csvReader;

public class CSVReaderMainTest {

    public static void main(String[] args) throws IOException {
        CSVReader csvReader = new CSVReader();
        csvReader.leerCSV("documentos/CSV_de_prueba.csv");
    }
}