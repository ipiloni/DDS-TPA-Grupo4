package domain.validadorDeContrasenias;

public class TieneLongitudCorrecta extends Validacion {

    private Integer longitudMinima;

    public TieneLongitudCorrecta(Integer longitudMinima) {
        this.longitudMinima = longitudMinima;
    }

    public void setLongitudMinima(Integer longitudMinima){
        this.longitudMinima = longitudMinima;
    }

    @Override
    public Boolean validar(String contrasenia) {
        return contrasenia.length() >= longitudMinima;
    }

    @Override
    public String reportarError(){
        return "La contraseña debe tener una longitud mínima de " + this.longitudMinima + " caracteres.\n";
    }
}
