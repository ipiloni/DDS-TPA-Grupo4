package domain.entities.entidad;

import domain.entities.servicio.PrestacionServicio;
import domain.entities.ubicacion.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {
    private String nombre;
    private Ubicacion ubicacion;
    private List<PrestacionServicio> servicios;

    public Establecimiento(){
        this.servicios = new ArrayList<>();
    }

    public void agregarServicio(PrestacionServicio servicio) {
        this.servicios.add(servicio);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getNombre() { return nombre; }
}
