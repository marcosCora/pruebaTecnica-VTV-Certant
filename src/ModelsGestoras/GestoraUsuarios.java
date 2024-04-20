package ModelsGestoras;

import Interfaces.IArchivos;
import ModelsEnums.TipoDueno;
import ModelsInspeccion.Inspeccion;
import ModelsPersona.Inspector;
import ModelsPersona.PropietarioVehiculo;
import ModelsVehiculo.Vehiculo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GestoraUsuarios{

    private ArrayList<Inspector> inspectores;
    private ArrayList<PropietarioVehiculo> propietariosV;

    public GestoraUsuarios() {
        this.inspectores = new ArrayList<>();
        this.propietariosV = new ArrayList<>();
    }

    public GestoraUsuarios(ArrayList<Inspector> inspectores, ArrayList<PropietarioVehiculo> propietariosV) {
        this.inspectores = inspectores;
        this.propietariosV = propietariosV;
    }

    //Funciones de inspectores

    public boolean agregar(Inspector i){
        boolean flag = false;
        Inspector iExistente = buscaInspector(i);

        if(iExistente == null){
            i.setId(buscaUltimoIdInspector()+1);
            flag = inspectores.add(i);
        }
        return flag;
    }

    public int buscaUltimoIdInspector(){
        return !inspectores.isEmpty() ? (inspectores.get(inspectores.size()-1)).getId() : 0;
    }

    public Inspector buscaInspector(Inspector inspectorABuscar){
        Inspector rta = null;
        for(Inspector i : inspectores){
            if(i.equals(inspectorABuscar)){
                rta = i;
            }
        }
        return rta;
    }

    public String listarInspectores(){
        String info = "";
        for (Inspector i : inspectores){
            info += "\n" + i.toString();
        }
        return info;
    }

    public void eliminarInspector(String dni){
        Inspector aEliminar = buscaInspectorXDni(dni);
        if(aEliminar != null){
            inspectores.remove(aEliminar);
        }
    }

    public Inspector buscaInspectorXDni(String dni){
        Inspector i = null;
        for (Inspector aux : inspectores) {
            if (aux.getDni().equals(dni)) {
                i = aux;
            }
        }
        return i;
    }

    public void guardarArchivoInspectores(String nombreArch) {
        JSONArray jsonArray = new JSONArray();
        for (Inspector i : inspectores)
        {
            jsonArray.put(i.toJson());
        }
        jsonUtiles.grabar(jsonArray, nombreArch);
    }

    public void leerArchivoInspectores(String nombreArch) {
        try {
            JSONArray jsonArray = new JSONArray(jsonUtiles.leer(nombreArch));
            for (int i = 0; i<jsonArray.length(); i++)
            {
                Inspector inspector = new Inspector();
                inspector.fromJson(jsonArray.getJSONObject(i));
                inspectores.add(inspector);
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

    public void agregarInspecciones(Inspeccion i, String dni){
        Inspector inspector = buscaInspectorXDni(dni);
        if(inspector != null){
            inspector.addInspeccion(i);
        }
    }

    //Propietarios

    public PropietarioVehiculo buscarPropietarioDni(String dni){
        PropietarioVehiculo p = null;
        for (PropietarioVehiculo aux : propietariosV) {
            if (aux.getDni().equals(dni)) {
                p = aux;
            }
        }
        return p;
    }

    public void agregar(PropietarioVehiculo p){
        if(p != null){
            int ultimoId = propietariosV.size();
            p.setId(ultimoId+1);
            propietariosV.add(p);
        }
    }

    //agrega un vehiculo a su correspondiente dueño
    public void agregarVehiculoP(Vehiculo v, String dni){
        PropietarioVehiculo p = buscarPropietarioDni(dni);
        if(p != null){
            p.addVehiculo(v);
        }
    }

    public String listarPropietarios(){
        String info = "";
        for(PropietarioVehiculo p : propietariosV){
            info += "\n" + p.toString();
        }

        return info;
    }




    public void guardarArchivoPropietarios(String nombreArch) {
        JSONArray jsonArray = new JSONArray();
        for (PropietarioVehiculo p : propietariosV) {
            jsonArray.put(p.toJson());
        }
        jsonUtiles.grabar(jsonArray, nombreArch);
    }

    public void leerArchivoPropietarios(String nombreArch) {
        try {
            JSONArray jsonArray = new JSONArray(jsonUtiles.leer(nombreArch));
            for (int i = 0; i<jsonArray.length(); i++)
            {
                PropietarioVehiculo p = new PropietarioVehiculo();
                p.fromJson(jsonArray.getJSONObject(i));
                propietariosV.add(p);
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
