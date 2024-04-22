package ModelsExcepcion;

import Interfaces.IFormatFecha;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MiExcepcionVehiculo extends Exception implements IFormatFecha {
    private String fechaError;

    public MiExcepcionVehiculo(String mensaje)
    {
        super(mensaje);
        fechaError = fechaFormateada();
    }

    @Override
    public String fechaFormateada()
    {
        LocalDateTime fechaLocal = LocalDateTime.now();
        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return fechaLocal.format(fechaFormateada);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
