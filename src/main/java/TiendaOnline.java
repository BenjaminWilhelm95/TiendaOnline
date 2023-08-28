import java.util.ArrayList;
import java.util.List;

public class TiendaOnline {
    private List<Producto> productos;

    public TiendaOnline() {
        productos = new ArrayList<>();
    }

    public void mostrarProductos() {
        System.out.println("Productos disponibles:");
        for (Producto producto : productos) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Stock: " + producto.getStock());
            System.out.println("Categoría: " + producto.getCategoria());
            System.out.println("----------------------");
        }
    }

    public void buscarProducto(String busqueda) {
        System.out.println("Resultados de búsqueda:");
        for (Producto producto : productos) {
            if (producto.getNombre().toLowerCase().contains(busqueda.toLowerCase()) ||
                    producto.getCategoria().toLowerCase().contains(busqueda.toLowerCase())) {
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Descripción: " + producto.getDescripcion());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("Stock: " + producto.getStock());
                System.out.println("Categoría: " + producto.getCategoria());
                System.out.println("----------------------");
            }
        }
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void modificarProducto(int indice, Producto producto) {
        if (indice >= 0 && indice < productos.size()) {
            productos.set(indice, producto);
        }
    }

    public void eliminarProducto(int indice) {
        if (indice >= 0 && indice < productos.size()) {
            productos.remove(indice);
        }
    }

    public void realizarCompra(int indice, int cantidad) {
        if (indice >= 0 && indice < productos.size()) {
            Producto producto = productos.get(indice);
            if (producto.getStock() >= cantidad) {
                producto.setStock(producto.getStock() - cantidad);
                System.out.println("Compra realizada. Total a pagar: " + (producto.getPrecio() * cantidad));
            } else {
                System.out.println("No hay suficiente stock disponible.");
            }
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
