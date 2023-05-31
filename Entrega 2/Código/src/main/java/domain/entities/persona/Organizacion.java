package entrega2.persona;

import entrega2.entidad.Entidad;

import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    private Usuario usuario;
    private String razonSocial;
    private String mailEncargado;
    private List<Entidad> entidades;

    private TipoOrganizacion tipoOrganizacion;

    public Organizacion(){
        this.entidades = new ArrayList<>();
    }

    public void agregarEntidad(Entidad entidad) {
        this.entidades.add(entidad);
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setMailEncargado(String mailEncargado) {
        this.mailEncargado = mailEncargado;
    }

    public void setTipoOrganizacion(TipoOrganizacion tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
    }

}
