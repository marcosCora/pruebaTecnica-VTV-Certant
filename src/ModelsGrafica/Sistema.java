package ModelsGrafica;

import ModelsGestoras.GestoraFacturas;
import ModelsGestoras.GestoraInspecciones;
import ModelsGestoras.GestoraUsuarios;
import ModelsGestoras.GestoraVehiculos;

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

    public void cicloPrograma(){
        //inicio el sistem
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

    public void cicloVehiculos(){}

    /*
    System.out.println("MENU -- Ingrese el numero de la opcion que desee");
    System.out.println("1- Listar Inspecciones");
    System.out.println("2- Crear nueva inspeccion");
    System.out.println("3- Borrar inspeccion");
    System.out.println("4- Listar autos inspeccionados");
    */
    public void cicloInspecciones(){
        do {
            menu.menuInspectores();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(gestoraInspecciones.listar());
                    break;

                case 2:

                    break;

                case 3:

                    break;
                case 9:
                    cicloPrograma();
                    break;
            }
        }while (opcion != 0);
    }
    public void cicloInspectores(){}
    public void cicloPropietarios(){}






}
