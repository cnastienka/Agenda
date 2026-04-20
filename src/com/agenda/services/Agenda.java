package com.agenda.services;

public class Agenda {


/*
* Método añadir existeContacto
* Valida si el contacto ya existe dentro del arreglo
 */
    private boolean existeContacto(Contacto c) {

        for (int i = 0; i < contador; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(c.getNombre()) &&
                    contactos[i].getApellido().equalsIgnoreCase(c.getApellido())) {
                return true;
            }
        }

        return false;
    }
    /*
    *Método añadir contacto
    * Indica si hay espacio de almacenamiento máximo 10 contactos. (metodo: agendaLlena)
    * Valida que no este vacio nombre y apellido
    * Comprobar que no exista ya el contacto usando metodo existeContacto
    * Se añade el contacto si es el caso
     */
    public void añadirContacto(Contacto c) {

        if (agendaLlena()) {
            System.out.println("La agenda está llena.");
            return;
        }

        if (c.getNombre() == null || c.getNombre().isEmpty() ||
                c.getApellido() == null || c.getApellido().isEmpty()) {
            System.out.println("El nombre y apellido no pueden estar vacíos.");
            return;
        }

        if (existeContacto(c)) {
            System.out.println("El contacto ya existe.");
            return;
        }
        //Añadir el contacto
        contactos[contador] = c;
        contador++;

        System.out.println("Contacto añadido correctamente.");
    }
}