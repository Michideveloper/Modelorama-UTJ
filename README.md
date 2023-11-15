# Inventario Modelorama

Este programa en Java implementa un sistema de gestión de inventario de productos de modelorama mediante un menú interactivo en la consola. Los productos se almacenan en un catálogo con campos separados por `;`.

## Funcionalidades

El programa proporciona las siguientes funcionalidades:
**CRUD**

1. **Crear Producto:** Permite al usuario ingresar datos para agregar un nuevo producto al catálogo.

2. **Ver Productos:** Muestra en la consola todos los productos almacenados en el catálogo.

3. **Editar Producto:** Permite al usuario actualizar la información de un producto existente en el catálogo.

4. **Borrar Producto:** Elimina un producto del catálogo según el índice proporcionado por el usuario.

5. **Salir:** Finaliza la ejecución del programa.

## Estructura del Catálogo

Cada producto en el catálogo se representa como una cadena de texto con cuatro campos separados por `;`. Estos campos son: nombre, precio, descripción e inventario disponible.

Ejemplo de formato del registro en el catálogo: `nombre;precio;descripcion;inventarioDisponible;`

## Uso del Programa

1. Ejecute el programa desde la línea de comandos.

2. Seleccione una opción del menú interactivo ingresando el número correspondiente.

3. Siga las instrucciones en pantalla para realizar las acciones deseadas.

## Requisitos

- JDK instalado en el sistema.
- JRE instalado en el sistema.

## Ejecución

```bash
javac Main.java
java Main
