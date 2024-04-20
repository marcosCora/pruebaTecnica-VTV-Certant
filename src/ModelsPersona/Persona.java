package ModelsPersona;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public abstract class Persona {

    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String telefono;

    public Persona() {
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.dni = "";
        this.direccion = "";
        this.telefono = "";
    }

    public Persona(int id, String nombre, String apellido, String dni, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj != null){
            if(obj instanceof Persona) {
                Persona aux = (Persona) obj;
                if (id == aux.id && obj.equals(dni)) {
                    rta = true;
                }
            }
        }
        return rta;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nNombre: "  + nombre +
                "\nApellido: " + apellido +
                "\nDNI: " + dni +
                "\nDireccion: " + direccion +
                "\nTelefono: " + telefono;
    }

    public JSONObject toJson() throws JSONException{
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", id);
        jsonObject.put("nombre", nombre);
        jsonObject.put("apellido", apellido);
        jsonObject.put("dni", dni);
        jsonObject.put("direccion", direccion);
        jsonObject.put("telefono", telefono);

        return jsonObject;
    }

    public void fromJson(JSONObject jsonObject) throws JSONException {
        id = jsonObject.getInt("id");
        nombre = jsonObject.getString("nombre");
        apellido = jsonObject.getString("apellido");
        dni = jsonObject.getString("dni");
        direccion = jsonObject.getString("direccion");
        telefono = jsonObject.getString("telefono");
    }
}
