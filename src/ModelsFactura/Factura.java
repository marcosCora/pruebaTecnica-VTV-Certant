package ModelsFactura;

import java.util.Objects;

public class Factura {

    private int id;
    private String fecha;
    private String descripcion;
    private String dniPersona;
    private float total;

    public Factura() {
        this.id = 0;
        this.fecha = "";
        this.descripcion = "";
        this.dniPersona = "";
        this.total = 0;
    }

    public Factura(int id, String fecha, String descripcion, String dniPersona, float total) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.dniPersona = dniPersona;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj != null){
            if(obj instanceof Factura){
                Factura aux = (Factura) obj;
                if(id == aux.id && fecha.equals(aux.fecha) && dniPersona.equals(aux.dniPersona) && total == aux.total){
                    rta = true;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", dniPersona='" + dniPersona + '\'' +
                ", total=" + total +
                '}';
    }
}
