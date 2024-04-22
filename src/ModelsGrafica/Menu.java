package ModelsGrafica;

public class Menu {

    public static void menuPrincipal(){
        System.out.println("\nMENU -- Ingrese el numero de la opcion que desee");
        System.out.println("1- Vehiculos");
        System.out.println("2- Inspecciones");
        System.out.println("3- Inspectores");
        System.out.println("4- Propietarios");
        System.out.println("0- Salir");
    }

    public static void menuVehiculos(){
        System.out.println("\nMENU -- Ingrese el numero de la opcion que desee");
        System.out.println("1- Listar vehiculos");
        System.out.println("2- Añadir vehiculo");
        System.out.println("3- Borrar vehiculo");
        System.out.println("4- Fecha de vencimiento de VTV");
        System.out.println("5- Modificar vehiculo");
        System.out.println("6- Muestra vehiculo por dominio");
        System.out.println("9- Atras");
        System.out.println("0- Salir y guardar");
    }

    public static void menuInspecciones(){
        System.out.println("\nMENU -- Ingrese el numero de la opcion que desee");
        System.out.println("1- Listar Inspecciones");
        System.out.println("2- Crear nueva inspeccion");
        System.out.println("3- Borrar inspeccion");
        System.out.println("4- Listar autos inspeccionados");
        System.out.println("5- Listar autos por resultado");
        System.out.println("6- Modificar inspeccion");
        System.out.println("7- Buscar inspeccion por numero");
        System.out.println("9- Atras");
        System.out.println("0- Salir y guardar");
    }

    public static void menuInspectores(){
        System.out.println("\nMENU -- Ingrese el numero de la opcion que desee");
        System.out.println("1- Listar inspectores");
        System.out.println("2- Añadir inspector");
        System.out.println("3- Borrar inspector por DNI");
        System.out.println("4- Buscar inspector por DNI");
        System.out.println("5- Modificar Inspecor");
        System.out.println("9- Atras");
        System.out.println("0- Salir y guardar");
    }

    public static void menuPropietarios(){
        System.out.println("\nMENU -- Ingrese el numero de la opcion que desee");
        System.out.println("1- Listar propietarios");
        System.out.println("2- Añadir Propietario");
        System.out.println("3- Eliminar propietario por DNI");
        System.out.println("4- Buscar propietario por DNI");
        System.out.println("5- Modificar");
        System.out.println("9- Atras");
        System.out.println("0- Salir y guardar");
    }

    public static void menuModificacionInspeccion(){
        System.out.println("Que desea modificar: ");
        System.out.println("1- Observacion");
        System.out.println("2- Mediciones");
        System.out.println("9- Atras");
        System.out.println("0- Salir y guardar");
    }

    public static void menuModificacionUsuario(){
        System.out.println("Que desea modificar: ");
        System.out.println("1- Modificar nombre");
        System.out.println("2- Modificar apellido");
        System.out.println("3- Modificar direccion");
        System.out.println("4- Modificar telefono");
    }

    public static void menuModificacionInspector(){
        menuModificacionUsuario();
        System.out.println("5- Modificar especialidad");
        System.out.println("9- Atras");
        System.out.println("0- Salir y guardar");
    }




}
