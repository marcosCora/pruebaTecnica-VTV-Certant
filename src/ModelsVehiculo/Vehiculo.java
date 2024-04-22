package ModelsVehiculo;

import Interfaces.IFormatFecha;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vehiculo implements IFormatFecha {
    private int id;
    private String marca;
    private String modelo;
    private String dominio;
    private String fechaVencimientoVtv;
    private String dniPropietario;

    public Vehiculo() {
        this.id = 0;
        this.marca = "";
        this.modelo = "";
        this.dominio = "";
        this.fechaVencimientoVtv = "";
        this.dniPropietario = " ";
    }

    public Vehiculo(int id, String marca, String modelo, String dominio, String fechaVencimientoVtv, String dniPropietario) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.dominio = dominio;
        this.fechaVencimientoVtv = fechaVencimientoVtv;
        this.dniPropietario = dniPropietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getFechaVencimientoVtv() {
        return fechaVencimientoVtv;
    }

    public void setFechaVencimientoVtv(String fechaVencimientoVtv) {
        this.fechaVencimientoVtv = fechaVencimientoVtv;
    }

    public String getPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj != null){
            if(obj instanceof Vehiculo){
                Vehiculo aux = (Vehiculo) obj;
                if(id == aux.id && dominio.equals(aux.dominio)){
                    rta = true;
                }
            }
        }
        return rta;
    }

    @Override
    public String toString() {
        return  "\nID: " + id +
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nDominio:" + dominio +
                "\nFecha de emision de VTV: " + fechaVencimientoVtv +
                "\nDni Propietario: " + dniPropietario;
    }

    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
            jsonObject.put("marca", marca);
            jsonObject.put("modelo", modelo);
            jsonObject.put("dominio", dominio);
            jsonObject.put("fechaVencimientoVtv", fechaVencimientoVtv);
            jsonObject.put("dniPropietario", dniPropietario);
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
            marca = jsonObject.getString("marca");
            modelo = jsonObject.getString("modelo");
            dominio = jsonObject.getString("dominio");
            fechaVencimientoVtv = jsonObject.getString("fechaVencimientoVtv");
            dniPropietario = jsonObject.getString("dniPropietario");

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


    @Override
    public String fechaFormateada() {
        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaUnAnioDespues = fechaActual.plusYears(1);
        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return fechaUnAnioDespues.format(fechaFormateada);
    }
}
