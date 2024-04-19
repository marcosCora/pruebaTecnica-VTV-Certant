package ModelsPersona;

import ModelsInspeccion.Inspeccion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.SimpleTimeZone;

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
        return "Inspector: " + "\n" +
                super.toString() +
                "\nEspecialidad: " + especialidad + '\'' +
                "\nInspecciones=" + listaInspecciones();
    }

    public String listaInspecciones(){
        String data = "Inspecciones: \n";
        for(Inspeccion i : inspecciones){
            data += i.toString();
        }
        return data;
    }


    public JSONObject toJson(){
        JSONObject jsonObject = super.toJson();
        try {
            jsonObject.put("especialidad", especialidad);
            JSONArray jsonArray = new JSONArray();
            for(Inspeccion i : inspecciones){
                jsonArray.put(i.toJson());
            }
            jsonObject.put("inspecciones", jsonArray);
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
            especialidad = jsonObject.getString("especialidad");
            JSONArray jsonArray = jsonObject.getJSONArray("inspecciones");
            for (int i = 0; i<jsonArray.length(); i++){
                Inspeccion inspeccion = new Inspeccion();
                inspeccion.fromJson(jsonArray.getJSONObject(i));
                inspecciones.add(inspeccion);
            }
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
