package ModelsInspeccion;

import ModelsEnums.Resultado;
import ModelsEnums.TipoMedicion;
import org.json.JSONException;
import org.json.JSONObject;

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
        return "\nMedicion de tipo: "+ tipoMedicion
                + super.toString();
    }

    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = super.toJson();
            jsonObject.put("tipoMedicon", tipoMedicion);
        }catch (JSONException ex){
            System.out.println(ex.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return jsonObject;
    }

    public void fromJson(JSONObject jsonObject) {
        try {
            super.fromJson(jsonObject);
            String m = jsonObject.getString("tipoMedicon");
            tipoMedicion = TipoMedicion.valueOf(m.toUpperCase());
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
