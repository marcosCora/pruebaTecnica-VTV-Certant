package ModelsInspeccion;

import ModelsEnums.Resultado;

public class Observacion extends Control{

    private String componentesInspeccionados;

    public Observacion(){
        super();
        this.componentesInspeccionados = "";
    }
    public Observacion( int id, String descripcion, Resultado r,String componentesInspeccionados) {
        super(id, descripcion, r);
        this.componentesInspeccionados = componentesInspeccionados;
    }

    public String getComponentesInspeccionados() {
        return componentesInspeccionados;
    }

    public void setComponentesInspeccionados(String componentesInspeccionados) {
        this.componentesInspeccionados = componentesInspeccionados;
    }

    @Override
    public String toString() {
        return "Observacion{" +
                super.toString() +
                "componentesInspeccionados='" + componentesInspeccionados + '\'' +
                '}';
    }
}
