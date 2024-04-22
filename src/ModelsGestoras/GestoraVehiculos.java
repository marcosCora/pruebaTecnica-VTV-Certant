package ModelsGestoras;

import Interfaces.IArchivos;
import ModelsExcepcion.MiExcepcionVehiculo;
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

    public void agregar(Vehiculo v)throws MiExcepcionVehiculo {
        if(buscaVehiculoXDominio(v.getDominio()) == null){
            int ultimoId = vehiculos.size();
            v.setId(ultimoId +1);
            vehiculos.add(v);
        }else {
            throw new MiExcepcionVehiculo("El vehiculo que desea agregar ya se eneuntra");
        }
    }

    public String returnFechaVencimcientoVtv(String dominio) throws MiExcepcionVehiculo{
        Vehiculo v = buscaVehiculoXDominio(dominio);
        String fecha = "";
        if (v != null && v.getFechaVencimientoVtv().equals("") == false){
            fecha = v.getFechaVencimientoVtv();
        }else{
            throw new MiExcepcionVehiculo("El vehiculo no existe o aun no tiene fecha asignada");
        }
        return  fecha;
    }

    public String listar(){
        String info = "";
        for(Vehiculo v : vehiculos){
            info += "\n" + v.toString();
        }

        return info;
    }

    public void eliminarVehiculo(String dominio) throws MiExcepcionVehiculo {
        Vehiculo vAEliminar = buscaVehiculoXDominio(dominio);
        if(vAEliminar != null){
            vehiculos.remove(vAEliminar);
        }
        else{
            throw new MiExcepcionVehiculo("El Vehiculo que desea elimianr no se encuentra.");
        }
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
