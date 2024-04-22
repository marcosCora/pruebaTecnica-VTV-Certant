package ModelsGrafica;

import ModelsEnums.Resultado;
import ModelsEnums.TipoDueno;
import ModelsEnums.TipoMedicion;
import ModelsExcepcion.MiExcepcionInspeccion;
import ModelsExcepcion.MiExcepcionUsuario;
import ModelsExcepcion.MiExcepcionVehiculo;
import ModelsGestoras.GestoraInspecciones;
import ModelsGestoras.GestoraUsuarios;
import ModelsGestoras.GestoraVehiculos;
import ModelsInspeccion.Inspeccion;
import ModelsInspeccion.Medicion;
import ModelsInspeccion.Observacion;
import ModelsPersona.Inspector;
import ModelsPersona.PropietarioVehiculo;
import ModelsVehiculo.Vehiculo;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema {

    //atributos de gestora
    private GestoraInspecciones gestoraInspecciones;
    private GestoraUsuarios gestoraUsuarios;
    private GestoraVehiculos gestoraVehiculos;
    private Scanner teclado;
    private Menu menu;
    private int opcion;

    public Sistema(){
        gestoraInspecciones = new GestoraInspecciones();
        gestoraUsuarios = new GestoraUsuarios();
        gestoraVehiculos = new GestoraVehiculos();
        this.teclado = new Scanner(System.in);
        this.opcion = -1;
        cargaSistema();
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

                    try {
                        teclado.nextLine();
                        System.out.println("Ingrese el dominio del vehiculo a eliminar: ");
                        String dominio = teclado.nextLine();
                        gestoraVehiculos.eliminarVehiculo(dominio);
                        System.out.println("Vehiculo Eliminado con exito");
                    }catch (MiExcepcionVehiculo e) {
                        System.out.println("Error " + e.getMessage());
                    }
                    catch (Exception e){
                        System.out.println("Error" + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        teclado.nextLine();
                        System.out.println("Ingresa el dominio de tu vehiculo: ");
                        String dominio = teclado.nextLine();
                        String fecha = gestoraVehiculos.returnFechaVencimcientoVtv(dominio);
                        System.out.println("Fecha de vencimiento: " + fecha);
                    }catch (MiExcepcionVehiculo e){
                        System.out.println("Error: " + e.getMessage());
                    }catch (Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    modificarVehiculo();
                    break;
                case 6:
                        teclado.nextLine();
                        System.out.println("Ingresa el dominio de tu vehiculo: ");
                        String dominio = teclado.nextLine();
                        Vehiculo v = gestoraVehiculos.buscaVehiculoXDominio(dominio);
                        if (v != null){
                            System.out.println(v);
                        }else {
                            System.out.println("No existe vehiculo con ese dominio.");
                        }
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
                    try {
                        teclado.nextLine();
                        System.out.println("Ingrese Nº de inspeccion: ");
                        int nInspeccion = teclado.nextInt();
                        gestoraInspecciones.eliminar(nInspeccion);
                        System.out.println("Inspeccion Eliminada");
                    } catch (InputMismatchException e) {
                        System.out.println("Error " + e.getMessage());
                    }catch (MiExcepcionInspeccion e) {
                        System.out.println("Error " + e.getMessage());
                    }
                    catch (Exception e){
                        System.out.println("Error" + e.getMessage());
                    }
                    break;
                case 4:
                    listarAutosInspeccionados();
                    break;
                case 5:
                    listarAutosXResultadoDeInspeccion();
                    break;
                case 6:
                    try{
                        teclado.nextLine();
                        System.out.println("Ingrese el Nº de inspeccion: ");
                        Inspeccion i = gestoraInspecciones.buscaInspeccionPorNro(teclado.nextInt());
                        teclado.nextLine();
                        if(i != null){
                            modificarInspeccion(i);
                        }else {
                            throw new MiExcepcionInspeccion("La inspeccion ingresada no es valida");
                        }
                    }catch (MiExcepcionInspeccion e){
                        System.out.println("Error " + e.getMessage());
                    }catch (Exception e){
                        System.out.println("Error " + e.getMessage());
                    }

                    break;
                case 7:
                    try{
                        teclado.nextLine();
                        System.out.println("Ingrese el Nº de inspeccion: ");
                        Inspeccion i = gestoraInspecciones.buscaInspeccionPorNro(teclado.nextInt());
                        teclado.nextLine();
                        if(i != null){
                            System.out.println(i.toString());
                        }else {
                            throw new MiExcepcionInspeccion("La inspeccion ingresada no es valida");
                        }
                    }catch (MiExcepcionInspeccion e){
                        System.out.println("Error " + e.getMessage());
                    }catch (Exception e){
                        System.out.println("Error " + e.getMessage());
                    }

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
                    try {
                        teclado.nextLine();
                        System.out.println("Ingrese el DNI: ");
                        String dni = teclado.nextLine();
                        gestoraUsuarios.eliminarInspector(dni);
                        System.out.println("Inspector Eliminado con exito");
                    }catch (MiExcepcionUsuario e) {
                        System.out.println("Error " + e.getMessage());
                    }
                    catch (Exception e){
                        System.out.println("Error" + e.getMessage());
                    }
                    break;
                case 4:
                    teclado.nextLine();
                    System.out.println("Ingrese el DNI: ");
                    String dni = teclado.nextLine();
                    Inspector i = gestoraUsuarios.buscaInspectorXDni(dni);
                    if(i != null){
                        System.out.println(i.toString());
                    }else{
                        System.out.println("El inspector no existe");
                    }
                    break;
                case 5:
                    //modificar
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
                    System.out.println("\nPropietarios cargados:\n\n");
                    System.out.println(gestoraUsuarios.listarPropietarios());
                    break;

                case 2:
                    agregarPropietario();
                    break;

                case 3:
                    try {
                        teclado.nextLine();
                        System.out.println("Ingrese el DNI: ");
                        String dni = teclado.nextLine();
                        gestoraUsuarios.eliminarPropietario(dni);
                        System.out.println("Propietario Eliminado con exito");
                    }catch (MiExcepcionUsuario e) {
                        System.out.println("Error " + e.getMessage());
                    }
                    catch (Exception e){
                        System.out.println("Error" + e.getMessage());
                    }
                    break;
                case 4:
                    teclado.nextLine();
                    System.out.println("Ingrese el DNI: ");
                    String dni = teclado.nextLine();
                    PropietarioVehiculo p = gestoraUsuarios.buscarPropietarioDni(dni);
                    if(p != null){
                        System.out.println(p.toString());
                    }else{
                        System.out.println("El Propietario no existe");
                    }
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

        teclado.nextLine();

        System.out.println("Ingresa DNI del inspector: ");
        Inspector inspector = gestoraUsuarios.buscaInspectorXDni(teclado.nextLine());
        if(inspector != null){
            newInspeccion.setdniInspector(inspector.getDni());
            teclado.nextLine();

            System.out.println("Ingrese el dominio del vehiculo: ");
            Vehiculo vehiculo = gestoraVehiculos.buscaVehiculoXDominio(teclado.nextLine());
            if(vehiculo != null){
                newInspeccion.setDominioVehiculo(vehiculo.getDominio());
                teclado.nextLine();
                newInspeccion.setObservacion(creaObservacion());
                teclado.nextLine();
                creaNuevasMediciones(newInspeccion);

                buscaTipoDueno(newInspeccion, vehiculo);

                gestoraUsuarios.agregarInspecciones(newInspeccion, inspector.getDni());
                gestoraInspecciones.agregar(newInspeccion);
                teclado.nextLine();
                if(newInspeccion.resultadoInspeccion() == Resultado.APTO){
                    vehiculo.setFechaVencimientoVtv(vehiculo.fechaFormateada());
                }
            }//generar nuevo vehiculo en caso de que lo necesite

        }//debo llamar la opcion para crear nuevo inspector en caso de que no exista
    }

    public Observacion creaObservacion(){
        Observacion o = new Observacion();
        System.out.println("Observacion");
        System.out.println("Ingrese la descripcion:");
        o.setDescripcion(teclado.nextLine());

        System.out.println("Componentes Inspeccionados: ");
        o.setComponentesInspeccionados(teclado.nextLine());

        System.out.println("Ingresa el resultado: ");
        o.setResultado(resultado());
        teclado.nextLine();

        return o;
    }

    public void creaNuevasMediciones(Inspeccion i){
        System.out.println("\nMedcion:");
        do {
            try{
                Medicion m = new Medicion();
                System.out.println("Ingresa el tipo de medicion: ");
                m.setTipoMedicion(tipoMedicion());

                teclado.nextLine();

                System.out.println("Ingrese la descripcion;");
                m.setDescripcion(teclado.nextLine());

                teclado.nextLine();

                System.out.println("Ingresa el resultado: ");
                m.setResultado(resultado());

                teclado.nextLine();

                i.agreagr(m);

                System.out.println("Ingrese 9 para no agregar mas mediciones - Otro para continuar");
                opcion = teclado.nextInt(); //crear excepcion
                teclado.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Error: debe ingresar un numero para continuar o seguir");
                opcion = -1;
                teclado.nextLine();
            }


        }while (opcion != 9);
    }

    public TipoMedicion tipoMedicion(){

        TipoMedicion tipoM = null;
        do{
            System.out.println("1-SUSPENSION, 2-DIRECCION, 3-TRENDELANTERO, 4-FRENOS, 5-CONTAMINACION");
            int opcion = teclado.nextInt();
            teclado.nextLine();
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
        }while (tipoM == null);
        return tipoM;
    }

    public Resultado resultado(){
        Resultado r = null;
        do{
            System.out.println("\n1-APTO, 2-CONDICIONAL, 3-RECHAZADO");
            int opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
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
        }while (r == null);

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
            try{
                System.out.println("Dominio: ");
                String dominio = teclado.nextLine();

                newVechiculo.setDominio(dominio);
                System.out.println("Marca:");
                newVechiculo.setMarca(teclado.nextLine());
                System.out.println("Modelo:");
                newVechiculo.setModelo(teclado.nextLine());
                gestoraVehiculos.agregar(newVechiculo);
                gestoraUsuarios.agregarVehiculoP(newVechiculo, p.getDni());
            }catch (MiExcepcionVehiculo e){
                System.out.println("Error: " + e.getMessage());
            }
            catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }else{
            System.out.println("Primero debe ingresar los datos del propietario");
        }


    }

    public void buscaTipoDueno(Inspeccion i, Vehiculo v){
        PropietarioVehiculo p = gestoraUsuarios.buscarPropietarioDni(v.getPropietario());
        if(p != null){
            if(p.getTipoDueno() == TipoDueno.EXENTO){
                i.setExento(true);
            }
        }
    }

    public void modificarVehiculo(){
        teclado.nextLine();
        try {
            System.out.println("Ingrese el dominio: ");
            String dominio = teclado.nextLine();
            Vehiculo vehiculoAModificar = gestoraVehiculos.buscaVehiculoXDominio(dominio);
            if(vehiculoAModificar != null){
                System.out.println("Marca:");
                vehiculoAModificar.setMarca(teclado.nextLine());
                System.out.println("Modelo:");
                vehiculoAModificar.setModelo(teclado.nextLine());
            }else{
                throw new MiExcepcionVehiculo("El Vehiculo no existe");
            }
        }catch (MiExcepcionVehiculo e){
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listarAutosInspeccionados(){

        int i = 0;
        while (gestoraInspecciones.retornaDominioV(i) != null){
            Vehiculo vInspeccionado = gestoraVehiculos.buscaVehiculoXDominio(gestoraInspecciones.retornaDominioV(i));
            System.out.println(vInspeccionado.toString());
            i++;
        }
    }

    public void listarAutosXResultadoDeInspeccion(){
        System.out.println("Ingrese el tipo de resultado que desea utilizar como filtro:");
        Resultado r = resultado();
        ArrayList<String> dominios = gestoraInspecciones.devuelveAutosInspeccionadosXResultado(r);

        System.out.println("Estos son los vehiculos con el resulatdo de inspeccion: " + r);
        for (String dominio : dominios){
            Vehiculo v = gestoraVehiculos.buscaVehiculoXDominio(dominio);
            System.out.println(v.toString());
        }
    }

    public void modificarInspeccion(Inspeccion i){

        do {
            menu.menuModificacionInspeccion();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    teclado.nextLine();
                    System.out.println("Ingrese la observacion: ");
                    i.setObservacion(creaObservacion());
                    break;
                case 2:
                    teclado.nextLine();
                    i.setMediciones(new ArrayList<Medicion>());
                    System.out.println("Ingrese las nuevas mediciones: ");
                    creaNuevasMediciones(i);
                    break;
                case 9:
                    cicloPrograma();
                    break;
            }
        }while (opcion != 0);

    }

    public void eliminarUsuario(){

    }


}
