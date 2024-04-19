package ModelsGestoras;

import ModelsPersona.Inspector;
import ModelsPersona.PropietarioVehiculo;

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

    public boolean agregarInspector(Inspector i){
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
    public String listarInspectores(){
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




















    public void agregarPropietarios(PropietarioVehiculo p){
        propietariosV.add(p);
    }







}
