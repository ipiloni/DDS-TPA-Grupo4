package domain.entities.validadorDeContrasenias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Validador {

    private List<Validacion> validaciones;

    public Validador() {
        this.validaciones = new ArrayList<>();
    }

    public void agregarValidacion(Validacion ... validacionesNuevas) {
        Collections.addAll(this.validaciones, validacionesNuevas);
    }

    public Boolean esContraseniaValida(String contrasenia) {
        return this.cantidadDeValidacionesQuePasa(contrasenia) == validaciones.stream().count();
    }

    public long cantidadDeValidacionesQuePasa(String contrasenia){
        return validaciones.stream().filter(validacion -> validacion.pasaValidacion(contrasenia)).count();
    }

    public String esContraseniaValidaConDetalle(String contrasenia){
        String errores = validaciones.stream().map(validacion -> validacion.pasaValidacionConDetalle(contrasenia)).collect(Collectors.joining(""));

        if (errores.equals(""))
            return "La contraseña es correcta.";
        else
            return errores;
    }
}
