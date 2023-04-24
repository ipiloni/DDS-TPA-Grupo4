package domain.validadorDeContrasenias;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EsSencilla extends Validacion {
    private ArrayList<String> clavesAValidar = new ArrayList<String>();

    /* Al inicializarse la clase, se leen las 10.000 peores contrasenias
       desde el archivo .txt y se las aniade a la lista clavesAValidar */
    public EsSencilla() throws IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/top_10k_worst_passwords.txt"));
        String line = bufReader.readLine();

        while (line != null) {
            clavesAValidar.add(line);
            line = bufReader.readLine();
        }
        bufReader.close();
    }

    @Override
    public Boolean validar(String contrasenia){
        return !clavesAValidar.contains(contrasenia.toLowerCase());
    }

    @Override
    public String reportarError(){
        return "La contraseña es muy debil.\n";
    }

}
