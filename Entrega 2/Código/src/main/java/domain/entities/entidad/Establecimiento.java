package entrega2.entidad;

import entrega2.servicio.PrestacionServicio;
import entrega2.ubicacion.Ubicacion;

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
}
