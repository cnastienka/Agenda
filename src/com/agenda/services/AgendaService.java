package com.agenda.services;

import com.agenda.models.Contacto;

/**
 * Métodos de lectura y búsqueda de la agenda telefónica.
 * Parte D: listarContactos, buscarContacto y existeContacto.
 */
public class AgendaService {

    /**
     * Verifica si un contacto ya existe en la agenda.
     * Dos contactos son iguales si tienen el mismo nombre y apellido,
     * sin distinguir entre mayúsculas y minúsculas.
     *
     * @param c El contacto que se desea buscar.
     * @return true si el contacto existe, false en caso contrario.
     */
    public boolean existeContacto(Contacto c) {
        for (int i = 0; i < contador; i++) {
            if (contactos[i] != null
                    && contactos[i].getNombre().equalsIgnoreCase(c.getNombre())
                    && contactos[i].getApellido().equalsIgnoreCase(c.getApellido())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Lista todos los contactos de la agenda en orden alfabético.
     * Formato de salida: "Nombre Apellido - Teléfono".
     * Si la agenda está vacía, muestra un mensaje indicándolo.
     */
    public void listarContactos() {
        if (contador == 0) {
            System.out.println("La agenda está vacía.");
            return;
        }

        // Copia solo los contactos reales (sin nulls) a un arreglo temporal
        Contacto[] temp = new Contacto[contador];
        for (int i = 0; i < contador; i++) {
            temp[i] = contactos[i];
        }

        // Ordenamiento alfabético por nombre y apellido (burbuja)
        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = 0; j < temp.length - 1 - i; j++) {
                String nombreCompleto1 = temp[j].getNombre() + " " + temp[j].getApellido();
                String nombreCompleto2 = temp[j + 1].getNombre() + " " + temp[j + 1].getApellido();
                if (nombreCompleto1.compareToIgnoreCase(nombreCompleto2) > 0) {
                    Contacto aux = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = aux;
                }
            }
        }

        // Mostrar contactos ordenados
        System.out.println("=== Lista de Contactos ===");
        for (Contacto c : temp) {
            System.out.println(c.getNombre() + " " + c.getApellido() + " - " + c.getTelefono());
        }
    }

    /**
     * Busca un contacto por nombre y apellido y muestra su teléfono.
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     * Si no existe, muestra un mensaje indicándolo.
     *
     * @param nombre   El nombre del contacto a buscar.
     * @param apellido El apellido del contacto a buscar.
     */
    public void buscarContacto(String nombre, String apellido) {
        for (int i = 0; i < contador; i++) {
            if (contactos[i] != null
                    && contactos[i].getNombre().equalsIgnoreCase(nombre)
                    && contactos[i].getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Contacto encontrado: "
                        + contactos[i].getNombre() + " "
                        + contactos[i].getApellido() + " - "
                        + contactos[i].getTelefono());
                return;
            }
        }
        System.out.println("No se encontró ningún contacto con el nombre: "
                + nombre + " " + apellido + ".");
    }
}