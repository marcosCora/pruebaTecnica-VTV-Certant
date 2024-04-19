package ModelsGrafica;

import java.util.Scanner;

public class Sistema {

    //atributos de gestora

    private Scanner teclado;
    private Menu menu;
    private int opcion;

    public Sistema(){
        this.teclado = new Scanner(System.in);
        this.opcion = -1;
    }

    public void cicloPrograma(){
        //inicio el sistem
        do {
            menu.MenuPrincipal();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;
            }
        }while (opcion != 0);
    }






}
