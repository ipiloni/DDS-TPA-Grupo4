package domain.validadorDeContrasenias;

public class ContieneUnaMayuscula extends Validacion {

    @Override
    public Boolean validar(String contrasenia) {
        return contrasenia.matches(".*[A-Z].*");
    }

    @Override
    public String reportarError() {
        return "La contraseña debe tener al menos una letra mayuscula.\n";
    }
}
