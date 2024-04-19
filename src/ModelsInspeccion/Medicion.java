package ModelsInspeccion;

import ModelsEnums.Resultado;
import ModelsEnums.TipoMedicion;

public class Medicion extends Control{

    private TipoMedicion tipoMedicion;

    public Medicion(){
        super();
        this.tipoMedicion = null;
    }

    public Medicion(int id, String descripcion, Resultado r, TipoMedicion tipoM){
        super(id, descripcion, r);
        this.tipoMedicion = tipoM;
    }

    public TipoMedicion getTipoMedicion() {
        return tipoMedicion;
    }

    public void setTipoMedicion(TipoMedicion tipoMedicion) {
        this.tipoMedicion = tipoMedicion;
    }

    @Override
    public String toString() {
        return "Medicion{" +
                super.toString() +
                "tipoMedicion=" + tipoMedicion +
                '}';
    }
}
