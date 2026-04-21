package com.agenda.main;

import com.agenda.models.Contacto;
import com.agenda.services.AgendaService;

import java.util.Scanner;

/**
 * Clase principal de la Agenda Telefónica.
 * Contiene el menú interactivo por consola para gestionar los contactos.
 *
 * @author Equipo San Lunes
 * @version 1.0
 */
public class Main {

    /**
     * Metodo principal que inicializa la agenda y despliega el menú de opciones.
     * Permite al usuario agregar, buscar, listar, eliminar y modificar contactos.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaService agenda = new AgendaService();

        // Contactos de prueba precargados para la demostración
        agenda.agregarContacto(new Contacto("Carolina", "Santibañez", "5544206949"));
        agenda.agregarContacto(new Contacto("Daniel", "Aguilar", "5573042338"));
        agenda.agregarContacto(new Contacto("Daniela", "Hernández", "7712180152"));
        agenda.agregarContacto(new Contacto("Eduardo", "Villedas", "5548372797"));
        agenda.agregarContacto(new Contacto("Enrique", "Villarreal", "5532161821"));
        agenda.agregarContacto(new Contacto("Francisco", "González", "5540744468"));

        int opcion;

        /* Menú principal en bucle hasta que el usuario presione 0 para salir */
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

            switch (opcion) {

                case 1:
                    // Verifica disponibilidad antes de solicitar los datos del nuevo contacto
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena, no se pueden agregar más contactos.");
                        break;
                    }
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Apellido: ");
                    String apellido = scanner.nextLine();

                    System.out.println("Teléfono: ");
                    String tel = scanner.nextLine();

                    agenda.agregarContacto(new Contacto(nombre, apellido, tel));
                    break;

                case 2:
                    // Verifica si un contacto existe en la agenda por nombre y apellido
                    System.out.println("Nombre: ");
                    String n = scanner.nextLine();

                    System.out.println("Apellido: ");
                    String a = scanner.nextLine();

                    if (agenda.existeContacto(new Contacto(n, a, ""))) {
                        System.out.println("Sí existe.");
                    } else {
                        System.out.println("No existe");
                    }
                    break;

                case 3:
                    // Muestra todos los contactos ordenados alfabéticamente
                    agenda.listarContactos();
                    break;

                case 4:
                    // Busca un contacto por nombre y apellido y muestra su teléfono
                    System.out.println("Nombre: ");
                    String nbk = scanner.nextLine();

                    System.out.println("Apellido: ");
                    String abk = scanner.nextLine();

                    agenda.buscarContacto(nbk, abk);
                    break;

                case 5:
                    // Elimina un contacto de la agenda por nombre y apellido
                    System.out.println("Nombre: ");
                    String ne = scanner.nextLine();

                    System.out.println("Apellido:");
                    String ae = scanner.nextLine();

                    agenda.eliminarContacto(new Contacto(ne, ae, ""));
                    break;

                case 6:
                    // Modifica el teléfono de un contacto existente
                    System.out.println("Nombre: ");
                    String nm = scanner.nextLine();

                    System.out.println("Apellido: ");
                    String am = scanner.nextLine();

                    System.out.println("Nuevo Teléfono: ");
                    String nt = scanner.nextLine();

                    agenda.modificarTelefono(nm, am, nt);
                    break;

                case 7:
                    // Indica si la agenda ha alcanzado su capacidad máxima
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena");
                    } else {
                        System.out.println("La agenda no está llena");
                    }
                    break;

                case 8:
                    // Muestra cuántos espacios quedan disponibles en la agenda
                    System.out.println("Espacios disponibles: " + agenda.espaciosLibres());
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
