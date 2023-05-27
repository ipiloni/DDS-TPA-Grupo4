package domain.validadorDeContrasenias;

public class ContieneUnNumero extends Validacion {
    @Override
    public Boolean validar(String contrasenia) {
        return contrasenia.matches(".*[1-9].*");
    }

    @Override
    public String reportarError(){
        return "La contraseña debe tener al menos un numero.\n";
    }
}
