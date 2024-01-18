package interfaces;

import modelo.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuFeria {

    public static ArrayList<Feria> ferias = new ArrayList<Feria>();

    public static void administracionDeFerias() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("----------- Lista de Ferias -------");
            System.out.println();

            for (Feria feria : ferias) {
                System.out.println("-" + feria);
                System.out.println();
            }

            System.out.println();
            System.out.println("----------- Administración de Ferias -------");
            System.out.println();

            System.out.println("1. Ver información de feria \n2. Registrar feria \n3. Editar feria \n4. Consultar emprendedores en feria \n5. Regresar");
            System.out.print("(Por favor, ingrese un número): ");

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // Consumir la nueva línea después de leer el entero
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                sc.nextLine(); // Limpiar el buffer
                continue; // Vuelve al inicio del bucle
            }

            switch (opcion) {
                case 1:
                    verInformacionFeria();
                    break;
                case 2:
                    registrarFeria();
                    break;
                case 3:
                    editarFeria();
                    break;
                case 4:
                    consultarEmprendedoresEnFeria();
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 5);
    }

    static void verInformacionFeria() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código de la feria: ");
        System.out.println();

        try {
            int codigoFeria = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer el entero

            Feria feriaSeleccionada = buscarFeriaPorCodigo(codigoFeria);

            if (feriaSeleccionada != null) {
                System.out.println();
                System.out.println("---- Información de la Feria ----");
                System.out.println();
                System.out.println("Código: " + feriaSeleccionada.getCodigo());
                System.out.println("Nombre: " + feriaSeleccionada.getNombre());
                System.out.println("Descripción: " + feriaSeleccionada.getDescripcion());
                System.out.println("Lugar: " + feriaSeleccionada.getLugar());
                System.out.println("Fecha de Inicio: " + feriaSeleccionada.getFechaInicio());
                System.out.println("Fecha de Fin: " + feriaSeleccionada.getFechaFin());
                System.out.println("Horario: " + feriaSeleccionada.getHorario());

                System.out.println("Secciones y cantidad de stands:");
                System.out.println("Sección 1: " + feriaSeleccionada.getSeccion1().size() + " stands");
                System.out.println("Sección 2: " + feriaSeleccionada.getSeccion2().size() + " stands");
                System.out.println("Sección 3: " + feriaSeleccionada.getSeccion3().size() + " stands");
                System.out.println("Sección 4: " + feriaSeleccionada.getSeccion4().size() + " stands");

            } else {
                System.out.println("No se encontró una feria con el código ingresado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un código válido.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    public static Feria buscarFeriaPorCodigo(int codigo) {
        for (Feria feria : ferias) {
            if (feria.getCodigo() == codigo) {
                return feria;
            }
        }
        return null;
    }

    static void registrarFeria() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------- Registro de Feria ----------");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        System.out.print("Lugar: ");
        String lugar = scanner.nextLine();

        System.out.print("Fecha de Inicio(dd/mm/aa): ");
        String fechaInicio = scanner.nextLine();

        System.out.print("Fecha de Fin(dd/mm/aa): ");
        String fechaFin = scanner.nextLine();

        System.out.print("Horario: ");
        String horario = scanner.nextLine();

        System.out.println("Ingrese la cantidad de stands por sección:");

        ArrayList<Stand> seccion1 = new ArrayList<Stand>();
        ArrayList<Stand> seccion2 = new ArrayList<Stand>();
        ArrayList<Stand> seccion3 = new ArrayList<Stand>();
        ArrayList<Stand> seccion4 = new ArrayList<Stand>();

        try {
            System.out.print("Sección 1: ");
            int cantidadStands = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            int b = 1;
            for (int i = 0; i < cantidadStands; i++) {
                seccion1.add(new Stand("A" + b));
              b++;
            }
            b = 0; //reseteo contador
            System.out.print("Sección 2: ");
            cantidadStands = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            for (int i = 0; i < cantidadStands; i++) {
              b++;
                seccion2.add(new Stand("B"+ b));
            }
          b = 0;

            System.out.print("Sección 3: ");
            cantidadStands = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            for (int i = 0; i < cantidadStands; i++) {
              b++;
                seccion3.add(new Stand("C"+ b));
            }
          b = 0;
            System.out.print("Sección 4: ");
            cantidadStands = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            for (int i = 0; i < cantidadStands; i++) {
              b++;
                seccion4.add(new Stand("D"+ b));
            }

            Feria nuevaFeria = new Feria(nombre, descripcion, lugar, fechaInicio, fechaFin, horario, seccion1, seccion2, seccion3, seccion4);
            ferias.add(nuevaFeria);

            System.out.println("Feria registrada con éxito.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    static void editarFeria() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("(usar codigo 1 como ejemplo)Ingrese el código de la feria que desea editar: ");
        try {
            int codigoFeria = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer el entero

            Feria feriaSeleccionada = buscarFeriaPorCodigo(codigoFeria);

            if (feriaSeleccionada != null) {
                System.out.println("--------- Edición de Feria ----------");

                System.out.print("Nuevo nombre (actual: " + feriaSeleccionada.getNombre() + "): ");
                String nuevoNombre = scanner.nextLine();
                feriaSeleccionada.setNombre(nuevoNombre);

                System.out.print("Nueva descripción (actual: " + feriaSeleccionada.getDescripcion() + "): ");
                String nuevaDescripcion = scanner.nextLine();
                feriaSeleccionada.setDescripcion(nuevaDescripcion);

                System.out.print("Nuevo lugar (actual: " + feriaSeleccionada.getLugar() + "): ");
                String nuevoLugar = scanner.nextLine();
                feriaSeleccionada.setLugar(nuevoLugar);

                System.out.print("Nueva fecha de inicio (actual: " + feriaSeleccionada.getFechaInicio() + "): ");
                String nuevaFechaInicio = scanner.nextLine();
                feriaSeleccionada.setFechaInicio(nuevaFechaInicio);

                System.out.print("Nueva fecha de fin (actual: " + feriaSeleccionada.getFechaFin() + "): ");
                String nuevaFechaFin = scanner.nextLine();
                feriaSeleccionada.setFechaFin(nuevaFechaFin);

                System.out.print("Nuevo horario (actual: " + feriaSeleccionada.getHorario() + "): ");
                String nuevoHorario = scanner.nextLine();
                feriaSeleccionada.setHorario(nuevoHorario);

                System.out.println("Nueva cantidad de stands por sección:");

                // for (int i = 0; i < feriaSeleccionada.getCantidadStands().length; i++) {
                //     System.out.print("Sección " + (i + 1) + " (actual: " + feriaSeleccionada.getCantidadStands()[i] + "): ");
                //     int nuevaCantidad = scanner.nextInt();
                //     feriaSeleccionada.getCantidadStands()[i] = nuevaCantidad;
                // }

                System.out.println("Feria editada con éxito.");

            } else {
                System.out.println("No se encontró una feria con el código ingresado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un código válido.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    public static void consultarEmprendedoresEnFeria() {
        Scanner scanner = new Scanner(System.in);
        Stand standSeleccionado = null;
        String seccionSeleccionada = "";
        System.out.print("Ingrese el código de la feria: ");
        try {
            int codigoFeria = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer el entero

            Feria feriaSeleccionada = buscarFeriaPorCodigo(codigoFeria);

            if (feriaSeleccionada != null) {
                System.out.println("---- Emprendedores en la Feria ----");
                ArrayList<Emprendedor> emprendedoresEnFeria = feriaSeleccionada.getEmprendedores();

                for (Emprendedor emprendedor : emprendedoresEnFeria) {
                    System.out.println("Nombre: " + emprendedor.getNombre());
                    System.out.println("Descripción de servicios: " + emprendedor.getDescripcion());

                  
                  for(Stand stand:feriaSeleccionada.getSeccion1()){
                    if(stand.getEmprendedor() != null){
                      if(stand.getEmprendedor().equals(emprendedor)){
                      standSeleccionado=stand;
                      seccionSeleccionada = "A";
                  }
                  }
                  }
                  for(Stand stand:feriaSeleccionada.getSeccion2()){
                    if(stand.getEmprendedor() != null){
                      if(stand.getEmprendedor().equals(emprendedor)){
                      standSeleccionado=stand;
                        seccionSeleccionada = "B";
                  }
                  }
                  }
                  for(Stand stand:feriaSeleccionada.getSeccion3()){
                    if(stand.getEmprendedor() != null){
                      if(stand.getEmprendedor().equals(emprendedor)){
                      standSeleccionado=stand;
                        seccionSeleccionada = "C";
                  }
                  }
                  }
                  for(Stand stand:feriaSeleccionada.getSeccion4()){
                    if(stand.getEmprendedor() != null){
                      if(stand.getEmprendedor().equals(emprendedor)){
                      standSeleccionado=stand;
                        seccionSeleccionada = "D";
                  }
                  }
                  }
                    System.out.println("Sección: " + seccionSeleccionada);
                    System.out.println("Stand asignado: " + standSeleccionado);
                    System.out.println("------------------------------");
                }
            } else {
                System.out.println("No se encontró una feria con el código ingresado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un código válido.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    public static void agregarFeriaTest() {
        ArrayList<Stand> seccion1 = new ArrayList<Stand>();
        ArrayList<Stand> seccion2 = new ArrayList<Stand>();
        ArrayList<Stand> seccion3 = new ArrayList<Stand>();
        ArrayList<Stand> seccion4 = new ArrayList<Stand>();

        seccion1.add(new Stand("A1"));
        seccion1.add(new Stand("A2"));
        seccion2.add(new Stand("B1"));
        seccion3.add(new Stand("C1"));
        seccion4.add(new Stand("D1"));

        Feria nuevaFeriatest = new Feria("FeriaInicial", "feria_creada_al_inicio(ejemplo)", "FADCOM", "1/01/2024", "3/01/2024", "9:00am - 12:00pm", seccion1, seccion2, seccion3, seccion4);

        ferias.add(nuevaFeriatest);
    }
}