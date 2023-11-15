import java.util.Scanner;

/**
 * Clase principal que gestiona un catálogo de productos mediante un menú interactivo.
 */
public class Main {

  // Variable para almacenar los datos con campos separados por ";"
  private static String catalogo = "";

  /*
   * Método principal que inicia la ejecución del programa.
   */
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    // Bucle principal del programa
    while (true) {
      mostrarMenu(); // Muestra el menú
      System.out.print("Seleccione una opción: ");
      int opcion = teclado.nextInt();
      teclado.nextLine(); // Consumir la nueva línea después de nextInt()

      switch (opcion) {
        case 1:
          crearProducto(teclado);
          break;
        case 2:
          leerProductos();
          break;
        case 3:
          actualizarProducto(teclado);
          break;
        case 4:
          eliminarProducto(teclado);
          break;
        case 5:
          salir(teclado);
          break;
        default:
          System.out.println("Opción inválida. Intente nuevamente.");
      }
    }
  }

  /**
   * Muestra el menú de opciones.
   */
  private static void mostrarMenu() {
    System.out.println("\n-- 🍺 Inventario 🍺 --");
    System.out.println("- Ingresa una opcion -");
    System.out.println("1. 🆕 Crear producto 🆕");
    System.out.println("2. 👁️‍🗨️ Ver productos 👁️‍🗨️");
    System.out.println("3. ✏️ Editar producto ✏️");
    System.out.println("4. 💣 Borrar producto 💣");
    System.out.println("5. Salir");
  }

  /**
   * Crea un nuevo registro ingresando datos desde el teclado.
   *
   * @param scanner Scanner para leer la entrada del usuario.
   */
  private static void crearProducto(Scanner scanner) {
    System.out.println("--Nuevo producto--");
    System.out.print("Ingrese el nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("Ingrese el precio: ");
    String precio = scanner.nextLine();
    System.out.print("Ingrese la descripción: ");
    String descripcion = scanner.nextLine();
    System.out.print("Ingrese el inventario disponible: ");
    String inventarioDisponible = scanner.nextLine();

    // Formato del registro: nombre;precio;descripcion;inventarioDisponible;
    String nuevoRegistro = nombre + ";" + precio + ";" + descripcion + ";" + inventarioDisponible + ";";
    catalogo += nuevoRegistro;
    System.out.println("Registro creado con éxito.");
  }

  /**
   * Lee y muestra todos los registros almacenados.
   */
  private static void leerProductos() {
    if (!catalogo.isEmpty()) {
      String[] registros = catalogo.split(";");
      System.out.println("🍺 Catalogo Modelorama 🍺 :");
      for (int i = 0; i < registros.length; i += 4) {
        System.out.println((i / 4 + 1) + ". Nombre: " + registros[i] +
            ", Precio: " + registros[i + 1] +
            ", Descripción: " + registros[i + 2] +
            ", Inventario Disponible: " + registros[i + 3]);
      }
    } else {
      System.out.println("No hay registros para mostrar. Cree uno primero.");
    }
  }

  /**
   * Actualiza un registro existente ingresando nuevos datos desde el teclado.
   *
   * @param scanner Scanner para leer la entrada del usuario.
   */
  private static void actualizarProducto(Scanner scanner) {
    if (!catalogo.isEmpty()) {
      System.out.println("Nota: Si no te sabes el índice del registro, verifica el catálogo de productos");
      System.out.print("Ingrese el índice del registro que desea actualizar: ");
      int indiceActualizar = scanner.nextInt();
      scanner.nextLine(); // Consumir la nueva línea después de nextInt()

      if (indiceActualizar > 0 && indiceActualizar <= 9999999) {
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo precio: ");
        String nuevoPrecio = scanner.nextLine();
        System.out.print("Ingrese la nueva descripción: ");
        String nuevaDescripcion = scanner.nextLine();
        System.out.print("Ingrese el nuevo inventario disponible: ");
        String nuevoInventario = scanner.nextLine();

        // Formato del registro: nombre;precio;descripcion;inventarioDisponible;
        String nuevoRegistro = nuevoNombre + ";" + nuevoPrecio + ";" + nuevaDescripcion + ";" + nuevoInventario + ";";

        String[] registros = catalogo.split(";");
        int inicio = (indiceActualizar - 1) * 4;
        for (int i = 0; i < 4; i++) {
          registros[inicio + i] = nuevoRegistro.split(";")[i];
        }
        catalogo = String.join(";", registros);
        System.out.println("Registro actualizado con éxito.");
      } else {
        System.out.println("Índice inválido.");
      }
    } else {
      System.out.println("No hay registros para actualizar. Cree uno primero.");
    }
  }

  /**
   * Elimina un registro existente ingresando el índice desde el teclado.
   *
   * @param scanner Scanner para leer la entrada del usuario.
   */
  private static void eliminarProducto(Scanner scanner) {
    if (!catalogo.isEmpty()) {
      System.out.print("Ingrese el índice del registro que desea eliminar: ");
      int indiceEliminar = scanner.nextInt();
      scanner.nextLine(); // Consumir la nueva línea después de nextInt()

      if (indiceEliminar > 0 && indiceEliminar <= 9999999) {
        String[] registros = catalogo.split(";");
        int inicio = (indiceEliminar - 1) * 4;
        for (int i = 0; i < 4; i++) {
          registros[inicio + i] = "B̶O̶R̶R̶A̶D̶O̶";
        }
        catalogo = String.join(";", registros);
        System.out.println("Registro eliminado con éxito.");
      } else {
        System.out.println("Índice inválido.");
      }
    } else {
      System.out.println("No hay registros para eliminar. Cree uno primero.");
    }
  }

  /**
   * Finaliza la ejecución del programa.
   *
   * @param scanner Scanner para cerrar antes de salir.
   */
  private static void salir(Scanner scanner) {
    System.out.println("Saliendo del programa. ¡Hasta luego!");
    scanner.close();
    System.exit(0);
  }
}
