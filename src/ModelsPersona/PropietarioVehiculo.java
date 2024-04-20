package ModelsPersona;

import ModelsEnums.TipoDueno;
import ModelsInspeccion.Medicion;
import ModelsVehiculo.Vehiculo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        return "Propietarios: " +
                super.toString() +
                "\nVehiculos: " + listarVehiculos() +
                "\nTipo de dueño: " + tipoDueno;
    }

    public String listarVehiculos(){
        String info = "";
        if(vehiculos.size() > 0){
            for(Vehiculo v : vehiculos){
                info += "\n" + v.toString();
            }
        }else{
            info = "\nNo tiene vehiculo asignado";
        }
        return info;
    }

    public void addVehiculo(Vehiculo v){
        if(v != null){
            vehiculos.add(v);
        }
    }

    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = super.toJson();
            JSONArray jsonArray = new JSONArray();
            for(Vehiculo v : vehiculos){
                jsonArray.put(v.toJson());
            }
            jsonObject.put("vehiculos", jsonArray);
            jsonObject.put("tipoDueno", tipoDueno);
        }catch (JSONException ex){
            System.out.println(ex.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return jsonObject;
    }

    public void fromJson(JSONObject jsonObject) {
        try {
            super.fromJson(jsonObject);
            JSONArray jsonArray = jsonObject.getJSONArray("vehiculos");
            for(int i = 0; i<jsonArray.length(); i++){
                Vehiculo v = new Vehiculo();
                v.fromJson(jsonArray.getJSONObject(i));
                vehiculos.add(v);
            }
            String tipoD = jsonObject.getString("tipoDueno");
            tipoDueno = TipoDueno.valueOf(tipoD.toUpperCase());
        }
        catch (JSONException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
