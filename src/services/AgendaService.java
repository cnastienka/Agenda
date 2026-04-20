package services;

public class AgendaService {
}

public void añadirContacto(Contacto c) {
//Indica si hay espacio de almacenamiento máximo 10 contactos.
    if (contador >= 10) {
        System.out.println("Agenda llena(máximo 10 contactos)");
        return;
    }
//Valida que no este vacio nombre y apellido
    if (c.getNombre() == null || c.getNombre().isEmpty() ||
            c.getApellido() == null || c.getApellido().isEmpty()) {
        System.out.println("El nombre y apellido no pueden estar vacíos.");
        return;
    }
//Comprobar que no exista ya el contacto (nombre y apellido iguales=duplicado)
    for (int i = 0; i < contador; i++) {
        if (contactos[i].getNombre().equalsIgnoreCase(c.getNombre()) &&
                contactos[i].getApellido().equalsIgnoreCase(c.getApellido())) {
            System.out.println("El contacto ya existe.");
            return;
        }
    }
    //Añadir el contacto
    contactos[contador] = c;
    contador++;

    System.out.println("Contacto añadido correctamente.");
}
