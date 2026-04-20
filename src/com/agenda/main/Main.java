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
            System.out.println("1. Agregar contacto");
            System.out.println("2. Verificar si existe el contacto");
            System.out.println("3. Lista de contactos");
            System.out.println("4. Buscar contactos");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar telefono");
            System.out.println("7. ");
        }

    }
}
