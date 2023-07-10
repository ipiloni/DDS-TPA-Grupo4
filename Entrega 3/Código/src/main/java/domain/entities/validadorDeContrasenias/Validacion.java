package domain.entities.validadorDeContrasenias;

public abstract class Validacion {

    public Boolean pasaValidacion(String contrasenia) {
        return validar(contrasenia);
    }

    public String pasaValidacionConDetalle(String contrasenia){
        if(validar(contrasenia))
            return "";
        else {
            return this.reportarError();
        }
    }

    public abstract Boolean validar(String contrasenia);

    public abstract String reportarError();
}
