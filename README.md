# Sistema de Agenda de Contactos - Hackathon 2

Este proyecto consiste en una aplicación de consola robusta desarrollada en Java, diseñada para gestionar una agenda de contactos de manera eficiente. El sistema permite el almacenamiento, búsqueda, modificación y eliminación de registros, aplicando principios de Programación Orientada a Objetos (POO) y buenas prácticas de desarrollo.


# Funcionalidades
El sistema cumple con los siguientes requisitos técnicos y de negocio:

* Gestión de Contactos: Almacenamiento de nombre, apellido y teléfono.

* Validación de Duplicados: No se permiten contactos con el mismo nombre y apellido (ignora mayúsculas/minúsculas).

* Control de Espacio: Capacidad de definir un tamaño personalizado o usar el valor por defecto (10 contactos).

* Operaciones CRUD:
  * añadirContacto: Registro seguro con validación de campos vacíos.
  * listarContactos: Visualización ordenada alfabéticamente.
  * buscarContacto: Localización rápida por nombre completo.
  * modificarTelefono: Actualización controlada de registros existentes.
  * eliminarContacto: Limpieza de registros con retroalimentación al usuario.

* Estado de Agenda: Consulta de espacios disponibles y estado de saturación.

# Tecnologías y Conceptos Aplicados

* Lenguaje: Java 17+

* Encapsulamiento: Uso de atributos privados y métodos Getter/Setter.
  
* Sobrescritura de Métodos: Implementación personalizada de equals() para lógica de negocio.

* Algoritmos de Búsqueda: Recorrido eficiente de arreglos evitando bucles innecesarios (break).

* Documentación: Uso de estándares JavaDoc para la explicación de métodos.

* Convenciones: Aplicación estricta de CamelCase.

# Equipo de Desarrollo

* Carolina Santibañez
* Daniela Hernández
* Daniel Aguilar
* Eduardo Villedas
* Enrique Villareal
* Francisco González
