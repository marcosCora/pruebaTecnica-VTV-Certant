package ModelsInspeccion;

import ModelsEnums.Resultado;
import org.json.JSONException;
import org.json.JSONObject;

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

    public JSONObject toJson(){
        JSONObject jsonObject = super.toJson();
        try {
            jsonObject.put("componentesInspeccionados", componentesInspeccionados);
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
            componentesInspeccionados = jsonObject.getString("componentesInspeccionados");
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
