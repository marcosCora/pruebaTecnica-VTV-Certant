package ModelsGestoras;

import ModelsEnums.TipoDueno;
import ModelsPersona.Inspector;
import ModelsPersona.PropietarioVehiculo;
import ModelsVehiculo.Vehiculo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GestoraUsuarios {

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
            i.setId(buscaUltimoId()+1);
            flag = inspectores.add(i);
        }
        return flag;
    }

    public int buscaUltimoId(){
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



    //posible interface
    public String listar(){
        String info = "";
        for (Inspector i : inspectores){
            info += "\n" + i.toString();
        }
        return info;
    }

    //posible interface
    public void eliminarInspector(String dni){
        Inspector aEliminar = buscaInspectorXDni(dni);
        if(aEliminar != null){
            inspectores.remove(aEliminar);
        }
    }

    //posible interface
    public Inspector buscaInspectorXDni(String dni){
        Inspector i = null;
        for (Inspector aux : inspectores) {
            if (aux.getDni().equals(dni)) {
                i = aux;
            }
        }
        return i;
    }







    /*
    public void guardarArch(String nombreArch){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        Vehiculo v = new Vehiculo(1, "Ford", "Falcon SP", "123 abc", "19-04-2024", "43392102");
        vehiculos.add(v);
        PropietarioVehiculo p = new PropietarioVehiculo(1, "Marcos", "Corasaniti", "43392102", "48 3344", "2262304691", vehiculos, TipoDueno.EXENTO);
        guardarArchivo(nombreArch, p);
    }
    public void guardarArchivo(String nombreArch, PropietarioVehiculo p){
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(p.toJson());
        jsonUtiles.grabar(jsonArray, nombreArch);
    }
    */

























    public void agregarPropietarios(PropietarioVehiculo p){
        propietariosV.add(p);
    }







}
