package interfaces;

import java.io.*;
import modelo.*;
import java.util.Scanner;
import java.util.ArrayList;

public class MenuEmprendedor {


  
    private static ArrayList<Emprendedor> l_emprendedores = new ArrayList<Emprendedor>();
    public static String[] nombres_redesS = new String[]{"Twitter", "Facebook", "Instagram", "Youtube", "Tik tok", "Linkedin", "Pinterest"};
    public static int y = 0;
    
    public static void agregar4Emprendedores() {

        if(y==0){
         y++;
        Feria fer = MenuFeria.ferias.get(0);
        Stand stand1 = fer.getSeccion1().get(0);
        Stand stand2 = fer.getSeccion2().get(0);
        Stand stand3 = fer.getSeccion3().get(0);
        Stand stand4 = fer.getSeccion4().get(0);
      
        ArrayList<String> redesJibaja = new ArrayList<String>();

        for (String red : nombres_redesS) {
            String redSocial = "@jdjr2005";
            redesJibaja.add(redSocial);
        }
        Emprendedor emp1 = new Emprendedor("1725944720", "Josue Jibaja", "CARRILLO BASTIDAS GLADYS ELIANA", "0969237923", "jdjibaja@espol.edu.ec", "La joya", "this-is-the-way.com", redesJibaja, "servicio de armado de drones");
        l_emprendedores.add(emp1);
        fer.emprendedores.add(emp1);
        stand1.setEmprendedor(emp1);
      stand1.setCodigo("A1*");
      

      

        ArrayList<String> redesBohorquez = new ArrayList<String>();

        for (String red : nombres_redesS) {
            String redSocial = "@tilin_exe";
            redesBohorquez.add(redSocial);
        }
        Emprendedor emp2 = new Emprendedor("1211111111", "Andres Bohorquez", "CARRILLO BASTIDAS GLADYS ELIANA", "0999999999", "bohorquez@espol.edu.ec", "guayaquil", "tilin.com", redesBohorquez, "pasar deadlocked(geometry dash)");
        l_emprendedores.add(emp2);
        fer.emprendedores.add(emp2);
        stand2.setEmprendedor(emp2);
      stand2.setCodigo("B1*");

        ArrayList<String> redesMedina = new ArrayList<String>();

        for (String red : nombres_redesS) {
            String redSocial = "@medina";
            redesMedina.add(redSocial);
        }
        Emprendedor emp3 = new Emprendedor("1311111111", "Miguel Medina", "CARRILLO BASTIDAS GLADYS ELIANA", "0999999999", "medina@espol.edu.ec", "guayaquil", "medina.com", redesMedina, "Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        l_emprendedores.add(emp3);
        fer.emprendedores.add(emp3);
        stand3.setEmprendedor(emp3);
        stand3.setCodigo("C1*");

        ArrayList<String> redesJohnDoe = new ArrayList<String>();

        for (String red : nombres_redesS) {
            String redSocial = "@JohnDoe";
            redesJohnDoe.add(redSocial);
        }
        Emprendedor emp4 = new Emprendedor("1411111111", "John Doe", "CARRILLO BASTIDAS GLADYS ELIANA", "0999999999", "johndoe@espol.edu.ec", "guayaquil", "john_doe.com", redesJohnDoe, "Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        l_emprendedores.add(emp4);
        fer.emprendedores.add(emp4);
        stand4.setEmprendedor(emp4);
      stand4.setCodigo("D1*");
        }
        
    }

    public static void mostrar_MenuE() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            try {
                System.out.println("-------Lista de Emprendedores:-------");
                System.out.println();
                if (l_emprendedores.size() == 0) {
                    System.out.println("No hay emprendedores registrados");
                } else {
                    for (Emprendedor emprendedor : l_emprendedores) {
                        System.out.println(emprendedor);
                    }
                }

                System.out.println("");
                System.out.println("------- Menú de Emprendedores -------");
                System.out.println("1. Registrar Emprendedor");
                System.out.println("2. Editar Emprendedor");
                System.out.println("3. Regresar");
                System.out.println("Ingrese una opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
                switch (opcion) {
                    case 1:
                        registrar_emprendedor();
                        break;
                    case 2:
                        editar_emprendedor();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Clear input buffer
                opcion = 0; // Reset option to force re-entering correct input
            }
        } while (opcion != 3);
    }

    public static void registrar_emprendedor() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el nombre del Emprendedor: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese la cedula del Emprendedor: ");
            String cedula = sc.nextLine();
            System.out.println("Porfavor ingrese el nombre de la persona que es responsable: ");
            String nombrePersona = sc.nextLine();
            System.out.println("Ingrese el telefono del Emprendedor: ");
            String telefono = sc.nextLine();
            System.out.println("Porfavor ingrese el email: ");
            String email = sc.nextLine();
            System.out.println("Ingrese la dirección del Emprendedor: ");
            String direccion = sc.nextLine();
            System.out.println("Porfavor ingrese el sitio web: ");
            String sitioWeb = sc.nextLine();
            System.out.println("Porfavor ingrese una descripción de los servicios que ofrece: ");
            String description = sc.nextLine();

            System.out.println("Porfavor ingrese la lista de redes sociales");
            ArrayList<String> redesS = new ArrayList<String>();
            for (String red : nombres_redesS) {
                System.out.println("(si no tiene deje en blanco)usuario de " + red + ": ");
                String redSocial = sc.nextLine();
                if (!redSocial.isEmpty()) {
                    redesS.add(redSocial);
                }
            }

            System.out.println(redesS);
            System.out.println();

            if (buscarEmprendedorPorID(cedula) == null) {
                l_emprendedores.add(new Emprendedor(cedula, nombre, nombrePersona, telefono, email, direccion, sitioWeb, redesS, description));

                System.out.println("emprendedor agregado con exito");
                System.out.println();
            } else {
                System.out.println("usuario ya existe");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error al registrar emprendedor: " + e.getMessage());
        }
    }

    public static void editar_emprendedor() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese la cedula del emprendedor que desea editar: ");
            String id = sc.nextLine();
            Emprendedor empSel = buscarEmprendedorPorID(id);
            System.out.println();
            System.out.println("--------- Edición de Emprendedor ----------");
            System.out.println();
            System.out.println(empSel.info());
            System.out.println();
            System.out.println("1. nombre\n2.persona responsable\n3.telefono\n4.email\n5.direccion\n6.SitioWeb\n7.Redes Sociales\n8.descripcion\nIngresa Opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("nuevo nombre: ");
                    String a = sc.nextLine();
                    empSel.setNombre(a);
                    break;
                case 2:
                    System.out.println("nueva persona responsable: ");
                    String b = sc.nextLine();
                    empSel.setNombrePersona(b);
                    break;
                case 3:
                    System.out.println("nuevo telefono: ");
                    String c = sc.nextLine();
                    empSel.setTelefono(c);
                    break;
                case 4:
                    System.out.println("nuevo email: ");
                    String d = sc.nextLine();
                    empSel.setEmail(d);
                    break;
                case 5:
                    System.out.println("nueva direccion: ");
                    String e = sc.nextLine();
                    empSel.setDireccion(e);
                    break;
                case 6:
                    System.out.println("nuevo SitioWeb: ");
                    String f = sc.nextLine();
                    empSel.setSitioWeb(f);
                    break;
                case 7:
                    System.out.println("nuevas Redes Sociales: ");
                    System.out.println("");
                    ArrayList<String> redesS = new ArrayList<String>();
                    for (String red : nombres_redesS) {
                        System.out.println("(si no tiene deje en blanco)usuario de " + red + ": ");
                        String redSocial = sc.nextLine();
                        if (!redSocial.isEmpty()) {
                            redesS.add(redSocial);
                        }
                    }
                    System.out.println(redesS);
                    System.out.println();
                    empSel.setRedesSociales(redesS);
                    break;
                case 8:
                    System.out.println("nueva descripción: ");
                    String des = sc.nextLine();
                    empSel.setDescripcion(des);
                    break;
            }

            System.out.println("emprendedor editado con exito");
            System.out.println("");
            System.out.println(empSel.info());
            System.out.println("");
            System.out.println("----------------------------------");
        } catch (Exception e) {
            System.out.println("Error al editar emprendedor: " + e.getMessage());
        }
    }

    public static Emprendedor buscarEmprendedorPorID(String id) {
        for (Emprendedor emp : l_emprendedores) {
            if (emp.getCedula().equals(id)) {
                return emp;
            }
        }
        return null;
    }
    
    public static ArrayList<Emprendedor> getEmprendedores() {
    return l_emprendedores;
}
    
}
