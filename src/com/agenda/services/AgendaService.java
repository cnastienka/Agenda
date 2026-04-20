package com.agenda.services;

public class AgendaService extends Agenda{
    /**
     * Elimina un contacto de la agenda si este existe.
     * Muestra un mensaje indicando si la eliminación fue exitosa o no.
     *
     * @param c El objeto Contacto que se desea eliminar de la agenda.
     */

    public void eliminarContacto(Contacto c) {
        boolean encontrado = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                contactos[i] = null; // Eliminación lógica
                encontrado = true;
                System.out.println("Contacto eliminado exitosamente.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Error: El contacto no existe en la agenda.");
        }
    }

    /**
     * Permite modificar el teléfono de un contacto existente buscando por nombre y apellido.
     * Si el contacto no se encuentra, muestra un mensaje de error.
     *
     * @param nombre        El nombre del contacto a modificar.
     * @param apellido      El apellido del contacto a modificar.
     * @param nuevoTelefono El nuevo número telefónico a asignar.
     */

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        boolean modificado = false;
        for (Contacto c : contactos) {
            if (c != null && c.getNombre().equalsIgnoreCase(nombre)
                    && c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                modificado = true;
                System.out.println("Teléfono actualizado correctamente.");
                break;
            }
        }
        if (!modificado) {
            System.out.println("Error: No se encontró a " + nombre + " " + apellido + ".");
        }

    }
}
