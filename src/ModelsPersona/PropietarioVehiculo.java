package ModelsPersona;

import ModelsEnums.TipoDueno;
import ModelsVehiculo.Vehiculo;

import java.util.ArrayList;

public class PropietarioVehiculo extends Persona{

    private ArrayList<Vehiculo> vehiculos;
    private TipoDueno tipoDueno;

    public PropietarioVehiculo() {
        super();
        this.vehiculos = new ArrayList<>();
        this.tipoDueno = null;
    }

    public PropietarioVehiculo(int id, String nombre, String apellido, String dni, String direccion, String telefono, ArrayList<Vehiculo> vehiculos, TipoDueno tipoDueno) {
        super(id, nombre, apellido, dni, direccion, telefono);
        this.vehiculos = vehiculos;
        this.tipoDueno = tipoDueno;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public TipoDueno getTipoDueno() {
        return tipoDueno;
    }

    public void setTipoDueno(TipoDueno tipoDueno) {
        this.tipoDueno = tipoDueno;
    }

    @Override
    public String toString() {
        return "PropietarioVehiculo{" +
                super.toString() +
                "vehiculos=" + vehiculos +
                ", tipoDueno=" + tipoDueno +
                '}';
    }
}
