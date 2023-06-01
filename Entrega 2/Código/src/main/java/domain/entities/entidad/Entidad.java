package domain.entities.entidad;

import java.util.ArrayList;
import java.util.List;

public class Entidad {
    private String nombre;
    private List<Establecimiento> establecimientos;

    public Entidad(){
        this.establecimientos = new ArrayList();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEstablecimiento(Establecimiento establecimiento) {
        this.establecimientos.add(establecimiento);
    }

    public String getNombre() { return nombre; }

    public List<Establecimiento> getEstablecimientos() { return establecimientos; }
}
