package interfaces;
import modelo.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class StandManager {
  public static Feria fer;

  public static void menuStand() {
    Scanner sc = new Scanner(System.in);
    int op = 0;
    System.out.println("");
    System.out.println("-----------Administración de stands-------");
    System.out.println("");
    System.out.println("Ingrese código de la feria para administrar stands: ");

    try {
      op = sc.nextInt();
      sc.nextLine();
    } catch (InputMismatchException e) {
      System.out.println("Por favor, ingrese un valor entero válido.");
      sc.nextLine();
      menuStand();
    }

    do {
      if (MenuFeria.buscarFeriaPorCodigo(op) != null) {
        fer = MenuFeria.buscarFeriaPorCodigo(op);
        System.out.println("Feria encontrada: " + fer.getNombre());
        System.out.println("");

        for (Stand stand : fer.seccion1) {
          System.out.print(stand);
        }
         System.out.println("");
        for (Stand stand : fer.seccion2) {
          System.out.print(stand);
        }
         System.out.println("");
        for (Stand stand : fer.seccion3) {
          System.out.print(stand);
        }
         System.out.println("");
        for (Stand stand : fer.seccion4) {
          System.out.print(stand);
        }
        System.out.println("");
      } else {
        System.out.println("Feria no encontrada");
        menuStand();
      }
    } while (MenuFeria.buscarFeriaPorCodigo(op) == null);
    System.out.println("");
    System.out.println("1. Reservar Stand \n2. Consultar stand\n3. Regresar");
    System.out.println("(por favor, solo enteros)Ingrese una opción: ");

    do {
      try {
        op = sc.nextInt();
        sc.nextLine();
      } catch (InputMismatchException e) {
        System.out.println("Por favor, ingrese un valor entero válido.");
        sc.nextLine();
        continue;
      }

      switch (op) {
        case 1:
          reservar_Stand();
          break;
        case 2:
          informacionDelStand();
          break;
      }
    } while (op != 3);
    MenuP.menuP();
    
  }

  public static void reservar_Stand() {
    int op = 0;
    Stand stand = null;
    Scanner sc = new Scanner(System.in);
    System.out.println("");
    System.out.println("Por favor, ingrese el código del stand que desea reservar: ");
    String cod = "";
    try {
      cod = sc.nextLine();
    } catch (InputMismatchException e) {
      System.out.println("Por favor, ingrese un valor válido.");
      sc.nextLine();
      menuStand(); // si no es un resultado esperado, se vuelve a llamar la función
    }

    if (buscarStandPorCodigo(cod) != null) {
      stand = buscarStandPorCodigo(cod);
      System.out.println("");
      System.out.println("Stand encontrado");
      System.out.println(stand.getCodigo());
      System.out.println("");
      String standCod = stand.getCodigo();
      int len = standCod.length();

      if (len > 2) {
        System.out.println("Stand no disponible");
        System.out.println("");
        menuStand();
      } else {
        op = 0;
        System.out.println("Stand disponible");
        System.out.println("");
        System.out.println("¿Quién reserva? \n1. Emprendedor \n2. Auspiciante ");
        try {
          op = sc.nextInt();
          sc.nextLine();
        } catch (InputMismatchException e) {
          System.out.println("Por favor, ingrese un valor válido. Regresando al menú de stands");
          sc.nextLine();
          menuStand(); // si no es un resultado esperado, se vuelve a llamar la función
        }

        switch (op) {
          case 1:
            Emprendedor emp = null;
            System.out.println("Ingrese cedula del emprendedor: ");
            String codEmp = "";
            try {
              codEmp = sc.nextLine();
            } catch (InputMismatchException e) {
              System.out.println("Por favor, ingrese un valor válido. Volviendo al menú de stands");
              sc.nextLine();
              menuStand(); 
            }

            emp = MenuEmprendedor.buscarEmprendedorPorID(codEmp);

            if (emp != null) {
              int m = 0;
              System.out.println("Emprendedor Encontrado");
              ArrayList<Emprendedor> emps = fer.getEmprendedores();

              if(emps.size() != 0){
               for (Emprendedor emP : emps) {
                if (emp.equals(emP)) {
                  System.out.println("");
                  System.out.println("Emprendedor con stand asignado, volviendo a administrador de stands");
                  menuStand();

                  System.out.println("");
                }

                  m++;
                  stand.setCodigo(cod + "*");
                  System.out.println("");
                  System.out.println("Stand correctamente asignado a Emprendedor");
                  System.out.println("");
            
               }
              }
              else{
                stand.setCodigo(cod + "*");
                System.out.println("");
                System.out.println("Stand correctamente asignado a Emprendedor");
                System.out.println("");
                emps.add(emp);
                stand.setEmprendedor(emp);
                System.out.println("");

              }
              if(m == 1){
                emps.add(emp);
                stand.setEmprendedor(emp);
              }
            }
            MenuP.menuP();
            break;
          case 2:
            Auspiciante aus = null;
            System.out.println("Ingrese código del auspiciante: ");
            String codAus = "";
            try {
              codAus = sc.nextLine();
            } catch (InputMismatchException e) {
              System.out.println("Por favor, ingrese un valor válido. Volviendo al menú de stands");
              sc.nextLine();
              menuStand(); 
            }

            aus = AuspicianteManager.buscarAuspiciantePorID(codAus);

            if (aus != null) {
              int j = 0;
              System.out.println("Auspiciante Encontrado");
              for (Auspiciante Aus : fer.getAuspiciantes_en_feria()) {
                if (aus == Aus) {
                  System.out.println("");
                  System.out.println("Auspiciante con stand asignado, volviendo a administrador de stands");
                  menuStand();

                  System.out.println("");
                } else {
                  
                  j++;
                  stand.setCodigo(cod + "*");
                  System.out.println("");
                  System.out.println("Stand correctamente asignado a Auspiciante");
                  System.out.println("");
                }
              }
              if(j == 1){
                fer.getAuspiciantes_en_feria().add(aus);
                stand.setAuspiciante(aus);
              }
            }
            MenuP.menuP();
            break;

            
        }
      }
    } else {
      System.out.println("Stand no encontrado");
      System.out.println("---Regresando al menú de administración de stands---");
      menuStand();
    }
  }

  public static void informacionDelStand(){
    int op = 0;
    Stand stand = null;
    Scanner sc = new Scanner(System.in);
    System.out.println("");
    System.out.println("Por favor, ingrese el código del stand que desea consultar: ");
    String cod = "";
    try {
      cod = sc.nextLine();
    } catch (InputMismatchException e) {
      System.out.println("Por favor, ingrese un valor válido.");
      sc.nextLine();
      menuStand(); // si no es un resultado esperado, se vuelve a llamar la función
    }

    if (buscarStandPorCodigo(cod) != null) {
      stand = buscarStandPorCodigo(cod);
      System.out.println("");
      System.out.println("Stand encontrado");
      System.out.println(stand.info());
      System.out.println("");
      MenuP.menuP();
    
  }
    else{
      System.out.println("Stand no encontrado");
      System.out.println("---Regresando al menú de administración de stands---");
      menuStand();
    }
  }


  

  public static Stand buscarStandPorCodigo(String codigo) {
    char first = codigo.charAt(0);
    Stand standF = null;

    if (first == 'A') {
      for (Stand stand : fer.seccion1) {
        if (stand.getCodigo().substring(0, 2).equals(codigo.substring(0, 2))) {
          standF = stand;
        } 
      }
    }

    else if (first == 'B') {
      for (Stand stand : fer.seccion2) {
        if (stand.getCodigo().substring(0, 2).equals(codigo.substring(0, 2))) {
          standF = stand;
        } 
    }
    }
    else if (first == 'C') {
      for (Stand stand : fer.seccion3) {
        if (stand.getCodigo().substring(0, 2).equals(codigo.substring(0, 2))) {
          standF = stand;
        } 
      }
    }

    else if (first == 'D') {
      for (Stand stand : fer.seccion4) {
        if (stand.getCodigo().substring(0, 2).equals(codigo.substring(0, 2))) {
          standF = stand;
        }
      }
    }
        else {
          return null;
        }

    return standF;
  }
}
