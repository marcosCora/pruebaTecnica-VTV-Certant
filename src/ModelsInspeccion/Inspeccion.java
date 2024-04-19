package ModelsInspeccion;

import ModelsPersona.Inspector;
import ModelsVehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Inspeccion {

    private int id;
    private int nroInspeccion;
    private String fecha;
    private Observacion observacion;
    private ArrayList<Medicion> mediciones;
    private boolean exento;
    private Inspector inspector;
    private Vehiculo vehiculo;

    public Inspeccion() {
        this.id = 0;
        this.nroInspeccion = 0;
        this.fecha = "";
        this.observacion = new Observacion();
        this.mediciones = new ArrayList<Medicion>();
        this.exento = false;
        this.inspector = new Inspector();
        this.vehiculo = new Vehiculo();
    }
    public Inspeccion(int id, int nroInspeccion, String fecha, Observacion observacion, ArrayList<Medicion> mediciones, boolean exento, Inspector inspector, Vehiculo vehiculo) {
        this.id = id;
        this.nroInspeccion = nroInspeccion;
        this.fecha = fecha;
        this.observacion = observacion;
        this.mediciones = mediciones;
        this.exento = exento;
        this.inspector = inspector;
        this.vehiculo = vehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNroInspeccion() {
        return nroInspeccion;
    }

    public void setNroInspeccion(int nroInspeccion) {
        this.nroInspeccion = nroInspeccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public void setObservacion(Observacion observacion) {
        this.observacion = observacion;
    }

    public ArrayList<Medicion> getMediciones() {
        return mediciones;
    }

    public void setMediciones(ArrayList<Medicion> mediciones) {
        this.mediciones = mediciones;
    }

    public boolean isExento() {
        return exento;
    }

    public void setExento(boolean exento) {
        this.exento = exento;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj != null){
            if(obj instanceof Inspeccion){
                Inspeccion aux = (Inspeccion) obj;
                if(id == aux.id && nroInspeccion == aux.nroInspeccion && vehiculo.equals(((Inspeccion) obj).vehiculo) && inspector.equals(aux.inspector)){
                    rta = true;
                }
            }
        }
        return rta;
    }

    @Override
    public String toString() {
        return "Inspeccion{" +
                "id=" + id +
                ", nroInspeccion=" + nroInspeccion +
                ", fecha='" + fecha + '\'' +
                observacion.toString() +
                mediciones.toString() +
                ", exento=" + exento +
                inspector.toString() +
                vehiculo.toString() +
                '}';
    }
}
