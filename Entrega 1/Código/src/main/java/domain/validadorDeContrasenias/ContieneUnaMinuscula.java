package domain.validadorDeContrasenias;

public class ContieneUnaMinuscula extends Validacion {

    @Override
    public Boolean validar(String contrasenia) {
        return contrasenia.matches(".*[a-z].*");
    }

    @Override
    public String reportarError() {
        return "La contraseña debe tener al menos una letra minuscula.\n";
    }
}
