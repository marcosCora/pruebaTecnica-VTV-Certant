package ModelsVehiculo;

import ModelsPersona.Persona;
import ModelsPersona.PropietarioVehiculo;

import java.util.Objects;

public class Vehiculo {
    private int id;
    private String marca;
    private String modelo;
    private String dominio;
    private String fechaEmisionVtv;
    private PropietarioVehiculo propietario;

    public Vehiculo() {
        this.id = 0;
        this.marca = "";
        this.modelo = "";
        this.dominio = "";
        this.fechaEmisionVtv = "";
        this.propietario = null;
    }

    public Vehiculo(int id, String marca, String modelo, String dominio, String fechaEmisionVtv, PropietarioVehiculo propietario) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.dominio = dominio;
        this.fechaEmisionVtv = fechaEmisionVtv;
        this.propietario = propietario;
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

    public String getFechaEmisionVtv() {
        return fechaEmisionVtv;
    }

    public void setFechaEmisionVtv(String fechaEmisionVtv) {
        this.fechaEmisionVtv = fechaEmisionVtv;
    }

    public PropietarioVehiculo getPropietario() {
        return propietario;
    }

    public void setPropietario(PropietarioVehiculo propietario) {
        this.propietario = propietario;
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
        return "Vehiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", dominio='" + dominio + '\'' +
                ", fechaEmisionVtv='" + fechaEmisionVtv + '\'' +
                ", propietario=" + propietario +
                '}';
    }
}
