package ModelsGestoras;

import Interfaces.IArchivos;
import ModelsInspeccion.Inspeccion;
import ModelsInspeccion.Medicion;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class GestoraInspecciones implements IArchivos {

    private ArrayList<Inspeccion> inspecciones;

    public GestoraInspecciones(){
        inspecciones = new ArrayList<>();
    }


    public void agregar(Inspeccion i){ //lanzar expecion
        if(buscaInspeccionPorNro(i.getNroInspeccion()) == null){
            int ultimoId = inspecciones.size();
            i.setId(ultimoId +1);
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

    @Override
    public void guardarArchivo(String nombreArch) {
        JSONArray jsonArray = new JSONArray();
        for (Inspeccion i : inspecciones)
        {
            jsonArray.put(i.toJson());
        }
        jsonUtiles.grabar(jsonArray, nombreArch);
    }

    @Override
    public void leerArchivo(String nombreArch) {
        try {
            JSONArray jsonArray = new JSONArray(jsonUtiles.leer(nombreArch));
            for (int i = 0; i<jsonArray.length(); i++)
            {
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
