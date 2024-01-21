package interfaces;
import modelo.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class AuspicianteManager {
    public static ArrayList<Auspiciante> auspiciantes = new ArrayList<Auspiciante>();

    public static int contador = 1;
    public static int t = 0;
    public static String[] nombres_redesS = new String[]{"Twitter", "Facebook", "Instagram", "Youtube", "Tik tok", "Linkedin", "Pinterest"};

    public static void agregarAspicianteInicial() {
      if(t==0){
          t++;
          Feria fer = MenuFeria.ferias.get(0);
      Stand stand1 = fer.getSeccion1().get(1);

        ArrayList<String> redesJibajaCorp = new ArrayList<String>();

        for (String red : nombres_redesS) {
            String redSocial = "@jibajaCorp";
            redesJibajaCorp.add(redSocial);
        }
        Auspiciante aus1 = new Auspiciante("1711111111", "Jibaja Corp", "Josue Jibaja", "0999999990", "ejeyd@example.com", "calle 1", "www.jibajaCorp.com", redesJibajaCorp, Sector.EDUCACION);
        aus1.stand_en_feria = true;
        auspiciantes.add(aus1);
      stand1.setAuspiciante(aus1);
      stand1.setCodigo("A2*");

      Feria fer1 = MenuFeria.ferias.get(0);
        auspiciantes.get(0).setStand_en_feria(true);
      auspiciantes.get(0).setDescripcion("auspicio de refrescos");
      fer1.getAuspiciantes_en_feria().add(auspiciantes.get(0));

      }
      
    }

    public static void administracionDeAuspicantes() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-----------Administración de Auspicantes-------");
            System.out.println();
            if (auspiciantes.size() == 0) {
                System.out.println("No hay auspiciantes registrados");
            } else {
                for (Auspiciante auspiciante : auspiciantes) {
                    System.out.println(auspiciante);
                }
            }
            System.out.println();

            System.out.println("1. Registrar auspiciante \n2. Editar auspiciante \n3. Asignar auspiciante a feria \n4. Regresar");
            System.out.println("(porfavor solo enteros)Ingrese una opcion: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un valor entero válido.");
                sc.nextLine();
                continue;
            }
            switch (opcion) {
                case 1:
                    registrarAuspiciante();
                    break;
                case 2:
                    editarAuspiciante();
                    break;
                case 3:
                    asignar_auspiciante_feria();
                    break;
            }
        } while (opcion != 4);
    }

    public static void registrarAuspiciante() {
        System.out.println("---------Registro de auspiciante ----------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Porfavor ingrese la cedula o ruc: ");
        String cedula = sc.nextLine();
        System.out.println("Porfavor ingrese el nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Porfavor ingrese el nombre de la persona que es responsable: ");
        String nombrePersona = sc.nextLine();

        System.out.println("Porfavor ingrese el telefono: ");
        String telefono = sc.nextLine();

        System.out.println("Porfavor ingrese el email: ");
        String email = sc.nextLine();

        System.out.println("Porfavor ingrese la direccion: ");
        String direccion = sc.nextLine();

        System.out.println("Porfavor ingrese el sitio web: ");
        String sitioWeb = sc.nextLine();

        System.out.println("Porfavor ingrese la lista de redes sociales");
        ArrayList<String> redesS = new ArrayList<String>();
        for (String red : nombres_redesS) {
            System.out.println("(si no tiene deje en blanco)usuario de " + red + ": ");
            try {
                String redSocial = sc.nextLine();
                if (!redSocial.isEmpty()) {
                    redesS.add(redSocial);
                }
            } catch (NoSuchElementException e) {
                System.out.println("Entrada no válida.");
                continue;
            }
        }

        System.out.println(redesS);
        System.out.println();

        System.out.println("(int)Porfavor eliga el sector\n1.ALIMENTACIÓN\n2.EDUCACIÓN\n3.SALUD\n4.VESTIMENTA ");
        int opcion = 0;
        try {
            opcion = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un valor entero válido.");
            sc.nextLine();
        }
        Sector sector = Sector.ALIMENTACION;

        switch (opcion) {
            case 1:
                sector = Sector.ALIMENTACION;
                break;
            case 2:
                sector = Sector.EDUCACION;
                break;
            case 3:
                sector = Sector.SALUD;
                break;
            case 4:
                sector = Sector.VESTIMENTA;
                break;
        }

        String auspicianteN = "a" + contador;
        contador++;
        System.out.println(auspicianteN);
        if (buscarAuspiciantePorID(cedula) == null) {
            auspiciantes.add(new Auspiciante(cedula, nombre, nombrePersona, telefono, email, direccion, sitioWeb, redesS, sector));
            System.out.println("usuario agregado con éxito");
            System.out.println();
        } else {
            System.out.println("usuario ya existe");
            System.out.println();
        }
    }

    public static void editarAuspiciante() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cedula del auspiciante que desea editar: ");
        String id = sc.nextLine();
        if(buscarAuspiciantePorID(id) != null){
          Auspiciante ausSel = buscarAuspiciantePorID(id);
          System.out.println();
          System.out.println("--------- Edición de Auspiciante ----------");
          System.out.println();
          System.out.println(ausSel.info());
          System.out.println("");

          System.out.println("1. nombre\n2.persona responsable\n3.telefono\n4.email\n5.direccion\n6.SitioWeb\n7.Redes Sociales\n8.Sector\n \nIngresa opcion que desea editar: ");
          int opcion = 0;
          try {
              opcion = sc.nextInt();
              sc.nextLine();
          } catch (InputMismatchException e) {
              System.out.println("Por favor, ingrese un valor entero válido.");
              sc.nextLine();
          }

          switch (opcion) {
              case 1:
                  System.out.println("nuevo nombre: ");
                  String a = sc.nextLine();
                  ausSel.setNombre(a);
                  break;
              case 2:
                  System.out.println("nueva persona responsable: ");
                  String b = sc.nextLine();
                  ausSel.setNombrePersona(b);
                  break;
              case 3:
                  System.out.println("nuevo telefono: ");
                  String c = sc.nextLine();
                  ausSel.setTelefono(c);
                  break;
              case 4:
                  System.out.println("nuevo email: ");
                  String d = sc.nextLine();
                  ausSel.setEmail(d);
                  break;
              case 5:
                  System.out.println("nueva direccion: ");
                  String e = sc.nextLine();
                  ausSel.setDireccion(e);
                  break;
              case 6:
                  System.out.println("nuevo SitioWeb: ");
                  String f = sc.nextLine();
                  ausSel.setSitioWeb(f);
                  break;
              case 7:
                  System.out.println("nuevas Redes Sociales: ");
                  System.out.println("");
                  ArrayList<String> redesS = new ArrayList<String>();
                  for (String red : nombres_redesS) {
                      System.out.println("(si no tiene deje en blanco)usuario de " + red + ": ");
                      try {
                          String redSocial = sc.nextLine();
                          if (!redSocial.isEmpty()) {
                              redesS.add(redSocial);
                          }
                      } catch (NoSuchElementException ex) {
                          System.out.println("Entrada no válida.");
                          continue;
                      }
                  }
                  System.out.println(redesS);
                  System.out.println();
                  ausSel.setRedesSociales(redesS);
                  break;

              case 8:
                  System.out.println("nuevo Sector: ");
                  System.out.println("");
                  System.out.println("(int)Porfavor eliga el sector\n1.ALIMENTACIÓN\n2.EDUCACIÓN\n3.SALUD\n4.VESTIMENTA ");
                  int op = 0;
                  try {
                      op = sc.nextInt();
                      sc.nextLine();
                  } catch (InputMismatchException z) {
                      System.out.println("Por favor, ingrese un valor entero válido.");
                      sc.nextLine();
                  }
                  Sector sector = Sector.ALIMENTACION;
                  switch (op) {
                      case 1:
                          sector = Sector.ALIMENTACION;
                          break;
                      case 2:
                          sector = Sector.EDUCACION;
                          break;
                      case 3:
                          sector = Sector.SALUD;
                          break;
                      case 4:
                          sector = Sector.VESTIMENTA;
                          break;
                  }
                  ausSel.setSector(sector);
                  break;
          }

          System.out.println("usuario editado con éxito");
          System.out.println("");
          System.out.println(ausSel.info());
          System.out.println("");
          System.out.println("----------------------------------");
        }
      else{
        System.out.println("");
        System.out.println("auspiciante no existe");
        System.out.println("volviendo a administracion de auspiciantes");
        System.out.println("");

        administracionDeAuspicantes();
      }
    }

    public static Auspiciante buscarAuspiciantePorID(String id) {
        for (Auspiciante aus : auspiciantes) {
            if (aus.getCedula().equals(id)) {
                return aus;
            }
        }
        return null;
    }

    public static void asignar_auspiciante_feria() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.print("Ingrese el código de la feria a la que desea asignar el auspiciante: ");
        int c_fer = 0;
        try {
            c_fer = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un valor entero válido.");
            sc.nextLine();
            return;
        }

        System.out.println("Ingrese la cedula del auspiciante: ");
        String c_aus = sc.nextLine();
        Feria fer = MenuFeria.buscarFeriaPorCodigo(c_fer);
        Auspiciante aus = buscarAuspiciantePorID(c_aus);

        if ((fer != null) && (aus != null)) {
            System.out.println("");
            System.out.println("Feria y auspiciantes válidos");
            System.out.println("");
            System.out.print("Descripción de lo cubierto por el auspicio: ");
            String descripcion = sc.nextLine();
            aus.setDescripcion(descripcion);

            System.out.print("Tiene stand en feria (SI/NO): ");
            String resp;
            do {
                resp = sc.nextLine();
                if (resp.equals("SI")) {
                    aus.setStand_en_feria(true);
                } else if (resp.equals("NO")) {
                    aus.setStand_en_feria(false);
                } else {
                    System.out.println("Por favor ingrese una respuesta válida (SI/NO): ");
                }
            } while (!resp.equals("SI") && !resp.equals("NO"));

            fer.getAuspiciantes_en_feria().add(aus);

            System.out.println("Auspiciante asignado a la feria con éxito");
            System.out.println("");
            System.out.println(fer);
            System.out.println("");
            System.out.println("----------------------------------");
        } else if (fer == null) {
            System.out.println("Feria no existente");
        } else if (aus == null) {
            System.out.println("Auspiciante no existente");
        }
    }
}
