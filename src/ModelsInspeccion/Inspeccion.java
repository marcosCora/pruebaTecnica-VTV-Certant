package ModelsInspeccion;

import ModelsPersona.Inspector;
import ModelsVehiculo.Vehiculo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    private String dniInspector;
    private String dominioVehiculo;

    public Inspeccion() {
        this.id = 0;
        this.nroInspeccion = 0;
        this.fecha = "";
        this.observacion = new Observacion();
        this.mediciones = new ArrayList<Medicion>();
        this.exento = false;
        this.dniInspector = "";
        this.dominioVehiculo = "";
    }
    public Inspeccion(int id, int nroInspeccion, String fecha, Observacion observacion, ArrayList<Medicion> mediciones, boolean exento, String dniInspector, String dominioVehiculo) {
        this.id = id;
        this.nroInspeccion = nroInspeccion;
        this.fecha = fecha;
        this.observacion = observacion;
        this.mediciones = mediciones;
        this.exento = exento;
        this.dniInspector = dniInspector;
        this.dominioVehiculo = dominioVehiculo;
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

    public String getInspector() {
        return dniInspector;
    }

    public void setInspector(String dniInspector) {
        this.dniInspector = dniInspector;
    }

    public String getVehiculo() {
        return dominioVehiculo;
    }

    public void setVehiculo(String dominioVehiculo) {
        this.dominioVehiculo = dominioVehiculo;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj != null){
            if(obj instanceof Inspeccion){
                Inspeccion aux = (Inspeccion) obj;
                if(id == aux.id && nroInspeccion == aux.nroInspeccion && dominioVehiculo.equals(((Inspeccion) obj).dominioVehiculo) && dniInspector.equals(aux.dniInspector)){
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
                "Dominio Vehiculo: " + dominioVehiculo +
                "DNI Inspector: " + dniInspector +
                '}';
    }

    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
            jsonObject.put("nroInspeccion", nroInspeccion);
            jsonObject.put("fecha", fecha);
            jsonObject.put("observacion", observacion.toJson());
            JSONArray jsonArray = new JSONArray();
            for(Medicion o : mediciones){
                jsonArray.put(o.toJson());
            }
            jsonObject.put("mediciones", jsonArray);
            jsonObject.put("exento", exento);
            jsonObject.put("dniInspector", dniInspector);
            jsonObject.put("dominioVehiculo", dominioVehiculo);


        }catch (JSONException ex){
            System.out.println(ex.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return jsonObject;
    }

    public void fromJson(JSONObject jsonObject) {
        try {
            id = jsonObject.getInt("id");
            nroInspeccion = jsonObject.getInt("nroInspeccion");
            fecha = jsonObject.getString("fecha");
            observacion.fromJson(jsonObject.getJSONObject("observacion"));
            JSONArray jsonArray = jsonObject.getJSONArray("mediciones");
            for(int i = 0; i<jsonArray.length(); i++){
                Medicion m = new Medicion();
                m.fromJson(jsonArray.getJSONObject(i));
                mediciones.add(m);
            }
            exento = jsonObject.getBoolean("exento");
            dominioVehiculo = jsonObject.getString("dominioVehiculo");
            dniInspector = jsonObject.getString("dniInspector");
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
