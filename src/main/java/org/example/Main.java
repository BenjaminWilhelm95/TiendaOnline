import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        TiendaOnline tienda = new TiendaOnline();
        Scanner scanner = new Scanner(System.in);

        // Ejemplo de uso
        tienda.agregarProducto(new Producto("Pc gamer", "Prodcuto dedicado a videojuegos", 1000.99, 20, "Categoría A"));
        tienda.agregarProducto(new Producto("Samsung s20", "Un telefono", 250.49, 15, "Categoría B"));

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Buscar producto por nombre o categoría");
            System.out.println("3. Agregar nuevo producto");
            System.out.println("4. Modificar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Realizar compra");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    tienda.mostrarProductos();
                    break;
                case 2:
                    System.out.println("Ingrese término de búsqueda:");
                    String busqueda = scanner.nextLine();
                    tienda.buscarProducto(busqueda);
                    break;
                case 3:
                    System.out.println("Ingrese nombre del nuevo producto:");
                    String nombreNuevo = scanner.nextLine();
                    System.out.println("Ingrese descripción:");
                    String descripcion = scanner.nextLine();
                    System.out.println("Ingrese precio:");
                    double precio = scanner.nextDouble();
                    System.out.println("Ingrese stock:");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese categoría:");
                    String categoria = scanner.nextLine();
                    tienda.agregarProducto(new Producto(nombreNuevo, descripcion, precio, stock, categoria));
                    System.out.println("Producto agregado con éxito.");
                    break;
                case 4:
                    System.out.println("Ingrese índice del producto a modificar:");
                    int indiceMod = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    if (indiceMod >= 0 && indiceMod < tienda.getProductos().size()) {
                        Producto productoMod = tienda.getProductos().get(indiceMod);
                        System.out.println("Ingrese nuevo nombre:");
                        productoMod.setNombre(scanner.nextLine());
                        System.out.println("Ingrese nueva descripción:");
                        productoMod.setDescripcion(scanner.nextLine());
                        System.out.println("Ingrese nuevo precio:");
                        productoMod.setPrecio(scanner.nextDouble());
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.println("Ingrese nuevo stock:");
                        productoMod.setStock(scanner.nextInt());
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.println("Ingrese nueva categoría:");
                        productoMod.setCategoria(scanner.nextLine());
                        tienda.modificarProducto(indiceMod, productoMod);
                        System.out.println("Producto modificado con éxito.");
                    } else {
                        System.out.println("Índice de producto inválido.");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese índice del producto a eliminar:");
                    int indiceElim = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    if (indiceElim >= 0 && indiceElim < tienda.getProductos().size()) {
                        tienda.eliminarProducto(indiceElim);
                        System.out.println("Producto eliminado con éxito.");
                    } else {
                        System.out.println("Índice de producto inválido.");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese índice del producto a comprar:");
                    int indiceCompra = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    if (indiceCompra >= 0 && indiceCompra < tienda.getProductos().size()) {
                        Producto productoCompra = tienda.getProductos().get(indiceCompra);
                        System.out.println("Producto seleccionado: " + productoCompra.getNombre());
                        System.out.println("Ingrese cantidad a comprar:");
                        int cantidadCompra = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        tienda.realizarCompra(indiceCompra, cantidadCompra);
                    } else {
                        System.out.println("Índice de producto inválido.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);

        scanner.close(); // Cerrar el scanner al final
    }
}
