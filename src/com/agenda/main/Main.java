package com.agenda.main;

import com.agenda.models.Contacto;
import com.agenda.services.AgendaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaService agenda = new AgendaService();

        int opcion;

        /* Creamos el Menú de opciones*/

        do {
            System.out.println("=== AGENDA TELEFÓNICA===");
            System.out.println("=== Selecciona alguna de las siguientes opciones ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Verificar si existe el contacto");
            System.out.println("3. Lista de contactos");
            System.out.println("4. Buscar contactos");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar telefono");
            System.out.println("7. ¿La agenda está llena?");
            System.out.println("8. ¿Hay espacios en la agenda?");
            System.out.println("Presiona 0 para salir.");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Apellido: ");
                    String apellido = scanner.nextLine();

                    System.out.println("Teléfono: ");
                    String tel = scanner.nextLine();

                    agenda.agregarContacto(new Contacto(nombre, apellido, tel));
                    break;

                case 2:
                    System.out.println("Nombre: ");
                    String n = scanner.nextLine();

                    System.out.println("Apellido: ");
                    String a = scanner.nextLine();

                    if (agenda.existeContacto(new Contacto(n,a,""))){
                        System.out.println("Sí existe.");
                    }else {
                        System.out.println("No existe");
                    }
                    break;

                case 3:
                    agenda.listarContactos();
                    break;

                case 4:
                    System.out.println("Nombe: ");
                    String nbk = scanner.nextLine();

                    System.out.println("Apellido: ");
                    String abk = scanner.nextLine();

                    agenda.buscarContacto(nbk, abk);
                    break;

                case 5:
                    System.out.println("Nombre: ");
                    String ne = scanner.nextLine();

                    System.out.println("Apellido");
                    String ae = scanner.nextLine();

                    agenda.eliminarContacto(new Contacto(ne,ae , ""));
                    break;

                case 6:
                    System.out.println("Nombre: ");
                    String nm = scanner.nextLine();

                    System.out.println("Apellido: ");
                    String am = scanner.nextLine();

                    System.out.println("Nuevo Teléfono: ");
                    String nt = scanner.nextLine();

                    agenda.modificarTelefono(nm, am, nt);
                    break;

                case 7:
                    if (agenda.agendaLlena()){
                        System.out.println("La agenda está llena");
                    }else {
                        System.out.println("La agenda no está llena");
                    }
                    break;
            }
        }while (opcion != 0);

        scanner.close();
    }
}
