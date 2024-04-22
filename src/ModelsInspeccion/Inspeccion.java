package ModelsInspeccion;

import Interfaces.IFormatFecha;
import ModelsEnums.Resultado;
import ModelsPersona.Inspector;
import ModelsVehiculo.Vehiculo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Inspeccion implements IFormatFecha {

    private int id;
    private String fecha;
    private Observacion observacion;
    private ArrayList<Medicion> mediciones;
    private boolean exento;
    private String dniInspector;
    private String dominioVehiculo;

    public Inspeccion() {
        this.id = 0;
        this.fecha = fechaFormateada();
        this.observacion = new Observacion();
        this.mediciones = new ArrayList<Medicion>();
        this.exento = false;
        this.dniInspector = "";
        this.dominioVehiculo = "";
    }
    public Inspeccion(int id, int nroInspeccion, Observacion observacion, ArrayList<Medicion> mediciones, boolean exento, String dniInspector, String dominioVehiculo) {
        this.id = id;
        this.fecha = fechaFormateada();
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

    public String getDniInspector() {
        return dniInspector;
    }

    public void setdniInspector(String dniInspector) {
        this.dniInspector = dniInspector;
    }

    public String getDominioVehiculo() {
        return dominioVehiculo;
    }

    public void setDominioVehiculo(String dominioVehiculo) {
        this.dominioVehiculo = dominioVehiculo;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj != null){
            if(obj instanceof Inspeccion){
                Inspeccion aux = (Inspeccion) obj;
                if(id == aux.id && dominioVehiculo.equals(((Inspeccion) obj).dominioVehiculo) && dniInspector.equals(aux.dniInspector)){
                    rta = true;
                }
            }
        }
        return rta;
    }

    @Override
    public String fechaFormateada() {
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return fechaActual.format(fechaFormateada);
    }

    @Override
    public String toString() {
        return "\nInspeccion Nº " + id +
                "\nFecha: " + fecha +
                "\nExento: " + exento +
                "\nDominio Vehiculo: " + dominioVehiculo +
                "\nDNI Inspector: " + dniInspector +
                "\nResultado: " + resultadoInspeccion();

    }

    public String listarMediciones(){
        String info = "";
        for(Medicion m : mediciones){
            info += "\n" + m.toString();
        }
        return info;
    }

    //agrega medicion al array de mediciones
    public  void agreagr(Medicion m){
        if(m != null){
            int ultimoId = mediciones.size();
            m.setId(ultimoId +1);
           mediciones.add(m);
        }
    }

    //agrega observacion
    public  void agreagr(Observacion o){
        if(o != null){
            observacion = o;
        }
    }

    public Resultado resultadoMediciones(){
        Resultado rta = Resultado.APTO;
        int i  = 0;
        while (i < mediciones.size()){
            Resultado r = mediciones.get(i).getResultado();
            if(r == Resultado.CONDICIONAL || r == Resultado.RECHAZADO){
                rta = r;
            }
            i++;
        }
        return rta;
    }

    public Resultado resultadoInspeccion(){
        Resultado resultado = null;
        Resultado rObservacion = observacion.getResultado();
        Resultado rMediciones = resultadoMediciones();
        if (rObservacion == Resultado.APTO && rMediciones == Resultado.APTO) {
            resultado = Resultado.APTO;
        } else if (rObservacion == Resultado.RECHAZADO || rMediciones == Resultado.RECHAZADO) {
            resultado = Resultado.RECHAZADO;
        } else {
            resultado =  Resultado.CONDICIONAL;
        }
        return resultado;
    }

    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
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
