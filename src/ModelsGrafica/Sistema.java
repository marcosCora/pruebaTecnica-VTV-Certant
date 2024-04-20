package ModelsGrafica;

import ModelsEnums.Resultado;
import ModelsEnums.TipoDueno;
import ModelsEnums.TipoMedicion;
import ModelsGestoras.GestoraFacturas;
import ModelsGestoras.GestoraInspecciones;
import ModelsGestoras.GestoraUsuarios;
import ModelsGestoras.GestoraVehiculos;
import ModelsInspeccion.Inspeccion;
import ModelsInspeccion.Medicion;
import ModelsInspeccion.Observacion;
import ModelsPersona.Inspector;
import ModelsPersona.Persona;
import ModelsPersona.PropietarioVehiculo;
import ModelsVehiculo.Vehiculo;

import java.util.Scanner;

public class Sistema {

    //atributos de gestora
    private GestoraInspecciones gestoraInspecciones;
    private GestoraUsuarios gestoraUsuarios;
    private GestoraVehiculos gestoraVehiculos;
    private GestoraFacturas gestoraFacturas;
    private Scanner teclado;
    private Menu menu;
    private int opcion;

    public Sistema(){
        gestoraInspecciones = new GestoraInspecciones();
        gestoraUsuarios = new GestoraUsuarios();
        gestoraVehiculos = new GestoraVehiculos();
        gestoraFacturas = new GestoraFacturas();
        this.teclado = new Scanner(System.in);
        this.opcion = -1;
    }

    public void cargaSistema(){
        gestoraInspecciones.leerArchivo("inspecciones");
        gestoraVehiculos.leerArchivo("vehiculos");
        gestoraUsuarios.leerArchivoPropietarios("pripietarios");
        gestoraUsuarios.leerArchivoInspectores("inspectores");
    }

    public void guardaSistema(){
        gestoraInspecciones.guardarArchivo("inspecciones");
        gestoraVehiculos.guardarArchivo("vehiculos");
        gestoraUsuarios.guardarArchivoPropietarios("pripietarios");
        gestoraUsuarios.guardarArchivoInspectores("inspectores");
    }



