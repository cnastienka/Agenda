/**
 * mi avance del dia de hoy
 */
package com.agenda.services;

import com.agenda.models.Contacto;

/**
 * Clase Agenda
 * Se encarga de gestinar el almacenamiento de contactos.
 * Permite crear una agenda con un tamaño definido, verificar si esta llena.
 * conocer los espacios disponibles y agregar nuevos contactos.
 */

public class Agenda {
    /**
 * Arreglo donde se almacen los contactos
 */

private Contacto[] contactos;

    /**
     * Contador que indica cuantos contactos hay actualmente
     */
    private int contador;

    /**
     * Constructor por defecto
     * Crea una agenda con capacidd para 10 personas
     */

    public Agenda() {
        contactos = new Contacto[10];
        contador = 0;
    }

    /**
     * Constructor con tamaño personalizado
     *
     * @param tamaño
     */

    public Agenda(int tamaño) {
        contactos = new Contacto[tamaño];
        contador = 0;
    }

    /**
     * Verifica que la agenda esta llena
     *
     * @return
     */

    public boolean agendaLlena() {
        return contador == contactos.length;
    }

    /**
     * Calcula los espacios disponibles
     *
     * @return
     */

    public int espaciosLibres() {
        return contactos.length - contador;
    }

    /**
     * Método auxiliar para agregar contacto (te servirá después)
     *
     * @param c
     */
    public void agregarContacto(Contacto c) {
        if (!agendaLlena()) {
            contactos[contador] = c;
            contador++;
        } else {
            System.out.println("La agenda está llena.");
        }
    }
}