package ModelsGestoras;

import ModelsInspeccion.Inspeccion;

import java.util.ArrayList;

public class GestoraInspecciones {

    private ArrayList<Inspeccion> inspecciones;

    public GestoraInspecciones(){
        inspecciones = new ArrayList<>();
    }


    public void agregar(Inspeccion i){ //lanzar expecion
        if(buscaInspeccionPorNro(i.getNroInspeccion()) == null){
            i.setId(inspecciones.get(inspecciones.size()-1).getId()+1);
            inspecciones.add(i);
        }
    }

    public Inspeccion buscaInspeccionPorNro(int nro){
        Inspeccion aBuscar = null;
        boolean flag = false;
        int i = 0;
        while (i < inspecciones.size() && flag == false){
            if(nro == inspecciones.get(i).getNroInspeccion()){
                aBuscar = inspecciones.get(i);
                flag = true;
            }
            i++;
        }
        return aBuscar;
    }

    public String listar(){
        String info = "";
        for(Inspeccion i : inspecciones){
            info += "\n" + i.toString();
        }
        return info;
    }

    public void eliminar(int nroI){
        Inspeccion aEliminar = buscaInspeccionPorNro(nroI);
        if(aEliminar != null){
            inspecciones.remove(aEliminar);
        }
    }







}
