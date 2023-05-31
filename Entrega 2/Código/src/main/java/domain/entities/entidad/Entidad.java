package entrega2.entidad;

import java.util.ArrayList;
import java.util.List;

public class Entidad {
    private String nombre;
    private List<Establecimiento> establecimientos;

    public Entidad(){
        this.establecimientos = new ArrayList();
    }
}
