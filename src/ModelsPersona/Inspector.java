package ModelsPersona;

import ModelsInspeccion.Inspeccion;

import java.util.ArrayList;

public class Inspector extends Persona{
    private String especialidad;
    private ArrayList<Inspeccion> inspecciones;

    public Inspector() {
        super();
        this.especialidad = "";
        this.inspecciones = new ArrayList<>();
    }

    public Inspector(int id, String nombre, String apellido, String dni, String direccion, String telefono, String especialidad, ArrayList<Inspeccion> inspecciones) {
        super(id, nombre, apellido, dni, direccion, telefono);
        this.especialidad = especialidad;
        this.inspecciones = inspecciones;
    }


    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Inspeccion> getInspecciones() {
        return inspecciones;
    }

    public void setInspecciones(ArrayList<Inspeccion> inspecciones) {
        this.inspecciones = inspecciones;
    }

    @Override
    public String toString() {
        return "Inspector{" +
                super.toString() +
                "especialidad='" + especialidad + '\'' +
                ", inspecciones=" + inspecciones +
                '}';
    }


}