    public void cicloPrograma(){


        do {
            menu.menuPrincipal();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    cicloVehiculos();
                    break;

                case 2:
                    cicloInspecciones();
                    break;

                case 3:
                    cicloInspectores();
                    break;
                case 4:
                    cicloPropietarios();
                    break;
                case 5:
                    cargaSistema();
                    break;
                case 9:
                    guardaSistema();
                    break;
            }
        }while (opcion != 0);
    }

    public void cicloVehiculos(){
        do {
            menu.menuVehiculos();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Vehiculos:");
                    System.out.println(gestoraVehiculos.listar());
                    break;

                case 2:
                    agregarVehiculo();
                    break;

                case 3:

                    break;
                case 4:

                    break;
                case 9:
                    cicloPrograma();
                    break;
            }
        }while (opcion != 0);
    }

    public void cicloInspecciones(){
        do {
            menu.menuInspecciones();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(gestoraInspecciones.listar());
                    break;

                case 2:
                    crearNuevaInspeccion();
                    break;

                case 3:

                    break;
                case 9:
                    cicloPrograma();
                    break;
            }
        }while (opcion != 0);
    }
    public void cicloInspectores(){
        do {
            menu.menuInspectores();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Inspectores:\n");
                    System.out.println(gestoraUsuarios.listarInspectores());
                    break;

                case 2:
                    agregarInspector();
                    break;

                case 3:
                    //buscar por dni
                    break;
                case 9:
                    cicloPrograma();
                    break;
            }
        }while (opcion != 0);
    }
    public void cicloPropietarios(){
        do {
            menu.menuPropietarios();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Propietarios cargados:\n");
                    System.out.println(gestoraUsuarios.listarPropietarios());
                    break;

                case 2:
                    agregarPropietario();
                    break;

                case 3:
                    //buscar por dni
                    break;
                case 9:
                    cicloPrograma();
                    break;
            }
        }while (opcion != 0);
    }


    public void crearNuevaInspeccion(){
        Inspeccion newInspeccion = new Inspeccion();

        System.out.println("\nIngrese los datos de la nueva inspeccion");
        System.out.println("Nº Inspeccion: ");
        newInspeccion.setNroInspeccion(teclado.nextInt());

        teclado.nextLine();

        System.out.println("Ingresa DNI del inspector: ");
        Inspector inspector = gestoraUsuarios.buscaInspectorXDni(teclado.nextLine());
        if(inspector != null){
            newInspeccion.setdniInspector(inspector.getDni());
        }//debo llamar la opcion para crear nuevo inspector en caso de que no exista

        teclado.nextLine();

        System.out.println("Ingrese el dominio del vehiculo: ");
        Vehiculo vehiculo = gestoraVehiculos.buscaVehiculoXDominio(teclado.nextLine());
        if(vehiculo != null){
            newInspeccion.setDominioVehiculo(vehiculo.getDominio());
        }//generar nuevo vehiculo en caso de que lo necesite
        teclado.nextLine();
        newInspeccion.setObservacion(creaObservacion());
        teclado.nextLine();
        creaNuevasMediciones(newInspeccion);
        gestoraInspecciones.agregar(newInspeccion);
        teclado.nextLine();
    }

    public Observacion creaObservacion(){
        Observacion o = new Observacion();
        System.out.println("\nObservacion");
        System.out.println("Ingrese la descripcion:");
        o.setDescripcion(teclado.nextLine());

        System.out.println("Componentes Inspeccionados: ");
        o.setComponentesInspeccionados(teclado.nextLine());

        System.out.println("\nIngresa el resultado: ");
        o.setResultado(resultado());
        teclado.nextLine();

        return o;
    }

    public void creaNuevasMediciones(Inspeccion i){
        System.out.println("\nMedcion: \n");
        Medicion m = new Medicion();
        do {
            System.out.println("Ingrese la descripcion;");
            m.setDescripcion(teclado.nextLine());

            teclado.nextLine();

            System.out.println("\nIngresa el tipo de medicion: ");
            m.setTipoMedicion(tipoMedicion());

            teclado.nextLine();

            System.out.println("\nIngresa el resultado: ");
            m.setResultado(resultado());

            teclado.nextLine();

            i.agreagr(m);

            System.out.println("Ingrese 9 para no agregar mas mediciones - Otro para continuar");
            opcion = teclado.nextInt();
            teclado.nextLine();
        }while (opcion != 9);
    }

    public TipoMedicion tipoMedicion(){
        System.out.println("1-SUSPENSION, 2-DIRECCION, 3-TRENDELANTERO, 4-FRENOS, 5-CONTAMINACION");
        int opcion = teclado.nextInt();

        teclado.nextLine();
        TipoMedicion tipoM = null;
        switch (opcion)
        {
            case 1:
                tipoM = TipoMedicion.SUSPENSION;
                break;
            case 2:
                tipoM = TipoMedicion.DIRECCION;
                break;
            case 3:
                tipoM = TipoMedicion.TRENDELANTERO;
                break;
            case 4:
                tipoM = TipoMedicion.FRENOS;
                break;
            case 5:
                tipoM = TipoMedicion.CONTAMINACION;
                break;
        }
        return tipoM;
    }

    public Resultado resultado(){
        System.out.println("1-APTO, 2-CONDICIONAL, 3-RECHAZADO");
        int opcion = teclado.nextInt();
        teclado.nextLine();
        Resultado r = null;
        switch (opcion)
        {
            case 1:
                r = Resultado.APTO;
                break;
            case 2:
                r = Resultado.CONDICIONAL;
                break;
            case 3:
                r = Resultado.RECHAZADO;
                break;
        }
        return r;
    }

    public void agregarPropietario(){
        PropietarioVehiculo newPropietario = new PropietarioVehiculo();
        System.out.println("Ingrese Los Datos del Propietario: ");
        teclado.nextLine();
        System.out.println("Nombre:");
        newPropietario.setNombre(teclado.nextLine());

        System.out.println("Apellido:");
        newPropietario.setApellido(teclado.nextLine());

        System.out.println("Direccion:");
        newPropietario.setDireccion(teclado.nextLine());

        System.out.println("Telefono:");
        newPropietario.setTelefono(teclado.nextLine());

        System.out.println("DNI:");
        newPropietario.setDni(teclado.nextLine());

        if(gestoraUsuarios.buscarPropietarioDni(newPropietario.getDni()) == null){
            newPropietario.setTipoDueno(tipoDueno());
            gestoraUsuarios.agregar(newPropietario);
        }//crear excepcion si el dni existe
    }

    public TipoDueno tipoDueno(){
        System.out.println("1-EXENTO, 2-COMUN");
        int opcion = teclado.nextInt();
        teclado.nextLine();
        TipoDueno tDueno = null;
        switch (opcion) {
            case 1:
                tDueno = TipoDueno.EXENTO;
                break;
            case 2:
                tDueno = TipoDueno.COMUN;
                break;
        }
        return tDueno;
    }

    public void agregarInspector(){
        Inspector newInspector = new Inspector();
        System.out.println("Ingrese Los Datos del Propietario: ");
        teclado.nextLine();
        System.out.println("Nombre:");
        newInspector.setNombre(teclado.nextLine());

        System.out.println("Apellido:");
        newInspector.setApellido(teclado.nextLine());

        System.out.println("Direccion:");
        newInspector.setDireccion(teclado.nextLine());

        System.out.println("Telefono:");
        newInspector.setTelefono(teclado.nextLine());

        System.out.println("DNI:");
        newInspector.setDni(teclado.nextLine());

        if(gestoraUsuarios.buscaInspectorXDni(newInspector.getDni()) == null){
            System.out.println("Especialidad:");
            newInspector.setEspecialidad(teclado.nextLine());
            gestoraUsuarios.agregar(newInspector);

        }
    }

    public void agregarVehiculo(){
        teclado.nextLine();
        Vehiculo newVechiculo = new Vehiculo();
        System.out.println("Ingrese Un Nuevo Vechiulo:\n");
        System.out.println("DNI del dueño: ");
        PropietarioVehiculo p = gestoraUsuarios.buscarPropietarioDni(teclado.nextLine());
        if(p != null){
            newVechiculo.setDniPropietario(p.getDni());
            System.out.println("Dominio: ");
            String dominio = teclado.nextLine();
            if(gestoraVehiculos.buscaVehiculoXDominio(dominio) == null){
                newVechiculo.setDominio(dominio);
                System.out.println("Marca:");
                newVechiculo.setMarca(teclado.nextLine());
                System.out.println("Modelo:");
                newVechiculo.setModelo(teclado.nextLine());
                gestoraVehiculos.agregar(newVechiculo);
                gestoraUsuarios.agregarVehiculoP(newVechiculo, p.getDni());
            }
        }else{
            System.out.println("Primero debe ingresar los datos del propietario");
        }


    }

}
