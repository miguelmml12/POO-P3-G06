package interfaces;

import java.io.*;
import modelo.*;
import java.util.Scanner;
import java.util.InputMismatchException;


public class MenuP {

    // Copiando de otros menus del proyecto ojo
    public static void menuP() {

        // voy a copiar de un código que hice de prueba de menú, aviso XD
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {

                System.out.println();
                System.out.println("-----------Menu--------"); // imprimo una vez un separador
                System.out.println();

                System.out.println("1. Administración de Ferias \n2. Administración de emprendedores \n3. Administración de auspiciantes \n4. Administración de stands  \n5. Salir");
                System.out.println();
                System.out.println("(por favor solo enteros)Ingrese una opcion: ");// menu de opciones

                try {
                  opcion = sc.nextInt();
                  sc.nextLine();// seguro del scanner no registre el \n                
                } catch (InputMismatchException e) {
              System.out.println("Por favor, ingrese un valor entero válido.");
              sc.nextLine();
              continue;
          }
                switch (opcion) {
                    case 1:
                        MenuFeria.administracionDeFerias();
                        break;
                    case 2:
                        MenuEmprendedor.mostrar_MenuE();
                        break;
                    case 3:
                        AuspicianteManager.administracionDeAuspicantes();
                        break;
                    case 4:
                        StandManager.menuStand();
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }

        } while (opcion != 5); // do while para que ejecute sin opción
    }
}
