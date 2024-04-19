package ModelsInspeccion;

import ModelsEnums.Resultado;

public abstract class Control {

    private int id;
    private String descripcion;
    private Resultado resultado;

    public Control(){
        this.id = 0;
        this.descripcion = "";
        this.resultado = null;
    }

    public Control(int id, String descripcion, Resultado r){
        this.id = id;
        this.descripcion = descripcion;
        this.resultado = r;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Resultado getResultado() {
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj != null){
            if(obj instanceof Control){
                Control aux = (Control) obj;
                if(id == aux.getId() && descripcion.equals(aux.descripcion) && resultado.equals(aux.resultado)){
                    rta = true;
                }
            }
        }
        return rta;
    }

    /*
    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, resultado);
    }*/

    @Override
    public String toString() {
        return "Control{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", resultado=" + resultado +
                '}';
    }
}
