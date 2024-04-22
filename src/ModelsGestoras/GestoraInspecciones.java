package ModelsGestoras;

import Interfaces.IArchivos;
import ModelsEnums.Resultado;
import ModelsExcepcion.MiExcepcionInspeccion;
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


    public void agregar(Inspeccion i){
        if(buscaInspeccionPorNro(i.getId()) == null){
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
            if(nro == inspecciones.get(i).getId()){
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
            info += "\n\n" + i.toString();
        }
        return info;
    }

    public void eliminar(int nroI) throws MiExcepcionInspeccion{
        Inspeccion aEliminar = buscaInspeccionPorNro(nroI);
        if(aEliminar != null){
            inspecciones.remove(aEliminar);
        }else {
            throw new MiExcepcionInspeccion("La inspeccion que intenta eliminar no se a encontrado.");
        }
    }

    public String retornaDominioV(int i){
        String dominio = null;
        if(i < inspecciones.size()){
            dominio = inspecciones.get(i).getDominioVehiculo();
        }
        return dominio;
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
