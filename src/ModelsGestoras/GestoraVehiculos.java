package ModelsGestoras;

import Interfaces.IArchivos;
import ModelsInspeccion.Inspeccion;
import ModelsPersona.PropietarioVehiculo;
import ModelsVehiculo.Vehiculo;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class GestoraVehiculos implements IArchivos {

    private ArrayList<Vehiculo> vehiculos;

    public GestoraVehiculos(){
        vehiculos = new ArrayList<>();
    }


    public Vehiculo buscaVehiculoXDominio(String dominio){
        Vehiculo aBuscar = null;
        boolean flag = false;
        int i = 0;

        while (i < vehiculos.size() && flag == false){
            if(vehiculos.get(i).getDominio().equals(dominio)){
                aBuscar = vehiculos.get(i);
                flag = true;
            }
            i++;
        }
        return aBuscar;
    }

    public void agregar(Vehiculo v){ //lanzar expecion
        if(buscaVehiculoXDominio(v.getDominio()) == null){
            int ultimoId = vehiculos.size();
            v.setId(ultimoId +1);
            vehiculos.add(v);
        }
    }

    public String listar(){
        String info = "";
        for(Vehiculo v : vehiculos){
            info += "\n" + v.toString();
        }

        return info;
    }


    @Override
    public void guardarArchivo(String nombreArch) {
        JSONArray jsonArray = new JSONArray();
        for (Vehiculo v : vehiculos)
        {
            jsonArray.put(v.toJson());
        }
        jsonUtiles.grabar(jsonArray, nombreArch);
    }

    @Override
    public void leerArchivo(String nombreArch) {
        try {
            JSONArray jsonArray = new JSONArray(jsonUtiles.leer(nombreArch));
            for (int i = 0; i<jsonArray.length(); i++)
            {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.fromJson(jsonArray.getJSONObject(i));
                vehiculos.add(vehiculo);
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
